package com.wjh.test;

/**
 * Created by WJH on 2017年03月29日 20:27
 */
public class TestDemo {
    public static void main(String[] args) {
        Demo demo=new DemoImpl();
        System.out.println(demo.x);
        demo.say();
    }
}
