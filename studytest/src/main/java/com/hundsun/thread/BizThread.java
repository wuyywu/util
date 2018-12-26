package com.hundsun.thread;

import java.text.SimpleDateFormat;
import java.util.Date;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @Description:
 * @Author wuyun
 * @date 2018/8/21 16:44
 */
public class BizThread implements Runnable {
    private Logger logger = LoggerFactory.getLogger(BizThread.class);
    private String name;

    public BizThread(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getId());
        logger.info(String.valueOf(Thread.currentThread().getId()));

        SimpleDateFormat dateFormat = new SimpleDateFormat("YYYYMMdd HHmmss");
        try {
            String text = name + "北京时间" + dateFormat.format(new Date());
            System.out.println(Thread.currentThread().getId() + text);
            logger.info(Thread.currentThread().getId() + text);


        } catch (Exception e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }

    }

}
