package design.root.ui.sign;


import design.root.base.BaseModel;
import design.root.base.BasePresenter;
import design.root.base.BaseView;
import design.root.ui.interfaces.NetCallBack;

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
        public abstract void register(String userName, String PwdOne, NetCallBack netCallBack);

        //登录验证操作
        public abstract void sign(String userName, String Pwd, NetCallBack netCallBack);
    }

    abstract class Presenter extends BasePresenter<View, Model> {
        //注册
        public abstract void register(String userName, String PwdOne, String pwdTwo);

        //登录
        public abstract void sign(String userName, String Pwd);
    }


}
