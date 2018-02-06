package design.root.ui.sign;

import com.blankj.utilcode.util.LogUtils;

import design.root.api.ApiFactory;
import design.root.entity.UserEntity;
import design.root.ui.interfaces.NetCallBack;
import io.reactivex.functions.Consumer;

/**
 * Created by Administrator on 2018/1/22.
 */

public class LoginModel extends LoginContract.Model {


    @Override
    public void register(String userName, String PwdOne, NetCallBack netCallBack) {
        UserEntity user = new UserEntity();
        user.setUsername(userName);
        user.setPassword(PwdOne);
        user.setAge("15");
        user.setMobile("10086");
        user.setSex("保密");
//        try {
            user.toAddData();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        ApiFactory.UserApi.superUser(user).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                netCallBack.succ(s);
            }
        }, throwable -> {
            netCallBack.error(throwable.getMessage());
        });

//        DbHelper.getInstance().insertUser(user);
    }

    @Override
    public void sign(String userName, String pwd, NetCallBack netCallBack) {
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userName);
        userEntity.setPassword(pwd);
        ApiFactory.UserApi.login(userEntity).subscribe(new Consumer<UserEntity>() {
            @Override
            public void accept(UserEntity userEntity) throws Exception {
                netCallBack.succ(userEntity);
                LogUtils.e(userEntity.toString());
            }
        }, throwable -> {
            netCallBack.error(throwable.getMessage());
        });
    }

//    @Override
    public void changePwd(String username, String PwdOne, String PwdTwo, NetCallBack netCallBack) {
        UserEntity user = new UserEntity();
        user.setUsername(username);
        user.setPassword(PwdTwo);
        user.setAge("15");
        user.setMobile("10086");
        user.setSex("保密");
//        try {
            user.toUpdateData();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        }
        ApiFactory.UserApi.superUser(user).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                netCallBack.succ(s);
            }
        }, throwable -> {
            netCallBack.error(throwable.getMessage());
        });
    }
}
