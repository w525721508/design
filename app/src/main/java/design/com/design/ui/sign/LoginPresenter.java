package design.com.design.ui.sign;

import design.com.design.ui.sign.fragment.SignFragment;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginPresenter extends LoginContract.Presenter {
    public SignFragment signFragment = new SignFragment();

    @Override
    public void checkUserNameAndPwd(String userName, String pwd) {
        if (mModel.isNull(userName, pwd)) {
            mView.showToast("输入数据为null");
        } else {
            mView.showToast("校验成功");
        }
    }

    @Override
    public void init() {

    }

    @Override
    public void onDestroy() {

    }
}
