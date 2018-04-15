package com.wjh.thread.threadpool;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JHW
 * @date created at 2018/04/14
 */
public class FixedDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newFixedThreadPool(3);

        for (int i=0;i<6;i++){
            final int index = i;
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index+" "+new Date());
                }
            });

            System.out.println(Thread.currentThread().isAlive());
        }

        service.shutdown();
    }
}
