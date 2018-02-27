package design.root.base.ui.sign;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;

import design.root.base.R;
import design.root.base.base.BaseActivity;
import design.root.base.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel, ActivityLoginBinding>
        implements LoginContract.View {
    //当前主题
    public int nowTheme = 0;
    public int signResSelected[][] = new int[][]{{R.mipmap.login_username2, R.mipmap.login_pwd02}};
    public int SignResUnSelected[][] = new int[][]{{R.mipmap.login_username1, R.mipmap
            .login_pwd01}};
    public int registeredResSelected[][] = new int[][]{{R.mipmap.login_username2, R.mipmap
            .login_pwd02, R.mipmap.login_cipher_04}};
    public int RegisteredResUnSelected[][] = new int[][]{{R.mipmap.login_username1, R.mipmap
            .login_pwd01, R.mipmap.login_cipher_03}};
    public int inputPasswordResSelected[][] = new int[][]{{R.mipmap.login_username2, R.mipmap
            .login_pwd02, R.mipmap.login_cipher_04}};
    public int inputPasswordResUnSelected[][] = new int[][]{{R.mipmap.login_username1, R.mipmap
            .login_pwd01, R.mipmap.login_cipher_03}};
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
        if (startActivity != null) {
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

