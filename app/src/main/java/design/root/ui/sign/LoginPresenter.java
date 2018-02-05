package design.root.ui.sign;


import design.root.entity.User;
import design.root.ui.interfaces.NetCallBack;
import design.root.ui.sign.fragment.InputPasswordFragment;
import design.root.ui.sign.fragment.RegisteredFragment;
import design.root.ui.sign.fragment.SignFragment;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginPresenter extends design.root.ui.sign.LoginContract.Presenter {
    public SignFragment signFragment = new SignFragment();
    public RegisteredFragment registeredFragment = new RegisteredFragment();
    public InputPasswordFragment inputPasswordFragment = new InputPasswordFragment();


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
            mModel.register(userName, PwdOne, new NetCallBack<String>() {
                @Override
                public void succ(String userEntity) {
                    mView.registerSucc("注册成功");
                }

                @Override
                public void error(String str) {
                    mView.error(str);
                }
            });


        }
    }

    @Override
    public void sign(String userName, String pwd) {
        mModel.sign(userName, pwd, new NetCallBack<User>() {
            @Override
            public void succ(User userEntity) {
                mView.signSucc();
            }

            @Override
            public void error(String str) {
                mView.error("账户密码错误");
            }
        });
    }
}
