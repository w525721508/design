package design.root.ui.sign;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;

import design.root.R;
import design.root.base.BaseActivity;
import design.root.databinding.ActivityLoginBinding;
import design.root.ui.main.MainActivity;

public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel, ActivityLoginBinding>
        implements  LoginContract.View {

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
//        SelectDialog selectDialog = new SelectDialog();
//        selectDialog.setContent("确定登录");
//        selectDialog.show(LoginActivity.this);
        ToastUtils.showLong(toastMsg);
    }

    @Override
    public void registerSucc(String toastMsg) {
        ToastUtils.showLong(toastMsg);
        pop();
    }

    @Override
    public void signSucc() {
        ActivityUtils.startActivity(MainActivity.class);
        ActivityUtils.finishActivity(LoginActivity.class);
    }


    @Override
    public void error(String errorMsg) {
        ToastUtils.showLong(errorMsg);
    }
}

