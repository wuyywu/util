package com.github.designpattern.prototype;

import java.io.*;

/**
 * 简历类
 *
 * @author wuyun
 * @date 2018/12/29 17:00
 */
public class Resume implements Cloneable, Serializable {

    private static final long serialVersionUID = 5808802064035399840L;

    private String name;
    private String gender;
    private int age;

    /**
     * 引用"工作经历"对象，为演示深度拷贝和浅度拷贝而用
     */
    private WorkExperience workExperience;

    public Resume() {
        // 在“简历”类实例化时，同时实例化“工作经历”类
        workExperience = new WorkExperience();
    }

    public void display(){
        System.out.println(this.getName() + "" + this.getGender() + ""
                + this.getAge() + "\n工作经历："
                + this.getWorkExperience().getWorkDate() + ""
                + this.getWorkExperience().getWorkCompany());
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Object deepClone() throws IOException, ClassNotFoundException {
        //将对象写入流内
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(this);

        //从流内读出对象
        ObjectInputStream ois = new ObjectInputStream(new ByteArrayInputStream(bos.toByteArray()));
        return ois.readObject();
    }

    public String getName() {
        return name;
    }

    public Resume setName(String name) {
        this.name = name;
        return this;
    }

    public String getGender() {
        return gender;
    }

    public Resume setGender(String gender) {
        this.gender = gender;
        return this;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public WorkExperience getWorkExperience() {
        return workExperience;
    }

    public void setWorkExperience(String workDate, String workCompany) {
        workExperience.setWorkDate(workDate);
        workExperience.setWorkCompany(workCompany);
    }
}
