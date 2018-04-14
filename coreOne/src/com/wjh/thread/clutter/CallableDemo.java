package com.wjh.thread.clutter;

import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Created by WJH on 2018年04月12日 21:44
 * @author JHW
 * @date
 */
public class CallableDemo {

    public static void main(String[] args) {

        Callable<Integer> callable = new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                return new Random().nextInt(100);
            }
        };

        FutureTask<Integer> task = new FutureTask<Integer>(callable);
        new Thread(task).start();

        try {
            Thread.sleep(1000);
            System.out.println(task.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
