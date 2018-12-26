package com.hundsun.study;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/5/17 17:18
 */
public class ExceptionTest {

    public static void main(String[] args){

        ExceptionTest exceptionTest = new ExceptionTest();
        try{
            exceptionTest.excepiton();
            System.out.println("没有catch到了");

        } catch (Exception e){
            System.out.println("catch到了");
        }

    }


    public void excepiton(){
        throw new FspBusinessException("9999", "测试一下");

    }

}
