package com.esmo.clickwork.dtos;

import com.esmo.clickwork.enums.ScheduleStatusEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleDto {

    private String id;
    private Date entryTime;
    private Date exitTime;
    private String duration;
    private String notes;
    private ScheduleStatusEnum status;
    private UserDto user;
}
