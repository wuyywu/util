package com.hundsun.study;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/4/15 15:43
 */
public class Test {

    public static void main(String[] args){
/*        try {
            A a = A.class.newInstance();
            Method method = A.class.getMethod("setText", String.class);
            method.invoke(a, "Hello World!");
            System.out.println(a.toString());

            Class clazz = A.class;
            Class clazzA = a.getClass();
            try {
                A b = (A)Class.forName("A").newInstance();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }


        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }*/
//        String a = "2016-10-10 16:51:37".replaceAll(":", "").substring(11,17);
//        System.out.println(a);
//
//        long b = applyOrderTbRule(10L);
        String name = "吴云云嘻嘻哈哈我在马路边捡到一分钱把他交给";
        String id_no = "42900619910218429X";
        String cust_type = "1";
        String id_type = "1";
        String name1 = "云吴云";


        System.out.println(name.hashCode());
        System.out.println(name1.hashCode());

        System.out.println(id_no.hashCode());

        System.out.println(cust_type.hashCode());
        System.out.println(id_type.hashCode());


        MessageDigest digest = null;
        try {
            digest = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        byte[] a = name.getBytes();
        digest.update(Byte.parseByte(a.toString()));
        byte[] hash = digest.digest();
        String hashCode = hash.toString();

        System.out.println(hashCode);

    }

    public static Long applyOrderTbRule(Long itemId) {
        if (itemId == null) {
            return 0L;
        } else {
            // 规则与 DBRule 不一样
            return (itemId / 10) % 2;
        }
    }
}
