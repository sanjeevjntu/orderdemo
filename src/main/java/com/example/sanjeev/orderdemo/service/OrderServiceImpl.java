package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.domain.Fulfillment;
import com.example.sanjeev.orderdemo.rabbitmq.OrderPublisher;
import com.example.sanjeev.orderdemo.transformer.OrderTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

import static com.google.common.collect.Lists.newArrayList;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final FulfillmentRepository fulfillmentRepository;
    private final OrderPublisher orderPublisher;
    private final OrderTransformer orderTransformer;

    @Override
    public List<Fulfillment> getOrders() {
        List<Fulfillment> fulfillments = newArrayList();
        return fulfillmentRepository.findAll();
    }

    @Override
    @Transactional
    public List<Fulfillment> createOrder(List<Fulfillment> fulfillments) {

        List<Fulfillment> fulfillmentsSaved = fulfillmentRepository.saveAll(fulfillments);

        orderTransformer.domainsToDtos(fulfillmentsSaved)
                .forEach(fulfillmentDto -> orderPublisher.publishOrder(fulfillmentDto));

        return fulfillmentsSaved;

    }

    @Override
    public Fulfillment getOrder(String fulfillmentId) {
        Fulfillment fulfillment = fulfillmentRepository.getOne(UUID.fromString(fulfillmentId));
        log.info("Fulfillment: {}", fulfillment);

        return fulfillment;
    }

    @Override
    public List<Fulfillment> getFulfillmentByVin(String vin) {
        return fulfillmentRepository.findAllByVin(vin);
    }
}
