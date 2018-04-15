package com.wjh.thread.threadpool;

import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author JHW
 * @date created at 2018/04/14
 */
public class ScheduledDemo {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(5);
        System.out.println(new Date());

//        service.schedule(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(new Date());
//                System.out.println("delay...");
//            }
//        },3, TimeUnit.SECONDS);

        System.out.println(new Date());
//        service.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println(new Date());
//                System.out.println("定期执行...");
//            }
//        },1,3,TimeUnit.SECONDS);

        service.scheduleWithFixedDelay(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" "+new Date()+" with fixed...");
            }
        },1,3, TimeUnit.SECONDS);

//        service.shutdown();
    }
}
