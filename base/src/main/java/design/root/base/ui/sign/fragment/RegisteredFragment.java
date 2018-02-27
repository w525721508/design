package design.root.base.ui.sign.fragment;

import android.view.View;

import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.root.base.databinding.FragmentRegisteredBinding;
import design.root.base.ui.sign.LoginPresenter;


/**
 * Created by Administrator on 2018/1/25.
 */

public class RegisteredFragment extends BaseFragment<LoginPresenter,
        FragmentRegisteredBinding> {
    @Override
    protected int getLayoutId() {
        return R.layout.fragment_registered;
    }

    @Override
    public void initView() {
        mViewBinding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int i = v.getId();
                if (i == R.id.btn_register) {
                    mPresenter.register(mViewBinding.etPhone.getText().toString(),
                            mViewBinding.etPwdOne.getText().toString(), mViewBinding.etPwdTwo
                                    .getText().toString());

                } else {

                }
            }
        });
        setView(mViewBinding.etPhone, R.mipmap.login_username2, R.mipmap
                .login_username1);
        setView(mViewBinding.etPwdOne, R.mipmap.login_pwd02, R.mipmap
                .login_pwd01);
        setView(mViewBinding.etPwdTwo, R.mipmap.login_cipher_04, R.mipmap
                .login_cipher_03);
    }
}
