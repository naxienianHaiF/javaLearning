package com.wjh.thread.rwlock;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Created by WJH on 2018年04月05日 13:47
 * 读写锁
 * 读锁是共享锁
 * 写锁是排它锁
 */
public class RWLockDemo {

    private Map<String, Object> map = new HashMap<>();
    private ReadWriteLock rwl = new ReentrantReadWriteLock();
    private Lock w = rwl.writeLock();
    private Lock r = rwl.readLock();

    private Object get(String string){
        r.lock();
        System.out.println(Thread.currentThread().getName()+ " 读操作开始执行。。。"+ new Date(System.currentTimeMillis()));
        try {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            return map.get(string);
        }finally {
            r.unlock();
            System.out.println(Thread.currentThread().getName()+" 读操作结束执行。。。" + new Date(System.currentTimeMillis()));
        }
    }

    private void put(String string, Object object){
        w.lock();
        System.out.println(Thread.currentThread().getName()+" 写操作开始执行。。。" + new Date(System.currentTimeMillis()));
        try {
            map.put(string,object);
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }finally {
            w.unlock();
            System.out.println(Thread.currentThread().getName()+" 写操作结束执行。。。" + new Date(System.currentTimeMillis()));
        }
    }

    public static void main(String[] args) {
//        testRead();
        testWrite();
    }

    private static void testWrite(){
        RWLockDemo demo = new RWLockDemo();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("1","1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.put("2","2");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(demo.get("1"));
            }
        }).start();
    }

    private static void testRead(){
        RWLockDemo demo = new RWLockDemo();
        demo.map.put("1","1");
        demo.map.put("2","2");

        new Thread(new Runnable() {
            @Override
            public void run() {
                demo.get("1");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(demo.get("1"));
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(demo.get("1"));
            }
        }).start();
    }
}
