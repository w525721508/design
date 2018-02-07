package design.root.ui.main.fragment;


import design.root.R;
import design.root.base.BaseFragment;
import design.root.databinding.FragmentOrderBinding;
import design.root.ui.main.MainPresenter;

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
