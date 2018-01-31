package design.root.db;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import design.root.entity.UserEntity;

/**
 * Created by Administrator on 2018/1/25.
 */
@Dao
public interface UserEntityDao {
    @Query("SELECT * FROM UserEntity WHERE phone IN(:phone) And pwd IN(:pwd)")
    List<UserEntity> checkUserName(String phone, String pwd);

    @Insert
    void insert(UserEntity userEntity);
}
