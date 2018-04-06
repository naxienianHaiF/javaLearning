package com.wjh.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by WJH on 2018年04月01日 16:00
 */
public class ExecutorServiceDemo {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i=0;i <10; i++){
            service.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName());
                }
            });
        }
    }
}
