package com.hundsun.inttest;

import java.io.Serializable;

/**
 * TODO
 *
 * @author wuyun
 * @date 2018/12/17 15:27
 */
public class User implements Serializable {

    private static final long serialVersionUID = -9212230867482111173L;

    private int id;

    private String name;

    private Integer age;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
