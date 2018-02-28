package design.root.base.ui.sign.fragment;

import android.text.InputFilter;
import android.text.InputType;

import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.root.base.databinding.FragmentInputPasswordBinding;
import design.root.base.ui.sign.LoginActivity;
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
        setView(mViewBinding.etPhone, LoginActivity.inputPasswordResSelected[LoginActivity
                .nowTheme][0], LoginActivity.inputPasswordResUnSelected[LoginActivity.nowTheme][0]);
        setView(mViewBinding.etOnePassword, LoginActivity.inputPasswordResSelected[LoginActivity
                .nowTheme][1], LoginActivity.inputPasswordResUnSelected[LoginActivity.nowTheme][1]);
        setView(mViewBinding.etTwoPassword, LoginActivity.inputPasswordResSelected[LoginActivity
                .nowTheme][2], LoginActivity.inputPasswordResUnSelected[LoginActivity.nowTheme][2]);
    }

}
