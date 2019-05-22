package com.github.designpattern.adapter.demo2;

/**
 * 翻译者
 *
 * @author wuyun
 * @date 2019/5/21 14:58
 */
public class Translator extends Player {

    /**
     * 翻译者和外籍中锋有关联
     */
    private ForeignCenter wjzf = new ForeignCenter();

    public Translator(String name) {
        super(name);
        wjzf.setName(name);
    }

    @Override
    public void attack() {
        wjzf.jinGong();
    }

    @Override
    public void defense() {
        wjzf.fangShou();
    }
}
