package com.esmo.clickwork.entities;

import com.esmo.clickwork.enums.RolesEnum;
import com.esmo.clickwork.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "roles")
public class Role extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private RolesEnum name;
}
