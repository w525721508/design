package design.root.db;

import android.arch.persistence.room.Room;

import design.root.App;
import design.root.entity.UserEntity;
import design.root.entity.User;

/**
 * Created by Administrator on 2018/1/26.
 */

public class DbHelper {
    public static DbHelper dbHelper;
    public static AppDatabase db;

    public static AppDatabase getAppDatabaseInstance() {
        if (db == null) {
            db = Room.databaseBuilder(App.instance, AppDatabase.class, "db")
                    .allowMainThreadQueries().build();
        }
        return db;
    }

    public static DbHelper getInstance() {
        if (dbHelper == null) {
            dbHelper = new DbHelper();
        }
        return dbHelper;
    }

    public void insertUser(User user) {
        db = getAppDatabaseInstance();
        db.beginTransaction();
//        db.userDao().insert(user);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public void insertUserEntity(UserEntity userEntity) {
        db = getAppDatabaseInstance();
        db.beginTransaction();
        db.userEntityDao().insert(userEntity);
        db.setTransactionSuccessful();
        db.endTransaction();
    }

    public boolean queryUserEntity(String phone, String pwd) {
        db = getAppDatabaseInstance();
        return db.userEntityDao().checkUserName(phone, pwd).size() > 0;
    }

//    public boolean queryUser(String phone, String pwd) {
//        db = getAppDatabaseInstance();
//        return db.userDao().checkUserName(phone, pwd).size() > 0;
//    }
}
