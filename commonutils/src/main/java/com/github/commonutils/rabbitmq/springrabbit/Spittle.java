package com.github.commonutils.rabbitmq.springrabbit;

import java.util.Date;

/**
 * TODO
 *
 * @author wuyun
 * @date 2019/1/2 21:07
 */
public class Spittle {

    private Long id;
//    private Spitter spitter;
    private String message;
    private Date postedTime;

    public Spittle(Long id, String message, Date postedTime) {
        this.id = id;
        this.message = message;
        this.postedTime = postedTime;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getPostedTime() {
        return postedTime;
    }

    public void setPostedTime(Date postedTime) {
        this.postedTime = postedTime;
    }
}
