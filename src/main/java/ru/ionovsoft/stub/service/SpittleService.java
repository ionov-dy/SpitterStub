package ru.ionovsoft.stub.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.ionovsoft.stub.messages.jms.ActiveMqSenderImpl;

import javax.jms.TextMessage;

@Component("service")
public class SpittleService {

    @Autowired
    private ActiveMqSenderImpl sender;

    public void service(TextMessage message){
        sender.send(message);
    }

}
