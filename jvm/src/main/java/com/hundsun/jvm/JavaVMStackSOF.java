package com.hundsun.jvm;

/**
 * TODO
 *
 * -Xss128k
 *
 * @author wuyun
 * @date 2019/8/24 11:33
 */
public class JavaVMStackSOF {

    private int stacklength = 1;

    public void stackLeak(){
        stacklength++;
        stackLeak();
    }

    public static void main(String[] args) {
        JavaVMStackSOF oom = new JavaVMStackSOF();
        try{
            oom.stackLeak();
        }catch (Throwable e){
            System.out.println("stack length:" + oom.stacklength);
            throw e;
        }
    }
}
