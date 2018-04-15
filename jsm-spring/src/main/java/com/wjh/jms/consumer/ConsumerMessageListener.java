package com.wjh.jms.consumer;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 * Created by WJH on 2017年12月17日 21:06
 */
public class ConsumerMessageListener implements MessageListener {

    public void onMessage(Message message) {
        TextMessage textMessage=(TextMessage) message;
        try {
            System.out.println("接受消息："+textMessage.getText());
        } catch (JMSException e) {
            e.printStackTrace();
        }
    }
}
