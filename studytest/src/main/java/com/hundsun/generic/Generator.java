package com.hundsun.generic;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/9/14 13:52
 */
public interface Generator<T> {

    void next();

    T preious();
}
