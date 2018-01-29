package design.com.design.ui.sign;

import design.com.design.entity.UserEntity;
import design.com.design.db.DbHelper;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginModel extends LoginContract.Model {


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
