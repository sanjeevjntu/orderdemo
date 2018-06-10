package com.example.sanjeev.orderdemo.rabbitmq;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class OrderSubscriberConfiguration {

    @Value("${rabbitmq.order.queue}")
    private String orderQueue;

    @Value("${rabbitmq.order.routingKey}")
    private String routingKey;

    @Value("${rabbitmq.order.exchange}")
    private String orderExchange;

    @Bean
    public Queue orderQueue() {
        return QueueBuilder.durable(orderQueue).build();
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange(orderExchange);
    }

    @Bean
    public Binding orderQueueBinding(Queue orderQueue, TopicExchange orderExchange) {
        return BindingBuilder.bind(orderQueue).to(orderExchange).with(routingKey);
    }


}
