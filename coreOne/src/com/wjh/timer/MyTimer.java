package com.wjh.timer;

import java.util.Timer;

/**
 * Created by WJH on 2017年05月23日 16:35
 */
public class MyTimer {

    public static void main(String[] args) {
        Timer timer=new Timer();
        MyTimerTask myTimerTask=new MyTimerTask("WJH");
        timer.schedule(myTimerTask,2000L,1000L);
    }

}
