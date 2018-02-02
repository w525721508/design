package design.root.entity;

/**
 * @author fish.leong@msn.com
 */
public class TestFish {

    public static void main(String[] args) {
        User user = new User();
        user.setAge(15);
        user.setMobile("10086");
        user.setUsername("嘿嘿");
        user.setPassword("123456");
        user.setSex("保密");
        try {
            System.out.println(user.getUpdateData());
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

}
