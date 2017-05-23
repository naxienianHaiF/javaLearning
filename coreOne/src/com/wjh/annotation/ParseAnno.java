package com.wjh.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

/**
 * Created by WJH on 2017年05月22日 14:54
 * 解析自定义注解
 */
public class ParseAnno {

    public static void main(String[] args) {
        try {
            //1.使用类加载器加载类
            Class c=Class.forName("com.wjh.annotation.ExampleOne");
            //2.找到类上面的注解
            boolean isExist=c.isAnnotationPresent(Description.class);
            if (isExist){
                //3.拿到注解实例
                Description description= (Description) c.getAnnotation(Description.class);
                System.out.println(description.desc());
           }
            //4.找到方法上的注解
            Method[] methods=c.getMethods();
            for(Method m:methods){
                boolean isMethod=m.isAnnotationPresent(Description.class);
                if (isMethod){
                    Description d=(Description)m.getAnnotation(Description.class);
                    System.out.println(d.desc());
                }
            }
            //两外一种解析方法
            System.out.println("方法二。。。");
            for(Method m:methods){
                Annotation[] annotations=m.getAnnotations();
                for (Annotation a:annotations){
                    if (a instanceof Description){
                        Description description=(Description)a;
                        System.out.println(description.desc());
                    }
                }
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
