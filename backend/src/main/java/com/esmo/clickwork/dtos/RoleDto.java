package com.esmo.clickwork.dtos;

import com.esmo.clickwork.enums.RolesEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RoleDto {

    private String id;
    private RolesEnum name;
}
