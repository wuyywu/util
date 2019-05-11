package com.hundsun.thread;

import java.util.concurrent.CountDownLatch;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/4/14 15:58
 */
public class ThreadCasTest {

    private  static volatile int i = 0;
    private static CountDownLatch count = new CountDownLatch(1000);


    public static void main(String[] args) {
        for (int j = 0; j <1000 ; j++) {
            new DecThread().start();
        }
        try {
            count.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(i);
    }

    private static class DecThread extends Thread{

        @Override
        public void run() {
            num();
            count.countDown();
        }
    }

    private synchronized static void num(){
        for (int j = 0; j < 100; j++) {
            i++;
        }
    }
}
