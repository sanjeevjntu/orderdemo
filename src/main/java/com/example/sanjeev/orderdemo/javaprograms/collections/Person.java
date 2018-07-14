package com.example.sanjeev.orderdemo.javaprograms.collections;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.PositiveOrZero;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Person {

    private String name;
    @PositiveOrZero
    private Integer age;
}
