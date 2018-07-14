package com.example.sanjeev.orderdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.Email;
import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.PastOrPresent;
import java.io.Serializable;
import java.time.OffsetDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FulfillmentDto implements Serializable {

    private static final long serialVersionUID = 5472313093825665286L;

    private String fulfillmentId;

    @NotBlank(message = "vin.not.valid")
    private String vin;
    @NotBlank(message = "sku.not.valid")
    private String sku;
    @NotBlank(message = "rateplanid.not.valid")
    private String rateplanid;
    @Email(message = "email.is.not.valid")
    private String email;

    @PastOrPresent(message = "startdate.past")
    private OffsetDateTime startDate;
    @Future(message = "endDate.futuredate")
    private OffsetDateTime endDate;

    @NotBlank(message = "country.not.valid")
    private String country;

    private String state;
    @NotBlank(message = "customerType.not.valid")
    private String customerType;

    @CreditCardNumber(message = "credit.card.is.not.valid")
    private String creditCard;
}
