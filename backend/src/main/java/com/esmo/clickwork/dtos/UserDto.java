package com.esmo.clickwork.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {

    private String id;
    private String email;
    private String username;
    private RoleDto role;
    private String name;
    private String lastName;
    private String password;
    private Date created;
    private Date updated;
}
