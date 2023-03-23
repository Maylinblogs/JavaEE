package com.example.pruduser.config;

import javax.annotation.Resource;
import javax.enterprise.context.ApplicationScoped;
import javax.jms.*;
import java.util.ArrayList;


@ApplicationScoped
public class JMSResource {
    @Resource(name = "ConnectionFactory")
    private ConnectionFactory connectionFactory;
    @Resource(name = "java:/jms/topic/auction")
    private Topic myTopic;

    public void sendMessage(ArrayList<Integer> list) {
        try (Connection connection = connectionFactory.createConnection()) {
            Session session = connection.createSession(false,
                    Session.AUTO_ACKNOWLEDGE);
            MessageProducer messageProducer =
                    session.createProducer(myTopic);
            TextMessage message = session.createTextMessage();
            for (int i = 0; i < 10; i++) {
                message.setText(list.get(0)+" "+ list.get(1)+" "+list.get(2));
                messageProducer.send(message);
            }
        } catch (JMSException e) {
            throw new RuntimeException(e);
        }
    }
}
