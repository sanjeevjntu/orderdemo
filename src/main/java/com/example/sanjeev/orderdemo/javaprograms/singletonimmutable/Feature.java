package com.example.sanjeev.orderdemo.javaprograms.singletonimmutable;

import lombok.*;
import lombok.experimental.FieldDefaults;

@ToString
@EqualsAndHashCode
@AllArgsConstructor
@FieldDefaults(makeFinal = true, level = AccessLevel.PRIVATE)
@Getter
public final class Feature {

    private final String featureCode;
    private final String featurePackageCode;
}
