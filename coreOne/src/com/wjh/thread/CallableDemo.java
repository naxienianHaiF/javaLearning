package com.wjh.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Created by WJH on 2018年03月31日 13:17
 */
public class CallableDemo implements Callable<Integer> {

    public static void main(String[] args) {
        CallableDemo demo = new CallableDemo();
        FutureTask<Integer> task = new FutureTask<Integer>(demo);

        Thread thread = new Thread(task);

        System.out.println(" 我先做点其他的事情。。。");

        thread.start();

        try {
            Integer result = task.get();
            System.out.println(result);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Integer call() throws Exception {
        System.out.println("正在测试。。。");
        Thread.sleep(1000);
        System.out.println("测试完成 ...");
        return 1;
    }
}
