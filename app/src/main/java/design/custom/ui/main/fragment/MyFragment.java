package design.custom.ui.main.fragment;


import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.custom.ui.main.MainPresenter;
import design.root.databinding.FragmentMyBinding;

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
