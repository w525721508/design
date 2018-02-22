package com.tzduan.base.db;

import android.arch.persistence.room.Room;

import com.tzduan.base.App;
import com.tzduan.base.entity.UserEntity;

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

}
