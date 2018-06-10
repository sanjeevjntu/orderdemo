package com.example.sanjeev.orderdemo.rabbitmq;

import com.example.sanjeev.orderdemo.domain.FulfillmentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderPublisher {

    private final RabbitTemplate rabbitTemplate;
    private final TopicExchange topicExchange;

    @Value(value = "${rabbitmq.order.routingKey}")
    private String orderRoutingKey;

    @Autowired
    public OrderPublisher(RabbitTemplate rabbitTemplate, TopicExchange topicExchange) {
        this.rabbitTemplate = rabbitTemplate;
        this.topicExchange = topicExchange;
    }

    public void publishOrder(FulfillmentDto fulfillmentDto) {
        log.info("topicExchange :{}", topicExchange);
        log.info("orderRoutingKey :{}", orderRoutingKey);
        log.info("fulfillmentDto :{}", fulfillmentDto);
        rabbitTemplate.convertAndSend(topicExchange.getName(), orderRoutingKey, fulfillmentDto);
    }


}
