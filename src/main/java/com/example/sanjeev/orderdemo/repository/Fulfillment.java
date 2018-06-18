package com.example.sanjeev.orderdemo.repository;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FULFILLMENT", uniqueConstraints = @UniqueConstraint(columnNames = {"VIN", "COUNTRY", "STATE", "CUSTOMER_TYPE"}, name = "unique_constraint_vin_country_state_customertype"))
@EntityListeners(AuditingEntityListener.class)
public class Fulfillment extends BaseEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID fulfillmentId;

    @NotBlank
    private String vin;
    @NotBlank
    private String sku;
    @NotBlank
    private String rateplanid;
    @NotBlank
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;

    @NotBlank
    private String country;

    private String state;
    @NotBlank
    @Column(name = "CUSTOMER_TYPE")
    private String customerType;


}
