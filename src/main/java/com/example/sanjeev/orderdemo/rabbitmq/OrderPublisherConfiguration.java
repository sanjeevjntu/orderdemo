package com.example.sanjeev.orderdemo.rabbitmq;


import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
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
        return new TopicExchange(orderExchangeName, false, false);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        //Jackson2JsonMessageConverter jackson2JsonMessageConverter = new Jackson2JsonMessageConverter();
        return new Jackson2JsonMessageConverter();
    }

    public void setOrderExchangeName(String orderExchangeName) {
        this.orderExchangeName = orderExchangeName;
    }
}
