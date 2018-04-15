package com.wjh.jms.producer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by WJH on 2017年12月17日 15:36
 */
public class AppProducer {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("producer.xml");
        ProducerService service=context.getBean(ProducerServiceImpl.class);
        if (service!=null){
            System.out.println(1111);
        }
        for (int i=0;i<100;i++){
            service.sendMessage("Hello ActimeMQ! "+ i);
        }
    }
}
