package com.wjh.thread.threadpool;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author JHW
 * @date created at 2018/04/15
 */
public class PoolDemo {

    public static void main(String[] args) {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<>(10);

        ThreadPoolExecutor threadPool = new ThreadPoolExecutor(3,5,10, TimeUnit.MINUTES,queue,new ThreadPoolExecutor.DiscardOldestPolicy());

        AtomicInteger atomic = new AtomicInteger(1);
        for (int i=0;i<20;i++){
            threadPool.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                    atomic.getAndIncrement();
                }
            });
        }

        threadPool.shutdown();
//        while (Thread.activeCount() >1){
//            System.out.println(Thread.activeCount());
//        }
        System.out.println(atomic.get());
    }
}
