package com.wjh.thread.clutter;

/**
 * @author JHW
 * @date created at 2018/04/14
 */
public class ThreadLocalDemoTwo {

    private ThreadLocal<Integer> local = new ThreadLocal<Integer>(){
        @Override
        protected Integer initialValue() {
            return new Integer(0);
        }
    };

    private int getNext(){
        Integer value = local.get();
        value++;
        local.set(value);
        return value;
    }

    public static void main(String[] args) {
        ThreadLocalDemoTwo two = new ThreadLocalDemoTwo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+"" +
                            " "+two.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    System.out.println(Thread.currentThread().getName()+"" +
                            " "+two.getNext());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
}
