package com.hundsun.generic;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/9/16 13:47
 */
public class PairTest1 {

    public static void main(String[] args) {
        String[] words = {"Mary", "had", "a", "little", "lamb"};
        Pair<String> mm = ArrayAlg.minmax(words);

        System.out.println("min = " + mm.getFirst());
        System.out.println("max = " + mm.getSecond());
    }
}
class ArrayAlg{
    public static <T extends Comparable> Pair<T> minmax(T[] a){
        if (a == null || a.length ==0){
            return null;
        }

        T min = a[0];
        T max = a[0];

        for (int i = 1; i < a.length; i++) {
            if (min.compareTo(a[i]) > 0){
                min = a[i];
            }

            if (max.compareTo(a[i]) < 0){
                max = a[i];
            }
        }
        return new Pair<T>(min,max);
    }

}


