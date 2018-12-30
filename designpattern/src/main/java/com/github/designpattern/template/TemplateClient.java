package com.github.designpattern.template;

/**
 * 模板方法客户端
 *
 * @author wuyun
 * @date 2018/12/29 17:55
 */
public class TemplateClient {

    public static void main(String[] args) {
        AbstractTemplate abstractTemplate;

        abstractTemplate = new ConcreteClassA();
        abstractTemplate.templateMethod();

        abstractTemplate = new ConcreteClassB();
        abstractTemplate.templateMethod();

    }
}
