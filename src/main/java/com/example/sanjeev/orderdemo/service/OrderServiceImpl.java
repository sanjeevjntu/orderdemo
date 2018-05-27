package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.domain.Fulfillment;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    private FulfillmentRepository fulfillmentRepository;

    public OrderServiceImpl(FulfillmentRepository fulfillmentRepository) {
        this.fulfillmentRepository = fulfillmentRepository;
    }

    @Override
    public List<Fulfillment> getOrders() {

        return fulfillmentRepository.findAll();
    }

    @Override
    public List<Fulfillment> createOrder(List<Fulfillment> fulfillments) { return fulfillmentRepository.saveAll(fulfillments);
    }
}
