package com.hundsun.inner;

import java.util.Comparator;
import java.util.TreeSet;

/**
 * @Description: 匿名内部类
 * @date 2018/9/18 18:53
 */
public class InnerTest {

    public static void main(String[] args) {

        TreeSet<Data> treeSet = new TreeSet<Data>(new Comparator<Data>() {
            @Override
            public int compare(Data o1, Data o2) {
                return o1.age > o2.age ? -1 : o1.age < o2.age ? 1 : 0;
            }
        });
        treeSet.add(new Data(1));
        treeSet.add(new Data(-1));
        treeSet.add(new Data(0));
        System.out.println(treeSet.toString());

    }
}

class Data {
    int age;

    public Data(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Data{" +
                "age=" + age +
                '}';
    }
}


