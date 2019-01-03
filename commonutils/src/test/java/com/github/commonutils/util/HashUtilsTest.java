package com.github.commonutils.util;

import org.junit.Test;

public class HashUtilsTest {

    @Test
    public void hash() {
        String key = "1-0-张三-433300619120218489X";
        System.out.println(HashUtils.hash(key));

        System.out.println(HashUtils.hash(key) % 1000);
        System.out.println(HashUtils.hash(key) % 100);
        System.out.println(HashUtils.hash(key) % 4);
    }
}