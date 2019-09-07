package com.hundsun.jvm;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/8/24 15:03
 */
public class ReferenceCountingGC {

    private Object instance = null;
    private static final int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void testGC() {
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();

        objA.instance = objB;
        objB.instance = objA;

        objA = null;
        objB = null;

        System.gc();
    }
}
