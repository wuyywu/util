package com.hundsun.inttest;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/12/17 15:28
 */
public class IntTest {

    public static void main(String[] args) {
        IntTest intTest = new IntTest();
        intTest.test();
    }

    public void test(){
        User user = new User();
        user.setAge(null);
        user.setId(user.getAge());
    }
}
