package com.example.sanjeev.orderdemo.javaprograms.collections;

import com.example.sanjeev.orderdemo.javaprograms.Product;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.List;

@Slf4j
public class TestHashSet {

    public static void main(String[] args) {
        Product product1 = Product.builder().id(1).sku("SKU1").ratePlan("R1").build();
        Product product2 = Product.builder().id(1).sku("SKU1").ratePlan("R1").build();

        log.info("product1.equals(product2):{}", product1.equals(product2) );

        List<Product> products = Lists.newArrayList(product1,product2);
        System.out.println(products);

        HashSet<Product> productHashSet = new HashSet<>();
        productHashSet.add(product1);
        productHashSet.add(product2);

        System.out.println("hashset size is: "+productHashSet.size());
        boolean contains = productHashSet.contains(Product.builder().id(1).sku("SKU1").ratePlan("R1").build());
        log.info("contains in set:{}", contains );

    }
}
