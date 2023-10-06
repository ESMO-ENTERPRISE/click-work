package com.esmo.clickwork.mappers;

import com.esmo.clickwork.dtos.RoleDto;
import com.esmo.clickwork.entities.Role;
import com.esmo.mapper.common.annotations.EnableSpring;
import com.esmo.mapper.common.annotations.Mapper;

@Mapper
@EnableSpring
public interface RoleMapper {

    RoleDto toDTO(Role role);
}
