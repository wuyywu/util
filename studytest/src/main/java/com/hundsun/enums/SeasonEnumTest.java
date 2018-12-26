package com.hundsun.enums;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/9/9 16:11
 */
public class SeasonEnumTest {

    public static void main(String[] args) {
//        String[] a = SeasonEnum.AUTUMN.name();
        String b = SeasonEnum.AUTUMN.toString();
        String c = SeasonEnum.AUTUMN.name();
        Integer d = SeasonEnum.AUTUMN.ordinal();

        SeasonEnum[] ena = SeasonEnum.values();


        SeasonEnum seasonEnum = SeasonEnum.valueOf("AUTUMN");
        System.err.println(seasonEnum.equals(SeasonEnum.AUTUMN));

        System.err.println(seasonEnum);


    }

    public void judge(SeasonEnum s)
    {
        switch(s)
        {
            case SPRING:
                System.out.println("春天适合踏青。");
                break;
            case SUMMER:
                System.out.println("夏天要去游泳啦。");
                break;
            case AUTUMN:
                System.out.println("秋天一定要去旅游哦。");
                break;
            case WINNER:
                System.out.println("冬天要是下雪就好啦。");
                break;
        }
    }
}
