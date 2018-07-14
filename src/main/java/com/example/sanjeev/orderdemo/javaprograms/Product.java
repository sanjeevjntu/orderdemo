package com.example.sanjeev.orderdemo.javaprograms;

import lombok.*;

import java.util.Objects;

@Setter @Getter @ToString
@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Product {

    private int id;
    private String sku;
    private String ratePlan;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(id, product.id) &&
                Objects.equals(sku, product.sku) &&
                Objects.equals(ratePlan, product.ratePlan);
    }


}
