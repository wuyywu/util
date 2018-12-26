package com.hundsun.applet;

import javax.swing.*;

/**
 * @Description:
 * @Author wuyun
 * @date 2018/9/8 17:55
 */
public class NotHelloWorldApplet extends JApplet {

    @Override
    public void init()
    {
        JLabel label = new JLabel("Not a Hello, World applet", SwingConstants.CENTER);
        add(label);
    }

}
