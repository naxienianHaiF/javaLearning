package com.wjh.clutter;

/**
 * Created by WJH on 2018年03月24日 19:17
 */
class A{
    A(){
        i = (j++ != 0) ? ++j : --j;
    }
    public int i;
    public static int j;
}

public class Ceshi {
    public static void main(String[] args) {
//        A a1 = new A();
//        System.out.println(a1.i);
//        System.out.println(a2.i);

        int k=0;
        System.out.println((k++ != 0));
    }
    static A a2 = new A();
}
