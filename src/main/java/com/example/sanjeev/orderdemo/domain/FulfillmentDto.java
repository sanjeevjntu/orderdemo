package com.example.sanjeev.orderdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.CreditCardNumber;

import javax.validation.constraints.*;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class FulfillmentDto {

    private String fulfillmentId;

    @NotBlank(message = "vin.not.valid")
    private String vin;
    @NotBlank(message = "sku.not.valid")
    private String sku;
    @NotBlank(message = "rateplanid.not.valid")
    private String rateplanid;
    @Email(message = "email.is.not.valid")
    private String email;

    @FutureOrPresent(message = "startdate.past")
    private LocalDate startDate;

    @Future(message = "endDate.futuredate")
    private LocalDate endDate;

    @NotBlank(message = "country.not.valid")
    private String country;

    private String state;
    @NotBlank(message = "customerType.not.valid")
    private String customerType;

    @NotBlank(message = "subscriptionType.not.valid")
    @Pattern(message = "subscriptionType.not.valid", regexp = "EVERGREEN|TERMED", flags = Pattern.Flag.CASE_INSENSITIVE)
    private String subscriptionType;

    @CreditCardNumber(message = "credit.card.is.not.valid")
    private String creditCard;

    @AssertTrue(message = "endDate.not.valid")
    private boolean isValidEnddate(){
         if("TERMED".equals(subscriptionType) && endDate ==null){
            return false;
        } else return true; // TERMED, enddate; EVERGREEN, endDate; EVERGREEN, null
    }

    @AssertTrue(message = "startDate.not.valid")
    private boolean isValidStartDate() {
        return (endDate == null && "EVERGREEN".equals(subscriptionType))     ||
                (startDate != null && startDate.isBefore(endDate));
    }
}
