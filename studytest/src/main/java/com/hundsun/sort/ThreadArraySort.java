package com.hundsun.sort;

import java.util.Stack;

/**
 * 多线程排序算法
 *
 * @author wuyun
 * @date 2018/11/7 12:23
 */
public class ThreadArraySort implements Runnable{

    private String num;
    private static Stack stack = new Stack();

    public ThreadArraySort(int num) {
        this.num = num + "";
    }

    public static void main(String[] args) {
        //把这个数组升序输出
        int[] nums = {11, 3, 998, 5455, 1, 152, 990};
        for (int i = 0; i < nums.length; i++) {
            new Thread(new ThreadArraySort(nums[i])).start();
        }

        if (stack.capacity() == nums.length){
            for (int i = 0; i < nums.length; i++) {
                System.out.println(stack.peek());
            }
        }
    }

    @Override
    public void run() {
        try {
            Thread.sleep(Integer.parseInt(num));
//            System.out.println(num);
            stack.push(num);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
