package com.github.commonutils.createobject;

import java.io.*;
import java.lang.reflect.Constructor;

/**
 * 创建对象的5种方式
 *
 * @author wuyun
 * @date 2018/12/18 9:51
 */
public class ObjectCreation {

    public static void main(String[] args) throws Exception {
        ObjectCreation objectCreation = new ObjectCreation();
        objectCreation.test();
    }

    public void test() throws Exception {
        //用new关键字
        Employee employee1 = new Employee();
        employee1.setName("wuyun1");

        System.out.println(employee1 + ", hashcode :" + employee1.hashCode());

        //By using Class class's mewInstsance() method
        Employee employee2 = (Employee) Class.forName("com.github.commonutils.createobject.Employee").newInstance();
        employee2.setName("wuyun2");
        System.out.println(employee2 + ", hashcode : " + employee2.hashCode());

        //Or we can simply do this
        Employee employee3 = Employee.class.newInstance();
        employee3.setName("wuyun3");
        System.out.println(employee3 + ", hashcode : " + employee3.hashCode());


        // By using Constructor class's newInstance() method

        Constructor<Employee> constructor = Employee.class.getConstructor();
        Employee employee4 = constructor.newInstance();
        employee4.setName("wuyun4");
        System.out.println(employee4 + ", hashcode : " + employee4.hashCode());


        Employee employee5 = (Employee) employee1.clone();
        employee5.setName("wuyun5");
        System.out.println(employee5 + ", hashcode : " + employee5.hashCode());

        // By using Deserialization

        // Serialization
        ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("data.obj"));
        out.writeObject(employee5);
        out.close();


        //Deserialization

        ObjectInputStream in = new ObjectInputStream(new FileInputStream("data.obj"));
        Employee employee6 = (Employee) in.readObject();
        in.close();
        employee6.setName("wuyun6");
        System.out.println(employee6 + ", hashcode : " + employee6.hashCode());


     }

}
