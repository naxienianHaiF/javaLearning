package com.wjh.thread;

/**
 * Created by WJH on 2018年03月25日 10:56
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        final Object a = new Object();
        final Object b = new Object();

        new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (a){
                        System.out.println("T1 got the lock of a");
                        Thread.sleep(1000);
                        System.out.println("T1 is trying to get the lock of b ");
                        synchronized (b){
                            System.out.println("the a after lock is b ...");
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();

        new Thread(){
            @Override
            public void run() {
                try {
                    synchronized (b){
                        System.out.println("T2 got the lock of b");
                        Thread.sleep(1000);
                        System.out.println("T2 is trying to get the lock of a ");
                        synchronized (a){
                            System.out.println("the b after lock is a ...");
                        }
                    }
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
