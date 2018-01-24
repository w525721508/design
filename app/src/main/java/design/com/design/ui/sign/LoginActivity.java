package design.com.design.ui.sign;

import com.blankj.utilcode.util.ToastUtils;

import design.com.design.R;
import design.com.design.base.BaseActivity;
import design.com.design.databinding.ActivityLoginBinding;
import design.com.design.ui.dialog.SelectDialog;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel, ActivityLoginBinding>
        implements LoginContract.View {

    @Override
    public int getLayoutId() {
        return R.layout.activity_login;
    }


    @Override
    public void initView() {
        loadRootFragment(R.id.fl, mPresenter.signFragment);
    }


    @Override
    public void showToast(String toastMsg) {
        SelectDialog selectDialog = new SelectDialog();
        selectDialog.setContent("确定登录");
        selectDialog.show(LoginActivity.this);
        ToastUtils.showLong(toastMsg);
    }


    @Override
    public void error(String errorMsg) {

    }
}

