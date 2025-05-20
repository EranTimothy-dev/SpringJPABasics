package com.db.models;

import jakarta.persistence.MappedSuperclass;

import java.time.LocalDateTime;

@MappedSuperclass // any entity that extends this class will have its attributes but this wont be a separate table
public class BaseEntity {

    private LocalDateTime createdAt;
    private LocalDateTime lasModifiedAt;
    private String createdBy;
    private String lastModifiedBy;
}
