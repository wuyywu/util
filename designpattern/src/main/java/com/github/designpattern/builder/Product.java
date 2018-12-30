package com.github.designpattern.builder;

import java.util.ArrayList;
import java.util.List;

/**
 * 产品类，由多个部件组成
 *
 * @author wuyun
 * @date 2018/12/30 20:36
 */
public class Product {

    List<String> parts = new ArrayList<String>();

    /**
     * 添加产品部件
     * @param part
     * @return
     */
    public void add(String part){
        parts.add(part);
    }

    /**
     * 列举所有产品部件
     * @return
     */
    public void show(){
        System.out.println("---产品 创建---");
        for(String part : parts){
            System.out.println(part);
        }
    }

}
