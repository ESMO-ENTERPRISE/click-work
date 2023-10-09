package com.esmo.clickwork.mappers;

import com.esmo.clickwork.dtos.ScheduleDto;
import com.esmo.clickwork.entities.Schedule;
import com.esmo.mapper.common.annotations.EnableSpring;
import com.esmo.mapper.common.annotations.Mapper;

@Mapper
@EnableSpring
public interface ScheduleMapper {

    ScheduleDto toDTO(Schedule schedule);

    Schedule toEntity(ScheduleDto scheduleDto);
}
