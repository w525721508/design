package design.com.design.db;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import design.com.design.entity.UserEntity;

/**
 * Created by Administrator on 2018/1/25.
 */
@Database(entities = {UserEntity.class}, version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract UserEntityDao userEntityDao();
}
