package ru.ionovsoft.stub.config;

import org.apache.activemq.spring.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.listener.DefaultMessageListenerContainer;
import org.springframework.jms.listener.MessageListenerContainer;
import ru.ionovsoft.stub.commons.Props;

import javax.jms.ConnectionFactory;
import javax.jms.MessageListener;

@Configuration
public class JmsConfig {

    private static final String DEFAULT_URL_BROKER = "tcp://" + Props.HOST + ":" + Props.PORT;

    @Autowired
    private MessageListener messageListener;

    @Bean
    public ConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        connectionFactory.setBrokerURL(DEFAULT_URL_BROKER);
        return connectionFactory;
    }

    @Bean
    public JmsTemplate jmsTemplate(ConnectionFactory connectionFactory){
        return new JmsTemplate(connectionFactory);
    }

    @Bean
    public MessageListenerContainer getContainer(){
        DefaultMessageListenerContainer container = new DefaultMessageListenerContainer();
        container.setConnectionFactory(connectionFactory());
        container.setDestinationName(Props.INPUT_QUEUE);
        container.setMessageListener(messageListener);
        container.setConcurrentConsumers(4);
        return container;
    }


}
