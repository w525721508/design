package design.root.ui.sign.fragment;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.InputFilter;
import android.text.InputType;
import android.view.View;

import com.blankj.utilcode.util.ToastUtils;

import design.root.R;
import design.root.base.BaseFragment;
import design.root.databinding.FragmentInputPasswordBinding;
import design.root.ui.sign.LoginPresenter;
import design.root.util.OnClickListener;

/**
 * 输入密码界面
 * <p>
 * 注册第二步输入密码界面
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
        mViewBinding.icTitle.tvTitle.setText("输入密码");
        mViewBinding.icTitle.setOnClickListener(new OnClickListener() {
            @Override
            protected void myOnClickListener(View v) {
                pop();
            }
        });
        InputFilter[] inputFilter = new InputFilter[]{new InputFilter.LengthFilter(6)};
        mViewBinding.etOnePassword.setInputType(InputType.TYPE_CLASS_NUMBER | InputType
                .TYPE_NUMBER_VARIATION_PASSWORD);
        mViewBinding.etOnePassword.setFilters(inputFilter);
        mViewBinding.etTwoPassword.setInputType(InputType.TYPE_CLASS_NUMBER | InputType
                .TYPE_NUMBER_VARIATION_PASSWORD);
        mViewBinding.etTwoPassword.setFilters(inputFilter);
        mViewBinding.setOnClickListener(view -> {
            switch (view.getId()) {
                case R.id.btn_next: {
                    if (checkPwd()) {
                        if (checkLenth()) {
//                            mPresenter.getLoginBean().setPwd(mViewBinding.etOnePassword
//                                    .getText()
//                                    .toString());
//                            mPresenter.createStoreFragment.setStartway(1);
//                            start(mPresenter.createStoreFragment);
                        } else {
                            ToastUtils.showLong("密码必须为6位的数字");
                        }
                    } else {
                        ToastUtils.showLong("密码输入为空，或者两次密码输入不一致");
                    }
                }
                break;
                case R.id.tv_existing_account: {
                    try {
//                        popTo(mPresenter.signInFragment.getClass(), false);
                    } catch (Exception e) {

                    }
                }
                break;
                default: {

                }
                break;
            }
        });
        mViewBinding.etOnePassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Resources res = getResources();
                Drawable img_off;
                if (b) {
                    img_off = res.getDrawable(R.mipmap.login_pwd02);
                    img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
                    mViewBinding.etOnePassword.setCompoundDrawables(img_off, null, null, null);
                } else {
                    img_off = res.getDrawable(R.mipmap.login_pwd01);
                    img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
                    mViewBinding.etOnePassword.setCompoundDrawables(img_off, null, null, null);
                }
            }
        });
        mViewBinding.etTwoPassword.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View view, boolean b) {
                Resources res = getResources();
                Drawable img_off;
                if (b) {
                    img_off = res.getDrawable(R.mipmap.pwd_two02);
                    img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
                    mViewBinding.etTwoPassword.setCompoundDrawables(img_off, null, null, null);
                } else {
                    img_off = res.getDrawable(R.mipmap.pwd_two01);
                    img_off.setBounds(0, 0, img_off.getMinimumWidth(), img_off.getMinimumHeight());
                    mViewBinding.etTwoPassword.setCompoundDrawables(img_off, null, null, null);
                }
            }
        });
    }

    public void setStartway(int _startWay) {
        startway = _startWay;
    }

    private boolean checkPwd() {
        onePwd = mViewBinding.etOnePassword.getText().toString();
        twoPwd = mViewBinding.etTwoPassword.getText().toString();
        return !(onePwd.isEmpty() || twoPwd.isEmpty() || (!(onePwd.equals(twoPwd))));
    }

    private boolean checkLenth() {
        return !(onePwd.length() < 6 || twoPwd.length() < 6);
    }
}
