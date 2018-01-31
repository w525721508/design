package design.root.ui.main.fragment;


import design.root.R;
import design.root.base.BaseFragment;
import design.root.databinding.FragmentMyBinding;
import design.root.ui.main.MainPresenter;

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

    }
}
