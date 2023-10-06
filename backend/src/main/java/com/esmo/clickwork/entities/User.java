package com.esmo.clickwork.entities;

import com.esmo.clickwork.utils.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;

@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "users")
public class User extends BaseEntity {

    private String username;

    private String password;

    private String email;

    private String name;

    @Column(name = "last_name")
    private String lastName;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "role")
    private Role role;

    @CreationTimestamp
    private Date created;

    @UpdateTimestamp
    private Date updated;
}


