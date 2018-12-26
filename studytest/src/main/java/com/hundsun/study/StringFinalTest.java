package com.hundsun.study;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/5/10 16:54
 */
public class StringFinalTest {


        public static void main(String[] args) {

        StringFinalTest test = new StringFinalTest();
        test.testInt();
        test.testString();

        Man man = new Man(17, "Jack");
        test.testObject(man);

        System.out.println(man.toString());
    }

public void testInt(){
int e, f, g;
            e = 2;
            f = e;
            g = f;
            int i1 = processA(e);
            System.out.println(i1);
            System.out.println(e);

            int i2 = processB(f);
            System.out.println(i2);
            System.out.println(f);

            int i3 = processC(g);
            System.out.println(i3);
            System.out.println(g);
}



public void testString(){
    String a, b, c;
    a = "test";
    b = a;
    c = b;
    String processA = processA(a);

    System.out.println(processA);
    System.out.println(a);
    String processB = processB(b);
    System.out.println(processB);
    System.out.println(b);

    String processC = processC(c);
    System.out.println(processC);
    System.out.println(c);

}
    static int processA(int i){
        i = i + 3;
        return i;
    }

    static int processB(int i){
        i =  i + 4;
        return i;
    }

    static int processC(int i){
        i = i + 5;
        return i;
    }

    static String processA(String str){
        str = str + "A";
        str.concat("A");
        return str;
    }

    static String processB(String str){
//            str = str + "B";
        str.concat("B");
        return str;
    }

    static String processC(String str){
//            str = str + "C";
        str.concat("C");
        return str;
    }

    public void testObject(Man man){
        man.setAge(27);
        man.setName("Lucy");
    }


}

class Man{
    private int age;
    private String name;

    public Man(int age, String name){
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

