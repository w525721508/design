package design.com.design.ui.sign.fragment;

import android.view.View;

import design.com.design.R;
import design.com.design.base.BaseFragment;
import design.com.design.databinding.FragmentRegisteredBinding;
import design.com.design.ui.sign.LoginPresenter;

/**
 * Created by Administrator on 2018/1/25.
 */

public class RegisteredFragment extends BaseFragment<LoginPresenter, FragmentRegisteredBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_registered;
    }

    @Override
    public void initView() {
        mViewBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()) {
                    case R.id.btn_register: {
                        mPresenter.register(mViewBinding.etPhone.getText().toString(),
                                mViewBinding.etPwdOne.getText().toString(), mViewBinding.etPwdTwo
                                        .getText().toString());
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
