package com.wjh.thread.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author JHW
 * @date created at 2018/04/14
 */
public class CachedDemo {

    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();

        int num = 10;
        for (int i=0;i<num;i++){
            final int index = i;
            try {
                Thread.sleep(1000*i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(index);
                }
            });
        }

        service.shutdown();
    }
}
