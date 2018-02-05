package design.root.entity;

import com.google.gson.Gson;

import org.junit.Test;

/**
 * SuperBean实体Demo测试
 * Created by Leong on 2018/2/2.
 */

public class SuperBeanTest {
    @Test
    public static void main(String[] args) {
        User user = new User();
        user.setAge(15);
        user.setMobile("10086");
        user.setUsername("嘿嘿");
        user.setPassword("123456");
        user.setSex("保密");
        try {
            user.toAddData();//新增
            System.out.println(new Gson().toJson(user));//得到json数据
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}
