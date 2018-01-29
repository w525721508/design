package design.com.design.ui.sign;

import design.com.design.base.BaseModel;
import design.com.design.base.BasePresenter;
import design.com.design.base.BaseView;

/**
 * Created by Administrator on 2018/1/22.
 */

public interface LoginContract {
    interface View extends BaseView {
        void showToast(String toastMsg);

        //注册成功
        void registerSucc(String toastMsg);

        //登录成功
        void signSucc();
    }

    abstract class Model extends BaseModel {
        //注册数据操作
        public abstract boolean register(String userName, String PwdOne);

        //登录验证操作
        public abstract boolean sign(String userName, String Pwd);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //注册
        public abstract void register(String userName, String PwdOne, String pwdTwo);

        //登录
        public abstract void sign(String userName, String Pwd);
    }


}
