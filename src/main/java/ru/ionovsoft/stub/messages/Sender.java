package ru.ionovsoft.stub.messages;

import javax.jms.TextMessage;

public interface Sender {

    void send(TextMessage message);

}
