package com.wjh.jms.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;

import javax.annotation.Resource;
import javax.jms.*;

/**
 * Created by WJH on 2017年12月17日 15:17
 */
public class ProducerServiceImpl implements ProducerService {

    @Autowired
    JmsTemplate jmsTemplate;
    @Resource (name = "queueDestination")
    Destination destination;

    public void sendMessage(final String str) {
        jmsTemplate.send(destination, new MessageCreator() {
            //创建一个消息
            public Message createMessage(Session session) throws JMSException {
                TextMessage textMessage=session.createTextMessage(str);
                System.out.println("消息的内容是："+textMessage.getText());
                return textMessage;
            }
        });
        System.out.println("发送的消息："+ str);
    }
}
