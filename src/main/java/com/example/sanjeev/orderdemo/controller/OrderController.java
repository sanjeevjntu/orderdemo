package com.example.sanjeev.orderdemo.controller;

import com.example.sanjeev.orderdemo.domain.Fulfillment;
import com.example.sanjeev.orderdemo.service.OrderService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;


@RestController
public class OrderController {

    private OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @ApiOperation(value="getOrders",produces = APPLICATION_JSON_VALUE )
    @GetMapping(path = "/orderss", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fulfillment>> getOrders(){

        List<Fulfillment> fulfillments = orderService.getOrders();
        return  ResponseEntity.ok().body(fulfillments);
    }

    @PostMapping(path="/orders", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<Fulfillment>> createOrder(@RequestBody List<Fulfillment> fulfillments){

        return  ResponseEntity
                .created(URI.create("/orders/"))
                .body(orderService.createOrder(fulfillments));
    }


}

