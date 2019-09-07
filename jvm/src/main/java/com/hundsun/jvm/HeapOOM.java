package com.hundsun.jvm;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/8/24 11:23
 */
public class HeapOOM {

    static class OOMObject{
    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }

    }
}
