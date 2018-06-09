package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.domain.Fulfillment;

import java.util.List;

public interface OrderService {
    List<Fulfillment> getOrders();

    List<Fulfillment> createOrder(List<Fulfillment> fulfillments);

    Fulfillment getOrder(String fulfillmentId);
}
