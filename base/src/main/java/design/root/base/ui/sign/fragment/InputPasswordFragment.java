package design.root.base.ui.sign.fragment;

import android.text.InputFilter;
import android.text.InputType;

import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.root.base.databinding.FragmentInputPasswordBinding;
import design.root.base.ui.sign.LoginPresenter;

/**
 */
public class InputPasswordFragment extends BaseFragment<LoginPresenter,
        FragmentInputPasswordBinding> {
    private String onePwd;
    private String twoPwd;
    //找回密码发验证码为1，注册发验证码为2
    int startway = -1;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_input_password;
    }


    @Override
    public void initView() {
        InputFilter[] inputFilter = new InputFilter[]{new InputFilter.LengthFilter(6)};
        mViewBinding.etOnePassword.setInputType(InputType.TYPE_CLASS_NUMBER | InputType
                .TYPE_NUMBER_VARIATION_PASSWORD);
        mViewBinding.etOnePassword.setFilters(inputFilter);
        mViewBinding.etTwoPassword.setInputType(InputType.TYPE_CLASS_NUMBER | InputType
                .TYPE_NUMBER_VARIATION_PASSWORD);
        mViewBinding.etTwoPassword.setFilters(inputFilter);
        mViewBinding.setOnClickListener(view -> {
            int i = view.getId();
            if (i == R.id.btn_next) {
                mPresenter.changePwd(mViewBinding.etPhone.getText().toString(), mViewBinding
                        .etOnePassword.getText().toString(), mViewBinding.etTwoPassword
                        .getText().toString());

            } else if (i == R.id.tv_existing_account) {
                pop();

            }
        });
        setView(mViewBinding.etPhone, R.mipmap.login_username2, R.mipmap
                .login_username1);
        setView(mViewBinding.etOnePassword, R.mipmap.login_pwd02, R.mipmap
                .login_pwd01);
        setView(mViewBinding.etTwoPassword, R.mipmap.pwd_two02, R.mipmap
                .pwd_two01);
    }

}
