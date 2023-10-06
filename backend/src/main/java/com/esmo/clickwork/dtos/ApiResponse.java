package com.esmo.clickwork.dtos;

import org.springframework.http.HttpStatus;

import java.util.Date;

public record ApiResponse(HttpStatus status, Date timestamp, String message, Object data) {
}
