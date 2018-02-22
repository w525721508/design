package com.tzduan.base.ui.main.fragment;


import com.tzduan.base.R;
import com.tzduan.base.base.BaseFragment;
import com.tzduan.base.databinding.FragmentMyBinding;
import com.tzduan.base.ui.main.MainPresenter;

/**
 * Created by Administrator on 2018/1/26.
 */

public class MyFragment extends BaseFragment<MainPresenter, FragmentMyBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_my;
    }

    @Override
    public void initView() {
        mViewBinding.ic.tvTitle.setText("我的");
    }
}
