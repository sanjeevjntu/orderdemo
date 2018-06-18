package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.repository.Fulfillment;

import java.util.List;

public interface OrderService {
    List<Fulfillment> getOrders();

    List<Fulfillment> createOrder(List<Fulfillment> fulfillments);

    Fulfillment getOrder(String fulfillmentId);

    List<Fulfillment> getFulfillmentByVin(String vin);

    Fulfillment getFulfillmentByVinAndSku(String vin, String country, String state, String customerType);

    Fulfillment createFulfillment(Fulfillment fulfillment);
}


