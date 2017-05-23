package com.wjh.timer;

import java.util.TimerTask;

/**
 * Created by WJH on 2017年05月23日 16:33
 */
public class MyTimerTask extends TimerTask{
    private String name;
    public MyTimerTask(String name){
        this.name=name;
    }

    @Override
    public void run() {
        System.out.println(name);
    }
}
