package com.example.sanjeev.orderdemo.transformer;

import com.example.sanjeev.orderdemo.domain.Fulfillment;
import com.example.sanjeev.orderdemo.domain.FulfillmentDto;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Component
@Slf4j
@AllArgsConstructor
public class OrderTransformer {

    public FulfillmentDto domainToDto(Fulfillment fulfillment) {
        return FulfillmentDto.builder()
                .fulfillmentId(fulfillment.getFulfillmentId().toString())
                .email(fulfillment.getEmail())
                .rateplanid(fulfillment.getRateplanid())
                .sku(fulfillment.getSku())
                .vin(fulfillment.getVin())
                .startDate(fulfillment.getStartDate())
                .endDate(fulfillment.getEndDate())
                .timestamp(LocalDateTime.now())
                .build();
    }

    public Fulfillment dtoToDomain(FulfillmentDto fulfillmentDto) {
        return Fulfillment.builder()
                .email(fulfillmentDto.getEmail())
                .rateplanid(fulfillmentDto.getRateplanid())
                .sku(fulfillmentDto.getSku())
                .vin(fulfillmentDto.getVin())
                .startDate(fulfillmentDto.getStartDate())
                .endDate(fulfillmentDto.getEndDate())
                .build();
    }

    public List<FulfillmentDto> domainsToDtos(List<Fulfillment> fulfillmentList) {
        return fulfillmentList.stream()
                .map(this::domainToDto)
                .collect(Collectors.toList());

    }

    public List<Fulfillment> dtosToDomains(List<FulfillmentDto> fulfillmentDtos) {
        return fulfillmentDtos.stream()
                .map(this::dtoToDomain)
                .collect(Collectors.toList());
    }

}
