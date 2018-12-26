package com.hundsun.study;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/5/31 15:53
 */
public class listTest {

    public static void  main(String[] args){
        Student student3 = new Student("2", "lucy");
        Student student1 = new Student("0", "wuyun");
        Student student4 = new Student("11", "lily");
        Student student2 = new Student("1", "jack");
        Student student5 = new Student("21", "ma");

        List<Student> list = new ArrayList<Student>();
        list.add(student3);
        list.add(student1);
        list.add(student4);
        list.add(student2);
        list.add(student5);

        Collections.sort(list, new Comparator<Student>() {
            public int compare(Student o1, Student o2) {
                return Integer.parseInt(o1.getAge()) - Integer.parseInt(o2.getAge());
            }
        });
        System.out.println(list);
    }

}

class Student{
    private String age;
    private String name;

    public Student(String age, String name){
        this.age = age;
        this.name = name;
    }


    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
