package design.custom.ui.main.fragment;


import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.root.base.databinding.FragmentOrderBinding;
import design.custom.ui.main.MainPresenter;

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
