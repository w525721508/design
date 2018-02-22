package com.tzduan.base.ui.main.fragment;


import com.tzduan.base.R;
import com.tzduan.base.base.BaseFragment;
import com.tzduan.base.databinding.FragmentOrderBinding;
import com.tzduan.base.ui.main.MainPresenter;

/**
 * Created by Administrator on 2018/1/26.
 */

public class OrderFragment extends BaseFragment<MainPresenter, FragmentOrderBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_order;
    }

    @Override
    public void initView() {
        mViewBinding.ic.tvTitle.setText("订单");
    }
}
