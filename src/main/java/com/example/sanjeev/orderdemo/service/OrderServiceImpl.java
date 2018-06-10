package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.domain.Fulfillment;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final FulfillmentRepository fulfillmentRepository;

    @Override
    public List<Fulfillment> getOrders() {
        return fulfillmentRepository.findAll();
    }

    @Override
    public List<Fulfillment> createOrder(List<Fulfillment> fulfillments) {
        return fulfillmentRepository.saveAll(fulfillments);
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
