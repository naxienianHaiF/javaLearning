package com.wjh.thread.aqs;

/**
 * Created by WJH on 2018年04月05日 13:34
 */
public class MyAQSDemo {

    private MyAQS aqs = new MyAQS();
    private int value ;

    private int getNext(){
        aqs.lock();
        try {
            Thread.sleep(100);
            return value++;
        } catch (InterruptedException e) {
            throw new RuntimeException();
        }finally {
            aqs.unlock();
        }
    }
    public static void main(String[] args) {

        MyAQSDemo demo = new MyAQSDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " "+ demo.getNext());
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName() + " "+ demo.getNext());
                }
            }
        }).start();
    }
}
