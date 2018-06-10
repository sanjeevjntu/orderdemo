package com.example.sanjeev.orderdemo.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "FULFILLMENT")
@EntityListeners(AuditingEntityListener.class)
public class Fulfillment extends BaseEntity{

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    private UUID fulfillmentId;

    private String vin;
    private String sku;
    private String rateplanid;
    private String email;
    private LocalDate startDate;
    private LocalDate endDate;


}
