package com.example.sanjeev.orderdemo.rabbitmq;

import com.example.sanjeev.orderdemo.domain.FulfillmentDto;
import com.example.sanjeev.orderdemo.repository.Fulfillment;
import com.example.sanjeev.orderdemo.repository.FulfillmentRepository;
import com.example.sanjeev.orderdemo.transformer.OrderTransformer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * Message date needs to be fixed
 * 1. Any exception in the while listening will put the message to DLQ
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class OrderSubscriber {

    private final OrderTransformer orderTransformer;
    private final FulfillmentRepository fulfillmentRepository;

    @RabbitListener(queues = "${rabbitmq.order.queue}")
    @Transactional
    public void receive(FulfillmentDto fulfillmentDto) {

        log.info("fulfillmentDto:{}", fulfillmentDto);

        Fulfillment fulfillment = fulfillmentRepository.getOne(UUID.fromString(fulfillmentDto.getFulfillmentId()));

        fulfillment.setEmail("newEmailUpdated@ddd.com");
        fulfillmentRepository.save(fulfillment);

    }
}
