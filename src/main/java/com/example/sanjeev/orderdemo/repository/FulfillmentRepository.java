package com.example.sanjeev.orderdemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface FulfillmentRepository extends JpaRepository<Fulfillment, String> {
    List<Fulfillment> findAllByVin(String vin);

    Optional<Fulfillment> findByVinAndCountryAndStateAndCustomerType(String vin, String country, String state, String customerType);
}

