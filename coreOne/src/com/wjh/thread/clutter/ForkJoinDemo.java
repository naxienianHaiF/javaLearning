package com.wjh.thread.clutter;

import java.util.concurrent.*;

/**
 * @author JHW
 * @date created at 2018/04/15
 */
public class ForkJoinDemo extends RecursiveTask<Integer>{

    private int begin;
    private int end;

    public ForkJoinDemo(int begin, int end) {
        this.begin = begin;
        this.end = end;
    }

    @Override
    protected Integer compute() {
        int sum = 0;
        if (end - begin <= 2){
            for (int i=begin;i<=end;i++){
                sum+=i;
            }
        }else {

            ForkJoinDemo demo1 = new ForkJoinDemo(begin,(begin+end)/2);
            ForkJoinDemo demo2 = new ForkJoinDemo((begin+end)/2+1,end);

            demo1.fork();
            demo2.fork();

            Integer d1 = demo1.join();
            Integer d2 = demo2.join();
            sum = d1+d2;
        }
        return sum;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {

        Thread.sleep(1000);

        ForkJoinPool pool = new ForkJoinPool(3);
        Future<Integer> future = pool.submit(new ForkJoinDemo(1,10000));
        System.out.println(future.get());
    }
}
