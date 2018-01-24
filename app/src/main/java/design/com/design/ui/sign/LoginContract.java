package design.com.design.ui.sign;

import design.com.design.base.BaseModel;
import design.com.design.base.BasePresenter;
import design.com.design.base.BaseView;

/**
 * Created by Administrator on 2018/1/22.
 */

public interface LoginContract {
    interface View extends BaseView {
        abstract void showToast(String toastMsg);
    }

    abstract class Model extends BaseModel {

    }

    abstract class Presenter extends BasePresenter<View, Model> {
        public abstract void checkUserNameAndPwd(String userName, String Pwd);
    }


}
