package com.github.designpattern.builder;

/**
 * 具体的建造者A
 *
 * @author wuyun
 * @date 2018/12/30 20:43
 */
public class ConcreteBuilder1 extends Builder {

    private Product product = new Product();
    @Override
    public void buildPartA() {
        product.add("部件A");
    }

    @Override
    public void buildPartB() {
        product.add("部件B");
    }

    @Override
    public Product getBuildResult() {
        return product;
    }
}
