package com.wjh.thread.utildemo;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * Created by WJH on 2018年04月08日 11:10
 */
public class CyclicBarrierDemo {

    public void meeting(CyclicBarrier barrier){
        try {
            Thread.sleep(new Random().nextInt(4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName()+ "" +
                " 到达会议室，等待。。。");

        try {
            barrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "" +
                "会议已经开始了。。。");
    }

    public static void main(String[] args) {

        CyclicBarrierDemo demo = new CyclicBarrierDemo();
        CyclicBarrier barrier = new CyclicBarrier(10, new Runnable() {
            @Override
            public void run() {
                System.out.println("我们开始开会。。。");
            }
        });

        for (int i=0; i<10; i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    demo.meeting(barrier);
                }
            }).start();
        }
    }
}
