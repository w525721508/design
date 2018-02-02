package design.root.ui.sign;

import com.blankj.utilcode.util.LogUtils;

import design.root.api.ApiFactory;
import design.root.db.DbHelper;
import design.root.entity.UserEntity;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginModel extends design.root.ui.sign.LoginContract.Model {


    @Override
    public boolean register(String userName, String PwdOne) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userName);
        userEntity.setPassword(PwdOne);
        DbHelper.getInstance().insertUserEntity(userEntity);
        return true;
    }

    @Override
    public boolean sign(String userName, String pwd) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userName);
        userEntity.setPassword(pwd);
        ApiFactory.Login.login(userEntity).subscribe(new Consumer<UserEntity>() {
            @Override
            public void accept(UserEntity userEntity) throws Exception {
                LogUtils.e(userEntity.toString());
            }
        }, throwable -> {

        });
        return true;
    }
}
