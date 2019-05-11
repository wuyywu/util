package com.hundsun.thread;

import com.hundsun.inttest.User;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/3/14 9:44
 */
public class ThreadTest {

    private static InheritableThreadLocal<String> InheritableThreadLocal = new InheritableThreadLocal();

    public static void main(String[] args) throws UnsupportedEncodingException {
        List<User> autoTaskResultList = new ArrayList();
        autoTaskResultList.add(new User(1, "jack1", 16));
        autoTaskResultList.add(new User(2, "jack2", 17));
        autoTaskResultList.add(new User(3, "jack3", 17));



        List<User> list = autoTaskResultList.stream().filter(result ->
                result.getName().equals("jack2") || result.getName().equals("jack3")).collect(Collectors.toList());

        System.out.println(list);

        System.out.println("20180101123456".substring(0, 8));

//        System.out.println(Thread.currentThread() + "主线程");
//        int a = 1/4;
//        long fixLength = 12L;
//        String content = "投机有道系你吗的我的天啊";
//
//        StringBuffer sb = new StringBuffer();
//        byte[] array = content.getBytes("UTF-8");
//        for (int i=0; i<fixLength; i++){
//            sb.append(array[i]);
//        }
//
//        System.out.println(sb.toString());
//        InheritableThreadLocal.set("123");
//        new Thread(new A()).start();
    }

    static class A implements Runnable {

        @Override
        public void run() {
            System.out.println(InheritableThreadLocal.get());
            System.out.println(Thread.currentThread() + "子线程");
        }
    }
}
