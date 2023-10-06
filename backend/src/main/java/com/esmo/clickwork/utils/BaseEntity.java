package com.esmo.clickwork.utils;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@MappedSuperclass
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
}
