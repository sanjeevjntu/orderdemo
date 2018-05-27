package com.example.sanjeev.orderdemo.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.util.UUID;


@Entity
@Table(name = "FULFILLMENT")
public class Fulfillment {

    @Id
    @GeneratedValue(generator ="uuid2")
    @GenericGenerator(name = "uuid2" , strategy = "uuid2")
    private UUID fulfillmentId;

    @NotBlank
    private String vin;
    @NotBlank
    private String sku;
    @NotBlank
    private String rateplanid;
    @Email(message = "email.is.not.valid")
    private String email;

    public Fulfillment(@NotBlank String vin, @NotBlank String sku, @NotBlank String rateplanid, @Email(message = "email.is.not.valid") String email) {
        this.vin = vin;
        this.sku = sku;
        this.rateplanid = rateplanid;
        this.email = email;
    }

    @Override
    public String toString() {
        return "Fulfillment{" +
                "fulfillmentId=" + fulfillmentId +
                ", vin='" + vin + '\'' +
                ", sku='" + sku + '\'' +
                ", rateplanid='" + rateplanid + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public Fulfillment() {
    }

    public UUID getFulfillmentId() {
        return fulfillmentId;
    }

    public void setFulfillmentId(UUID fulfillmentId) {
        this.fulfillmentId = fulfillmentId;
    }

    public String getVin() {
        return vin;
    }

    public void setVin(String vin) {
        this.vin = vin;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public String getRateplanid() {
        return rateplanid;
    }

    public void setRateplanid(String rateplanid) {
        this.rateplanid = rateplanid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
