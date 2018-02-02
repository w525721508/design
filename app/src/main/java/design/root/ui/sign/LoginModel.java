package design.root.ui.sign;

import com.blankj.utilcode.util.LogUtils;

import design.root.api.ApiFactory;
import design.root.db.DbHelper;
import design.root.entity.UserEntity;
import design.root.ui.interfaces.NetCallBack;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginModel extends LoginContract.Model {


    @Override
    public void register(String userName, String PwdOne, NetCallBack netCallBack) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userName);
        userEntity.setPassword(PwdOne);
        DbHelper.getInstance().insertUserEntity(userEntity);
    }

    @Override
    public void sign(String userName, String pwd, NetCallBack netCallBack) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userName);
        userEntity.setPassword(pwd);
        ApiFactory.Login.login(userEntity).subscribe(new Consumer<UserEntity>() {
            @Override
            public void accept(UserEntity userEntity) throws Exception {
                netCallBack.succ(userEntity);
                LogUtils.e(userEntity.toString());
            }
        }, throwable -> {

        });
    }
}
