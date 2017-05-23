package com.wjh.annotation;

import java.lang.annotation.*;

/**
 * Created by WJH on 2017年05月21日 20:34
 * 自定义注解实例
 * ElementType.TYPE是指作用域为  类，接口
 */
@Target({ElementType.METHOD,ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface Description {
    String desc();

    String author();

    int age()default 18;
}
