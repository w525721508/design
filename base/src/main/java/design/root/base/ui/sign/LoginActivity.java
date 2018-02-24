package design.root.base.ui.sign;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;

import design.root.base.R;
import design.root.base.base.BaseActivity;
import design.root.base.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel, ActivityLoginBinding>
        implements LoginContract.View {

    private Class startClass;

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
        closeLoading();
        ToastUtils.showLong(toastMsg);
        pop();
    }

    @Override
    public void signSucc() {
        closeLoading();
        Class startActivity = null;
        try {
            startActivity = Class.forName("design.custom.ui.main.MainActivity");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if (startActivity != null){
            ActivityUtils.startActivity(startActivity);
        }
        ActivityUtils.finishActivity(LoginActivity.class);
    }

    @Override
    public void chagePwdSucc() {
        closeLoading();
        ToastUtils.showLong("修改成功");
        pop();
    }


    @Override
    public void error(String errorMsg) {
        closeLoading();
        ToastUtils.showLong(errorMsg);
    }
}

