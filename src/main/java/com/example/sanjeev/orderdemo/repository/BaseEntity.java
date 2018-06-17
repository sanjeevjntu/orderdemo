package com.example.sanjeev.orderdemo.repository;

import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Version;
import java.time.LocalDateTime;

@MappedSuperclass
public class BaseEntity {

    @Version
    private Integer version;
    @Column(nullable = false, updatable = false)
    @CreatedDate
    private LocalDateTime createdTS;
    @LastModifiedDate
    private LocalDateTime updatedTS;
    @CreatedBy
    private String createdBy;
    @LastModifiedBy
    private String modifiedBy;
}
