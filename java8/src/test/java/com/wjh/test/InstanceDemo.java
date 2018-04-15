package com.wjh.test;

/**
 * Created by WJH on 2017年08月17日 22:35
 */
public class InstanceDemo {
    public static void main(String[] args) {
        System.out.println("wjh" instanceof String);
        System.out.println(new Object() instanceof String);
        System.out.println("wjh" instanceof Object);
    }
}
