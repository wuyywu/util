package com.hundsun.study;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/7/1 17:43
 */
class Game {
    Game(int i){
        System.out.println(i);
    }
}

public class Chess extends Game{
    public Chess(){
        super(3);
    }
}