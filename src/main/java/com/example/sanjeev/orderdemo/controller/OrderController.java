package com.example.sanjeev.orderdemo.controller;

import com.example.sanjeev.orderdemo.domain.FulfillmentDto;
import com.example.sanjeev.orderdemo.repository.Fulfillment;
import com.example.sanjeev.orderdemo.service.OrderService;
import com.example.sanjeev.orderdemo.transformer.OrderTransformer;
import com.google.common.base.Strings;
import io.swagger.annotations.ApiOperation;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @RequiredArgsConstructor considers only final and constants
 */
@Slf4j
@RestController
@AllArgsConstructor
//@DependsOn()
//@ConditionalOnMissingBean()
//@Transactional(isolation = Isolation.READ_COMMITTED, propagation=Propagation.REQUIRES_NEW, timeout =1,
//        noRollbackFor = SQLException.class, rollbackFor = Exception.class)//DEFAULT REQUIRED
//@ConditionalOnProperty(havingValue = "")
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON, scopeName = "singleton")
//1. Single and concurreny
//Difference between Java Singleton and Spring
/**
 * 1. Spring’s singleton beans are shared among all the requests when your application
 * is running on the multi-threaded environment. How to ensure that your program is thread-safe?.
 *
 * 2. Java singleton is per classloader and spring singleton is per application context for a bean
 */
public class OrderController {

    private  OrderService orderService;
    private  OrderTransformer orderTransformer;

    @ApiOperation(value = "getOrder", produces = APPLICATION_JSON_VALUE)
    @GetMapping(path = "/orders", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FulfillmentDto>> getOrders() {

        List<Fulfillment> fulfillments = orderService.getOrders();
        return ResponseEntity.ok().body(orderTransformer.domainsToDtos(fulfillments));
    }

    @PostMapping(path = "/orders", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FulfillmentDto>> createOrder(@RequestBody @Validated List<FulfillmentDto> fulfillmentDtos,
                                                            @RequestHeader(value = "application-id") String applicationId) {

        if (Strings.isNullOrEmpty(applicationId)) {
            throw new RuntimeException("application-id is null or empty");
        }

        List<Fulfillment> fulfillments = orderService.createOrder(orderTransformer.dtosToDomains(fulfillmentDtos));

        return ResponseEntity
                .created(URI.create("/orders/"))
                .body(orderTransformer.domainsToDtos(fulfillments));
    }

    @PostMapping(path = "/fulfillments", consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FulfillmentDto> createFulfillment(@RequestBody @Validated FulfillmentDto fulfillmentDto,
                                                            @RequestHeader(value = "application-id") String applicationId) {

        if (Strings.isNullOrEmpty(applicationId)) {
            throw new RuntimeException("application-id is null or empty");
        }

        Fulfillment fulfillment = orderService.createFulfillment(orderTransformer.dtoToDomain(fulfillmentDto));

        return ResponseEntity
                .created(URI.create("/fulfillments/"))
                .body(orderTransformer.domainToDto(fulfillment));
    }

    @GetMapping(path = "/orders/{fulfillmentId}", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FulfillmentDto> getFulfillment(@PathVariable String fulfillmentId) {

        return ResponseEntity.ok(orderTransformer.domainToDto(orderService.getOrder(fulfillmentId)));

    }

    @ApiOperation(value = "getOrder By VIN", produces = APPLICATION_JSON_VALUE, notes = "getOrder By VIN")
    @GetMapping(path = "/orders", params = "vin", produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<List<FulfillmentDto>> getFulfillmentByVin(@RequestParam String vin) {
        return ResponseEntity.ok(orderTransformer.domainsToDtos(orderService.getFulfillmentByVin(vin)));
    }

    @ApiOperation(value = "getOrder By VIN and SKU", produces = APPLICATION_JSON_VALUE, notes = "getOrder By VIN and SKU")
    @GetMapping(value = "/orders/byvinsku", params = {"vin", "country", "state", "customerType"}, produces = APPLICATION_JSON_VALUE)
    public ResponseEntity<FulfillmentDto> getFulfillmentByVinSku(@RequestParam String vin,
                                                                 @RequestParam String country,
                                                                 @RequestParam String state,
                                                                 @RequestParam String customerType) {
        return ResponseEntity.ok(orderTransformer.domainToDto(orderService.getFulfillmentByVinAndSku(vin, country, state, customerType)));
    }


}

