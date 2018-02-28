package design.root.base.base;

import android.content.Context;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.KeyboardUtils;

import me.yokeyword.fragmentation.SupportFragment;

/**
 * Created by Administrator on 2018/1/24.
 */

public abstract class BaseFragment<P extends BasePresenter, B extends
        ViewDataBinding> extends
        SupportFragment {
    public P mPresenter;
    public B mViewBinding;
    public Context mContext;

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    protected abstract int getLayoutId();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable
            Bundle savedInstanceState) {
        mContext = ActivityUtils.getTopActivity();
        mPresenter = (P) ((BaseActivity) getActivity()).mPresenter;

        return createFragment(inflater, container);
    }

    private View createFragment(LayoutInflater inflater, @Nullable ViewGroup container) {
        mViewBinding = DataBindingUtil.inflate(inflater, getLayoutId(), container, false);
        initView();
        return mViewBinding.getRoot();
    }


    public abstract void initView();

    @Override
    public void onDetach() {
        super.onDetach();
        KeyboardUtils.hideSoftInput(getActivity());
    }

    public void startLoading() {
        BaseActivity.loadingDialog.show((BaseActivity) getActivity());
    }

    public void closeLoading() {
        BaseActivity.loadingDialog.dismiss();
    }

    public CharSequence getTabTitle() {
        return null;
    }

    public void setView(EditText view, int select, int unSelect) {
        Resources res = getResources();
        Drawable img_off = res.getDrawable(unSelect);
        img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
        view.setCompoundDrawables(img_off, null, null, null);
        view.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean b) {
                switchIcon(view, b, select, unSelect, res, img_off);
            }
        });
    }

    public void switchIcon(EditText view, Boolean b, int iconIdOne, int iconTwo, Resources res,
                           Drawable img_off) {
        if (b) {
            img_off = res.getDrawable(iconIdOne);
        } else {
            img_off = res.getDrawable(iconTwo);
        }
        img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
        view.setCompoundDrawables(img_off, null, null, null);
    }
}
