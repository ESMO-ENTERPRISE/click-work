package com.esmo.clickwork.mappers;

import com.esmo.clickwork.dtos.UserDto;
import com.esmo.clickwork.entities.User;
import com.esmo.mapper.common.annotations.EnableSpring;
import com.esmo.mapper.common.annotations.FieldIgnore;
import com.esmo.mapper.common.annotations.Mapper;
import com.esmo.mapper.common.annotations.MapperConfig;

@Mapper
@EnableSpring
public interface UserMapper {

    User toEntity(UserDto userDTO);

    @MapperConfig(fieldIgnore = {
            @FieldIgnore("password")
    })
    UserDto toDTO(User user);
}
