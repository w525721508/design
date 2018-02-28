package design.root.base.ui.sign.fragment;

import android.view.View;

import design.root.base.R;
import design.root.base.base.BaseFragment;
import design.root.base.databinding.FragmentSignBinding;
import design.root.base.ui.sign.LoginActivity;
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
        setView(mViewBinding.etPhone, LoginActivity.signResSelected[LoginActivity
                .nowTheme][0], LoginActivity.SignResUnSelected[LoginActivity.nowTheme][0]);
        setView(mViewBinding.etPwd, LoginActivity.signResSelected[LoginActivity
                .nowTheme][1], LoginActivity.SignResUnSelected[LoginActivity.nowTheme][1]);

    }


}
