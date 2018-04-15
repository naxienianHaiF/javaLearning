package com.wjh.clutter;

/**
 * Created by WJH on 2018年04月03日 21:17
 * final修饰的变量如果赋值了null，则也不能再修改其值
 */
public class FinalTest {

    public static void main(String[] args) {
        final String string ;
        string = "hello" ;
        System.out.println(string);
    }
}
