package com.hundsun.study;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/4/15 15:42
 */
public class A {
    private String text;

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("[").append("text="+text).append("]");
        //Bird bird = new Bird();
        return sb.toString();
    }

/*    public String test(int i){
        return "abc";
    }

    private String test(int i){
        return "";
    }*/

}
