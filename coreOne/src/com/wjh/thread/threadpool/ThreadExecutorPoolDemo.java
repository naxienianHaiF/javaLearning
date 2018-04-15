package com.wjh.thread.threadpool;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author JHW
 * @date created at 2018/04/14
 *
 * corePoolSize：线程池中所保存的核心线程数，包括空闲线程。
 * maximumPoolSize：池中允许的最大线程数。
 * keepAliveTime：线程池中的空闲线程所能持续的最长时间。
 * unit：持续时间的单位。
 * workQueue：任务执行前保存任务的队列，仅保存由 execute 方法提交的 Runnable 任务。
 */
public class ThreadExecutorPoolDemo {
    public static void main(String[] args) {

        BlockingQueue<Runnable> queue = new ArrayBlockingQueue<Runnable>(20);
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,60, TimeUnit.SECONDS,queue);

        Runnable t1 = new MyRunnable();
        Runnable t2 = new MyRunnable();
        Runnable t3 = new MyRunnable();
        Runnable t4 = new MyRunnable();
        Runnable t5 = new MyRunnable();
        Runnable t6 = new MyRunnable();

        executor.execute(t1);
        executor.execute(t2);
        executor.execute(t3);
        executor.execute(t4);
        executor.execute(t5);
        executor.execute(t6);

        if (executor.getActiveCount() ==3){
            System.out.println(queue.isEmpty());
            executor.shutdown();
        }
    }
}

class MyRunnable implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+" ....");
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}