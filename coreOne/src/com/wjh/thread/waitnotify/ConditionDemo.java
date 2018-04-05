package com.wjh.thread.waitnotify;

/**
 * Created by WJH on 2018年04月05日 15:45
 */
public class ConditionDemo {

    public static void main(String[] args) {

        MyCondition condition = new MyCondition();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    condition.a();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    condition.b();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    condition.c();
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
