package com.esmo.clickwork.controllers;

import com.esmo.clickwork.dtos.ApiResponse;
import com.esmo.clickwork.dtos.UserDto;
import com.esmo.clickwork.mappers.UserMapper;
import com.esmo.clickwork.services.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final UserMapper mapper;

    @GetMapping("/findByEmail")
    public ResponseEntity<ApiResponse> findByEmail(@RequestParam String email) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find user by email", mapper.toDTO(userService.findByEmail(email))));
    }

    @GetMapping("/findByUsername")
    public ResponseEntity<ApiResponse> findByUsername(String username) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find user by username", mapper.toDTO(userService.findByUsername(username))));

    }

    @PostMapping("/save")
    public ResponseEntity<ApiResponse> save(@RequestBody UserDto userDto) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Create new user", mapper.toDTO(userService.save(mapper.toEntity(userDto)))));
    }
}
