package design.root.ui.main.fragment;


import design.root.R;
import design.root.base.BaseFragment;
import design.root.databinding.FragmentIndexBinding;
import design.root.ui.main.MainPresenter;

/**
 * Created by Administrator on 2018/1/26.
 */

public class IndexFragment extends BaseFragment<MainPresenter,
        FragmentIndexBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {

    }
}
