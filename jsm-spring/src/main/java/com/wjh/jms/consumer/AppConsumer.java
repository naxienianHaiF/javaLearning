package com.wjh.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WJH on 2017年12月17日 21:15
 */
public class AppConsumer {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
    }
}
