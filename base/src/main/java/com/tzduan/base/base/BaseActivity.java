package com.tzduan.base.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;

import java.lang.reflect.ParameterizedType;

import com.tzduan.base.util.InstanceUtil;
import me.yokeyword.fragmentation.ISupportFragment;
import me.yokeyword.fragmentation.SupportActivity;

/**
 * Created by Administrator on 2018/1/19.
 */

public abstract class BaseActivity<P extends com.tzduan.base.base.BasePresenter, M extends BaseModel, B extends
        ViewDataBinding> extends
        SupportActivity {
    public P mPresenter;
    public B mViewBinding;
    private M mModel;
    private long mTime = 0;

    public abstract int getLayoutId();

    static {
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true);
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        View rootView = getLayoutInflater().inflate(getLayoutId(), null, false);
        mViewBinding = DataBindingUtil.bind(rootView);
        super.setContentView(rootView);
        initPresenter();
        initView();
    }

    protected void initPresenter() {
        if (this instanceof com.tzduan.base.base.BaseView && this.getClass()
                .getGenericSuperclass() instanceof
                ParameterizedType
                && ((ParameterizedType) (this.getClass().getGenericSuperclass()))
                .getActualTypeArguments().length > 0) {
            Class mPresenterClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[0];
            mPresenter = InstanceUtil.getInstance(mPresenterClass);
            Class mModelClass = (Class) ((ParameterizedType) (this.getClass()
                    .getGenericSuperclass())).getActualTypeArguments()[1];
            mModel = InstanceUtil.getInstance(mModelClass);
            mPresenter.setView(this, mModel);
        }
    }

    public abstract void initView();

    @Override
    public void start(ISupportFragment toFragment) {
        if ((System.currentTimeMillis() - mTime) > 500) {
            mTime = System.currentTimeMillis();
            super.start(toFragment);
        }
    }

    @Override
    protected void onDestroy() {
        if (mPresenter != null) mPresenter.onDestroy();
        super.onDestroy();
    }

}
