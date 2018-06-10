package com.example.sanjeev.orderdemo.rabbitmq;

import com.example.sanjeev.orderdemo.domain.FulfillmentDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class OrderSubscriber {

    @RabbitListener(queues = "${rabbitmq.order.queue}")
    public void receive(FulfillmentDto fulfillmentDto) {

        log.info("fulfillmentDto:{}", fulfillmentDto);


    }
}
