package com.wjh.annotation;

/**
 * Created by WJH on 2017年05月21日 20:37
 */
@Description(desc = "I am class annotation",author = "WJH",age = 25)
public class ExampleOne {
    @Description(desc = "I am method annotation", author = "WJH",age = 25)
    public void say(){
        System.out.println("自定义注解学习");
    }
}
