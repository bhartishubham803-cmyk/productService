package com.shubhambharti.productservice.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

@MappedSuperclass
@Getter
@Setter
@EntityListeners(AuditingEntityListener.class)
public class BaseModel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;//if i add long you can use long for storing time in the form of epoch
    @LastModifiedDate
    private LocalDateTime updatedAt;
    private Boolean isDeleted = false;
}
