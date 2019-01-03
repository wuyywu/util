package com.github.designpattern.observer;

/**
 * 具体主题或通知者
 *
 * @author wuyun
 * @date 2019/1/1 16:56
 */
public class ConcreteSubject extends Subject {

    private String subjectState;

    public String getSubjectState() {
        return subjectState;
    }

    public void setSubjectState(String subjectState) {
        this.subjectState = subjectState;
    }
}
