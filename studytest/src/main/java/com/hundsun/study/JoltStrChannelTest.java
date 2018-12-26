//package com.hundsun.study;
//
//import bea.jolt.JoltRemoteService;
//import bea.jolt.JoltSession;
//import bea.jolt.JoltSessionAttributes;
//
///**
// * Created by gyb on 2017/5/10.
// */
//public class JoltStrChannelTest {
//
//    public static void main(String[] args) {
//        JoltSessionAttributes attrs = new JoltSessionAttributes();
//        attrs.setString(attrs.APPADDRESS, "//127.0.0.1:10005");
//        attrs.setInt(attrs.IDLETIMEOUT, 300);
//        JoltSession joltSession = new JoltSession(attrs, null, null, null, null);
//        JoltRemoteService remoteService = new JoltRemoteService("HS_TRANSACTION", joltSession);
//        remoteService.setString("STRING", "//ȡһ�α��ķ�����");
//        remoteService.call(null);
//        String result = remoteService.getStringDef("STRING", null);
//        System.out.println(result);
//    }
//}
