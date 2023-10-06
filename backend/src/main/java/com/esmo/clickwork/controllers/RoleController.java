package com.esmo.clickwork.controllers;

import com.esmo.clickwork.dtos.ApiResponse;
import com.esmo.clickwork.enums.RolesEnum;
import com.esmo.clickwork.mappers.RoleMapper;
import com.esmo.clickwork.services.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/roles")
@RequiredArgsConstructor
public class RoleController {

    private final RoleService roleService;
    private final RoleMapper mapper;

    @GetMapping("/findAll")
    public ResponseEntity<ApiResponse> findAll() {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find all roles", roleService.findAll().stream().map(mapper::toDTO).toList()));
    }

    @GetMapping("/findByName")
    public ResponseEntity<ApiResponse> findByRole(@RequestParam RolesEnum name) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Find role by name", roleService.findByRole(name)));
    }
}
