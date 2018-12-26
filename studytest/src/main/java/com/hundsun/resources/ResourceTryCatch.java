package com.hundsun.resources;

import java.io.*;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/10/7 16:18
 */
public class ResourceTryCatch {

    public static void main(String[] args) throws Exception {
        Student s = new Student("DEMO");
        Student s2 = null;
        ObjectOutputStream oos = null;
        ObjectInputStream ois = null;
        try {
            //创建对象输出流
            oos = new ObjectOutputStream(new FileOutputStream("b.bin"));
            //创建对象输入流
            ois = new ObjectInputStream(new FileInputStream("b.bin"));
            //序列化java对象
            oos.writeObject(s);
            oos.flush();
            //反序列化java对象
            s2 = (Student) ois.readObject();
        } finally { //使用finally块回收资源
            if (oos != null) {
                try {
                    oos.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
            if (ois != null) {
                try {
                    ois.close();
                } catch (Exception ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static void main2(String[] args) throws Exception {
        Student s = new Student("WJY");
        Student s2 = null;
        try (//创建对象输出流
             ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("b.bin"));
             //创建对象输入流
             ObjectInputStream ois = new ObjectInputStream(new FileInputStream("b.bin"));
        )
        {
            //序列化java对象
            oos.writeObject(s);
            oos.flush();
            //反序列化java对象
            s2 = (Student) ois.readObject();
        }
    }
}

class Student implements Serializable {
    private String name;

    public Student(String name) {
        this.name = name;
    }
}
