package ru.ionovsoft.stub.messages.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Component;
import ru.ionovsoft.stub.commons.Props;
import ru.ionovsoft.stub.messages.Sender;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

@Component
public class ActiveMqSenderImpl implements Sender {

    private static final String QUEUE = Props.OUTPUT_QUEUE;

    private static final Logger logger = LogManager.getLogger(ActiveMqSenderImpl.class.getName());

    @Autowired
    private JmsTemplate jmsTemplate;

    public void send(final TextMessage message) {
        jmsTemplate.send(QUEUE, new MessageCreator() {
            public Message createMessage(Session session) throws JMSException {
                logger.info("Send answer for: " + message.getText());
                return session.createTextMessage("ANSWER FOR: " + message.getText());
            }
        });
    }

}
