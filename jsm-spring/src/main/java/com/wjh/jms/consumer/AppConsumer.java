package com.wjh.jms.consumer;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author JHW
 * @date 2017年12月17日 21:15
 * 需要启动 E:\software\activemq\apache-activemq-5.15.2\bin路径下的ActiveMQ
 * 队列模式（本代码是队列模式）
 * <p>&nbsp;&nbsp; 队列模式的消费者平分所有的消息，主题模式是每个消费者获得所有的消息</p>
 */
public class AppConsumer {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("consumer.xml");
    }
}
