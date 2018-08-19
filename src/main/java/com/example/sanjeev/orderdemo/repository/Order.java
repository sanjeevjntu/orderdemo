package com.example.sanjeev.orderdemo.repository;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
@Table(name = "SUMO_ORDER")
@EntityListeners(AuditingEntityListener.class)
public class Order extends BaseEntity implements Serializable {

    private static final long serialVe2rsionUID = -8437466925379749685L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "ORDER_ID")
    private UUID orderId;

    private String orderType;

    @OneToMany(mappedBy = "order")
    public List<Fulfillment> fulfillments;

}
