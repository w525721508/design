package design.com.design.ui.main.fragment;

import design.com.design.R;
import design.com.design.base.BaseFragment;
import design.com.design.databinding.FragmentIndexBinding;
import design.com.design.ui.main.MainPresenter;

/**
 * Created by Administrator on 2018/1/26.
 */

public class IndexFragment extends BaseFragment<MainPresenter, FragmentIndexBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_index;
    }

    @Override
    public void initView() {

    }
}
