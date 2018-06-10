package com.example.sanjeev.orderdemo.rabbitmq;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties
public class OrderPublisherConfiguration {

    @Value(value = "${rabbitmq.order.exchange}")
    private String orderExchangeName;

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(orderExchangeName);
    }
}
