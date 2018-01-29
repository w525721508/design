package design.com.design.ui.main.fragment;

import design.com.design.R;
import design.com.design.base.BaseFragment;
import design.com.design.databinding.FragmentOrderBinding;
import design.com.design.ui.main.MainPresenter;

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

    }
}
