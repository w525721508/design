package design.com.design.ui.sign.fragment;

import android.view.View;

import design.com.design.R;
import design.com.design.base.BaseFragment;
import design.com.design.databinding.FragmentSignBinding;
import design.com.design.ui.sign.LoginPresenter;

/**
 * Created by Administrator on 2018/1/24.
 */

public class SignFragment extends BaseFragment<LoginPresenter, FragmentSignBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_sign;
    }

    @Override
    public void initView() {
        mViewBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn: {
                        mPresenter.checkUserNameAndPwd("123", "456");
                    }
                    break;
                    default: {

                    }
                    break;
                }
            }
        });
    }
}
