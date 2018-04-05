package com.wjh.thread.waitnotify;

/**
 * Created by WJH on 2018年04月05日 11:33
 */
public class WaitDemo {

    public static void main(String[] args) {

        MyService service = new MyService();
        A a = new A(service);
        B b = new B(service);
        C c = new C(service);

        new Thread(a).start();
        new Thread(b).start();
        new Thread(c).start();

    }
}

class A implements Runnable{
    private MyService service;
    public A(MyService service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.a();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class B implements Runnable{
    private MyService service;
    public B(MyService service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.b();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class C implements Runnable{
    private MyService service;
    public C(MyService service){
        this.service = service;
    }

    @Override
    public void run() {
        while (true){
            service.c();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}