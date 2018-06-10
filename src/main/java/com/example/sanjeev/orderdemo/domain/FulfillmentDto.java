package com.example.sanjeev.orderdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FulfillmentDto implements Serializable {

    private static final long serialVersionUID = 5472313093825665286L;

    private String fulfillmentId;

    @NotBlank
    private String vin;
    @NotBlank
    private String sku;
    @NotBlank
    private String rateplanid;
    @Email(message = "email.is.not.valid")
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;
    private LocalDateTime timestamp;
}
