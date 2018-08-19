package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.rabbitmq.OrderPublisher;
import com.example.sanjeev.orderdemo.repository.Fulfillment;
import com.example.sanjeev.orderdemo.repository.FulfillmentRepository;
import com.example.sanjeev.orderdemo.transformer.OrderTransformer;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.redis.core.TimeToLive;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class OrderServiceImpl implements OrderService {

    private final FulfillmentRepository fulfillmentRepository;
    private final OrderPublisher orderPublisher;
    private final OrderTransformer orderTransformer;

    @Override
    public List<Fulfillment> getOrders() {
        return fulfillmentRepository.findAll();
    }

    @Override
    @Transactional
    public List<Fulfillment> createOrder(List<Fulfillment> fulfillments) {

        List<Fulfillment> fulfillmentsSaved = fulfillmentRepository.saveAll(fulfillments);

        log.info("fulfillmentsSaved:{}", fulfillmentsSaved);
        orderTransformer.domainsToDtos(fulfillmentsSaved)
                .forEach(orderPublisher::publishOrder);

        return fulfillmentsSaved;

    }

    @Override
    public Fulfillment getOrder(String fulfillmentId) {
        Fulfillment fulfillment = fulfillmentRepository.findById(fulfillmentId)
                .orElseGet(FulfillmentClientInvoker::getFromClientInvoker);
        log.info("Fulfillment: {}", fulfillment);

        return fulfillment;
    }

    @Override
    @Cacheable(value = "getFulfillmentByVin", key = "#vin")
    @TimeToLive
    public List<Fulfillment> getFulfillmentByVin(String vin) {
        return fulfillmentRepository.findAllByVin(vin);
    }

    @Override
    public Fulfillment getFulfillmentByVinAndSku(String vin, String country, String state, String customerType) {

        return fulfillmentRepository.findByVinAndCountryAndStateAndCustomerType(vin, country, state, customerType)
                // .map(OrderServiceImpl::apply)
                // .orElseGet(FulfillmentClientInvoker::getFromClientInvoker);
                .orElseGet(Fulfillment.builder()::build);

    }

    @Override
    public Fulfillment createFulfillment(Fulfillment fulfillment) {
        return fulfillmentRepository.save(fulfillment);
    }
}
