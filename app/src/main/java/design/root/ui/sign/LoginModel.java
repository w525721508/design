package design.root.ui.sign;

import design.root.db.DbHelper;
import design.root.entity.UserEntity;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginModel extends design.root.ui.sign.LoginContract.Model {


    @Override
    public boolean register(String userName, String PwdOne) {
        UserEntity userEntity = new UserEntity();
        userEntity.setPhone(userName);
        userEntity.setPwd(PwdOne);
        DbHelper.getInstance().insertUserEntity(userEntity);
        return true;
    }

    @Override
    public boolean sign(String userName, String pwd) {
        return DbHelper.getInstance().queryUserEntity(userName, pwd);
    }
}
