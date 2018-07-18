package com.example.sanjeev.orderdemo.service;

import com.example.sanjeev.orderdemo.repository.Fulfillment;

import java.time.LocalDate;
import java.util.UUID;

public interface FulfillmentClientInvoker {

    static Fulfillment getFromClientInvoker() {
        return Fulfillment.builder()
                .fulfillmentId(UUID.randomUUID())
                .vin("VINDUMMY")
                .sku("SKUDUMMY")
                .rateplanid("RATEDUMMY")
                .startDate(LocalDate.now())
                .email("san@dummy.com")
                .endDate(LocalDate.now()).build();
    }
}
