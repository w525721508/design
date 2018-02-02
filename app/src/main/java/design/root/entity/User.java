package design.root.entity;


import design.root.entity.annotation.FishColumn;
import design.root.entity.annotation.FishTable;

/**
 * 用户类
 *
 * @author fish.leong@msn.com
 */
@FishTable(tableName = "users")
public class User extends SuperBean {

    @FishColumn(column = "username", pk = true)
    private String username;// 用户名
    @FishColumn(column = "password")
    private String password;// 密码
    @FishColumn(column = "sex")
    private String sex;// 性别
    @FishColumn(column = "mobile")
    private String mobile;// 手机号
    @FishColumn(column = "age")
    private int age;// 年龄

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

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
