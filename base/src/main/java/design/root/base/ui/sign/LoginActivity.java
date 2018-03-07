package design.root.base.ui.sign;

import com.blankj.utilcode.util.ActivityUtils;
import com.blankj.utilcode.util.ToastUtils;

import design.root.base.R;
import design.root.base.base.BaseActivity;
import design.root.base.databinding.ActivityLoginBinding;


public class LoginActivity extends BaseActivity<LoginPresenter, LoginModel, ActivityLoginBinding>
        implements LoginContract.View {
    //当前主题
    public static int nowTheme = 1;
    public static int signResSelected[][] = new int[][]{{R.mipmap.username02, R.mipmap.pwd02}, {R
            .mipmap.username04, R.mipmap.pwd04}};
    public static int SignResUnSelected[][] = new int[][]{{R.mipmap.username01, R.mipmap
            .pwd01}, {R.mipmap.username03, R.mipmap.pwd03}};
    public static int registeredResSelected[][] = new int[][]{{R.mipmap.username02, R.mipmap
            .pwd02, R.mipmap.pwds02, R.mipmap.email02, R.mipmap.address02}, {R.mipmap.username04,
            R.mipmap.pwd04, R.mipmap.pwds04, R.mipmap.email04, R.mipmap.address04}};

    public static int RegisteredResUnSelected[][] = new int[][]{{R.mipmap.username01, R.mipmap
            .pwd01, R.mipmap.pwds01, R.mipmap.email01, R.mipmap.address01}, {R.mipmap.username03,
            R.mipmap.pwd03, R.mipmap.pwds03, R.mipmap.email03, R.mipmap.address03}};


    public static int inputPasswordResSelected[][] = new int[][]{{R.mipmap.username02, R.mipmap
            .pwd02, R.mipmap.pwds02}, {R.mipmap.username04, R.mipmap.pwd04, R.mipmap.pwds04}};
    public static int inputPasswordResUnSelected[][] = new int[][]{{R.mipmap.username01, R.mipmap
            .pwd01, R.mipmap.pwds01}, {R.mipmap.username03, R.mipmap.pwd03, R.mipmap.pwds03}};

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

