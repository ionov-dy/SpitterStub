package ru.ionovsoft.stub.messages.jms;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ionovsoft.stub.service.SpittleService;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@Component
public class ActiveMqReceiverImpl implements MessageListener {

    private static final Logger logger = LogManager.getLogger(ActiveMqReceiverImpl.class.getName());

    @Autowired
    private SpittleService service;

    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        String mess = null;
        try {
            mess = textMessage.getText();
        } catch (JMSException e) {
            e.printStackTrace();
        }
        logger.info("Receive message: " + mess);
        service.service(textMessage);
    }

}
