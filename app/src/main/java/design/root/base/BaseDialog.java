package design.root.base;

import android.content.Context;
import android.content.DialogInterface;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.app.AppCompatDialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.KeyboardUtils;
import com.blankj.utilcode.util.LogUtils;
import com.blankj.utilcode.util.ScreenUtils;

import java.util.concurrent.TimeUnit;

import design.root.R;
import design.root.databinding.DialogBaseBinding;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;

/**
 * Created by Administrator on 2018/1/23.
 */

public abstract class BaseDialog<P extends  BasePresenter, B extends
        ViewDataBinding> extends
        AppCompatDialogFragment {
    private DialogBaseBinding mBaseBinding;
    public P mPresenter;
    public B mViewBinding;
    public Context mContext;
    public boolean isShow;
    private Disposable mDisp;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    public abstract int getLayoutId();

    public BaseDialog() {
        this.mContext = getActivity();
    }

    public int getTitle() {
        return R.string.all_dialog;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        WindowManager.LayoutParams attributes = getDialog().getWindow().getAttributes();
        attributes.width = ScreenUtils.getScreenWidth() * 95 / 100;
        attributes.height = -2;
        getDialog().getWindow().setAttributes(attributes);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        mContext = ActivityUtils.getTopActivity();
        mPresenter = (P) ((BaseActivity) getActivity()).mPresenter;
        return createDialog(inflater, container);
    }

    private View createDialog(LayoutInflater inflater, @Nullable ViewGroup container) {
        mBaseBinding = DataBindingUtil.inflate(inflater, R.layout.dialog_base, container, false);
        mBaseBinding.vsCenter.getViewStub().setLayoutResource(getLayoutId());
        mBaseBinding.vsCenter.getViewStub().setOnInflateListener((viewStub, view) -> mViewBinding
                = DataBindingUtil.bind(view));
        mBaseBinding.vsCenter.getViewStub().inflate();
        if (getTitle() < 0) {
            mBaseBinding.tvTitle.setVisibility(View.GONE);
        } else {
            mBaseBinding.tvTitle.setText(getTitle());
        }
        mBaseBinding.btnCancel.setOnClickListener(this::onCancelClick);
        mBaseBinding.btnOk.setOnClickListener(this::onOkClick);
        initView();
        return mBaseBinding.getRoot();
    }

    public void onCancelClick(View view) {
        KeyboardUtils.hideSoftInput(mViewBinding.getRoot());
        this.dismiss();
    }

    public void onOkClick(View view) {
        KeyboardUtils.hideSoftInput(mViewBinding.getRoot());
    }

    public abstract void initView();

    public void show(BaseActivity activity) {
        if (!isShow) {
            super.show(activity.getSupportFragmentManager(), this.getTag());
            isShow = true;
        }
    }

    public void show(BaseActivity activity, int recLen) {
        if (!isShow) {
            super.show(activity.getSupportFragmentManager(), this.getTag());
            isShow = true;
            io.reactivex.Observable.interval(0, 1, TimeUnit.SECONDS).take(recLen + 1).map(new Function<Long, Long>() {


                @Override
                public Long apply(Long aLong) throws Exception {
                    return recLen - aLong;
                }
            }).observeOn(AndroidSchedulers.mainThread()).doOnSubscribe(new Consumer<Disposable>() {
                @Override
                public void accept(Disposable disposable) throws Exception {
                    mDisp = disposable;
                }
            }).subscribe(new Observer<Long>() {
                @Override
                public void onSubscribe(Disposable d) {
                    mDisp = d;
                }

                @Override
                public void onNext(Long aLong) {
                    LogUtils.e("对话框将在" + aLong + "S后关闭");
                }

                @Override
                public void onError(Throwable e) {

                }

                @Override
                public void onComplete() {
                    dismiss();
                }
            });
        }
    }

    public void dismiss() {
        if (isShow) {
            super.dismiss();
        }
    }

    @Override
    public void onDismiss(DialogInterface dialog) {
        super.onDismiss(dialog);
        isShow = false;
        if (null != mDisp && (!mDisp.isDisposed())) {
            mDisp.dispose();
        }
    }

    public void setBtnName(String okStr, String cancelStr) {
        mBaseBinding.btnCancel.setText(cancelStr);
        mBaseBinding.btnOk.setText(okStr);
    }
}
