package com.wjh.thread.waitnotify;

/**
 * Created by WJH on 2018年04月05日 10:32
 * 顺序打印abc
 * {@link MyCondition} 参考使用Condition实现方式
 */
public class MyService {

    private int signal;

    public synchronized void a(){
        while (signal != 0){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("a");
        signal++;
        notifyAll();
    }

    public synchronized void b(){
        while (signal != 1){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("b");
        signal++;
        notifyAll();
    }

    public synchronized void c(){
        while (signal != 2){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("c");
        signal = 0;
        notifyAll();
    }
}
