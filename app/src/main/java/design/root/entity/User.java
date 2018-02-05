package design.root.entity;


import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;

import design.root.base.SuperBean;
import design.root.supers.annotation.FishColumn;
import design.root.supers.annotation.FishTable;

/**
 * 用户类
 *
 * @author fish.leong@msn.com
 */
@FishTable(tableName = "users")
@Entity
public class User extends SuperBean {
    @FishColumn(column = "username", pk = true)
    @ColumnInfo(name = "username")
    private String username;// 用户名

    @FishColumn(column = "password")
    @ColumnInfo(name = "password")
    private String password;// 密码

    @FishColumn(column = "mobile")
    @ColumnInfo(name = "mobile")
    private String mobile;// 手机号

    @FishColumn(column = "sex")
    @ColumnInfo(name = "sex")
    private String sex;// 性别

    @FishColumn(column = "age")
    @ColumnInfo(name = "age")
    private String age;// 年龄

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

}
