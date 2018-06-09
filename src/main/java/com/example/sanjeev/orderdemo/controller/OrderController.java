package com.example.sanjeev.orderdemo.controller;

import com.example.sanjeev.orderdemo.domain.Fulfillment;
import com.example.sanjeev.orderdemo.domain.FulfillmentDto;
import com.example.sanjeev.orderdemo.service.OrderService;
import com.example.sanjeev.orderdemo.transformer.OrderTransformer;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RestController
@AllArgsConstructor
public class OrderController {

    private final OrderService orderService;
    private final OrderTransformer orderTransformer;

    @ApiOperation(value = "getOrders", produces = APPLICATION_JSON_VALUE)
    @GetMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FulfillmentDto>> getOrders() {

        List<Fulfillment> fulfillments = orderService.getOrders();
        return ResponseEntity.ok().body(orderTransformer.domainsTodtoList(fulfillments));
    }

    @PostMapping(path = "/orders", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FulfillmentDto>> createOrder(@RequestBody List<FulfillmentDto> fulfillmentDtos) {

        List<Fulfillment> fulfillments = orderService.createOrder(orderTransformer.dtosToDomains(fulfillmentDtos));

        return ResponseEntity
                .created(URI.create("/orders/"))
                .body(orderTransformer.domainsTodtoList(fulfillments));
    }

    @GetMapping(path = "/orders/{fulfillmentId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FulfillmentDto> getFulfillment(@PathVariable String fulfillmentId) {

        return ResponseEntity.ok(orderTransformer.domainToDto(orderService.getOrder(fulfillmentId)));

    }


}

