package design.com.design.ui.sign;

import design.com.design.ui.sign.fragment.RegisteredFragment;
import design.com.design.ui.sign.fragment.SignFragment;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginPresenter extends LoginContract.Presenter {
    public SignFragment signFragment = new SignFragment();
    public RegisteredFragment registeredFragment = new RegisteredFragment();


    @Override
    public void init() {

    }

    @Override
    public void onDestroy() {

    }

    @Override
    public void register(String userName, String PwdOne, String pwdTwo) {
        if (mModel.isNull(userName, PwdOne, pwdTwo)) {
            mView.showToast("注册数据不能为空");
        } else {
            if (mModel.register(userName, PwdOne)) {
                mView.registerSucc("注册成功");
            }
        }
    }

    @Override
    public void sign(String userName, String pwd) {
        if (mModel.sign(userName, pwd)) {
            mView.signSucc();
        } else {
            mView.error("账户密码错误");
        }
    }
}
