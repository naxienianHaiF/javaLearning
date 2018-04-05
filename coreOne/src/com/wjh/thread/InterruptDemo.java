package com.wjh.thread;

/**
 * Created by WJH on 2018年03月31日 22:35
 */
public class InterruptDemo {

    public static void main(String[] args) throws InterruptedException {
        Runnable runnable = new Worker();
        Thread thread = new Thread(runnable);

        thread.start();

        Thread.sleep(500);
        thread.interrupt();


    }

    public static class Worker implements Runnable{

        @Override
        public void run() {
            System.out.println("测试interrupt方法");
            try {
                Thread.sleep(200);
                System.out.println("当前现成的中断标志位"+Thread.currentThread().getName()+
                        " "+Thread.interrupted() +" "+Thread.currentThread().isInterrupted());
            }catch (Exception e){

            }
        }
    }
}
