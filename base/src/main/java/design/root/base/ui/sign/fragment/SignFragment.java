package design.root.base.ui.sign.fragment;

import android.view.View;

import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.root.base.databinding.FragmentSignBinding;
import design.root.base.ui.sign.LoginPresenter;


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
                int i = v.getId();
                if (i == R.id.btn_login) {
                    mPresenter.sign(mViewBinding.etPhone.getText().toString(), mViewBinding
                            .etPwd.getText().toString());

                } else if (i == R.id.tv_signUp) {
                    start(mPresenter.registeredFragment);

                } else if (i == R.id.tv_forgotPassword) {
                    start(mPresenter.inputPasswordFragment);
                }
            }
        });
        setView(mViewBinding.etPhone, R.mipmap.login_username2, R.mipmap
                .login_username1);
        setView(mViewBinding.etPwd, R.mipmap.login_pwd02, R.mipmap
                .login_pwd01);

    }


}
