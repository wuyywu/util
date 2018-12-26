package com.hundsun.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description: 泛型类
 * @Author wuyun
 * @date 2018/9/14 13:38
 */
public class Generic<T> {

    private T context;

    public Generic(T context) {
        this.context = context;
    }

    public T getContext() {
        return context;
    }

    public void showKeyValue(Generic<?> obj){

        System.out.println("泛型测试 key value is " + obj.getContext());
    }

    public void test(String[] args) {
        Generic<Integer> gInteger = new Generic<Integer>(123);
        Generic<Number> gNumber = new Generic<Number>(456);

        this.showKeyValue(gInteger);
        this.showKeyValue(gNumber);

    }


    public static  void main(String[] args) {

//        List<String>[] lsa = new List[10]; // Not really allowed.
//        Object o = lsa;
//        Object[] oa = (Object[]) o;
//        List<Integer> li = new ArrayList<Integer>();
//        li.add(new Integer(3));
//        oa[1] = li; // Unsound, but passes run time store check
//        String s = lsa[1].get(0); // Run-time error: ClassCastException.


        List<?>[] lsa = new List<?>[10]; // OK, array of unbounded wildcard type.
        Object o = lsa;
        Object[] oa = (Object[]) o;
        List<Integer> li = new ArrayList<Integer>();
        li.add(new Integer(3));
        oa[1] = li; // Correct.
        Integer i = (Integer) lsa[1].get(0); // OK

    }
}
