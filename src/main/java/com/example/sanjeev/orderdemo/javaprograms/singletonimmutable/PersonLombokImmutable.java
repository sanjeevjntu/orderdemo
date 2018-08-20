package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

import lombok.*;
import lombok.experimental.FieldDefaults;

//Immutable class - @Value or below same
@Builder(toBuilder = true)//if it not there this class is immuatble
@ToString
@EqualsAndHashCode
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public final class PersonLombokImmutable {

    @NonNull
    private final String name;
    @NonNull
    private   final String city;
    @NonNull
    private final Integer age;
    @NonNull
    private final String car;

}
