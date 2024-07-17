package com.ms.user.configs;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

@Configuration
public class JmsConfig {

    @Bean
    @Primary
    public ActiveMQConnectionFactory connectionFactory(){
        ActiveMQConnectionFactory connection = new ActiveMQConnectionFactory();
        connection.setBrokerURL("tcp://host.docker.internal:61616");
        connection.setUserName("admin");
        connection.setPassword("admin");
        return connection;
    }

    @Bean
    @Primary
    public JmsTemplate jmsTemplate(){
        JmsTemplate template = new JmsTemplate();
        template.setConnectionFactory(connectionFactory());
        return template;
    }

    @Bean
    @Primary
    public DefaultJmsListenerContainerFactory defaultJmsListenerContainerFactory(){
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory());
        return factory;
    }
}