package com.esmo.clickwork.controllers;

import com.esmo.clickwork.dtos.ApiResponse;
import com.esmo.clickwork.dtos.SignInDto;
import com.esmo.clickwork.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signin")
    public ResponseEntity<ApiResponse> signIn(@RequestBody SignInDto signInDto) {
        return ResponseEntity.ok(new ApiResponse(HttpStatus.OK, new Date(), "Sign in", authService.signIn(signInDto)));
    }
}
