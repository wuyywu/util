package com.github.commonutils.createobject;

import java.lang.reflect.InvocationTargetException;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/12/18 11:32
 */
public class TestInstanceInner {

    public static void main(String[] args) throws Exception {
        TestInstanceInner testInstanceInner = new TestInstanceInner();
        testInstanceInner.test1();
    }

    public void test1() throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        TestInstanceInner testInstanceInner = (TestInstanceInner)Class.forName("com.github.commonutils.createobject.TestInstanceInner").newInstance();
        System.out.println(testInstanceInner.toString());

        User user = (User)Class.forName("com.github.commonutils.createobject.TestInstanceInner$User").getDeclaredConstructor(TestInstanceInner.class).newInstance(this);
        System.out.println(user.toString());
    }

    class User{
        private int id;
        private String name;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    '}';
        }
    }
}
