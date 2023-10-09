package com.esmo.clickwork.controllers;

import com.esmo.clickwork.annotations.CurrentUser;
import com.esmo.clickwork.dtos.ApiResponse;
import com.esmo.clickwork.dtos.ScheduleDto;
import com.esmo.clickwork.mappers.ScheduleMapper;
import com.esmo.clickwork.services.ScheduleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/schedules")
@RequiredArgsConstructor
public class ScheduleController {

    private final ScheduleService scheduleService;
    private final ScheduleMapper mapper;

    @RequestMapping("/findByUserId")
    public ResponseEntity<ApiResponse> findByUserId(@RequestParam String userId) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find schedules by user id", scheduleService.findByUserEmail(userId).stream().map(mapper::toDTO).toList()));
    }

    @RequestMapping("/findByUserEmail")
    public ResponseEntity<ApiResponse> findByUserEmail(@CurrentUser String userId) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find schedules by user id", scheduleService.findByUserEmail(userId).stream().map(mapper::toDTO).toList()));
    }

    @GetMapping("/findById")
    public ResponseEntity<ApiResponse> findById(@RequestParam String id) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find schedule by id", mapper.toDTO(scheduleService.findById(id))));
    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody ScheduleDto scheduleDto) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Create new schedule", mapper.toDTO(scheduleService.save(mapper.toEntity(scheduleDto)))));
    }

    @PutMapping("/update")
    public ResponseEntity<ApiResponse> update(@RequestBody ScheduleDto scheduleDto) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Update schedule", mapper.toDTO(scheduleService.update(mapper.toEntity(scheduleDto)))));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ApiResponse> delete(@RequestParam String id) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Delete schedule", scheduleService.delete(id)));
    }
}
