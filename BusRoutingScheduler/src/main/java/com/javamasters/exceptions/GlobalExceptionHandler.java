package com.javamasters.exceptions;

import com.javamasters.response.CoreResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


/**
 * @Author: subhag.jain
 * date: 11/12/23
 * project: BusRoutingScheduler
 */

@ControllerAdvice(basePackages = {"com.javamasters"})
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CoreResponseDto> exception(Exception e) {
        CoreResponseDto ex = CoreResponseDto.builder().operationSuccessful(false).message("INTERNAL SERVER ERROR : An unexpected error occurred. " + e.getMessage()).build();
        return new ResponseEntity<>(ex, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(AuthenticationException.class)
    public ResponseEntity<CoreResponseDto> authenticationException(AuthenticationException e) {
        CoreResponseDto ex = CoreResponseDto.builder().operationSuccessful(false).message("Authentication Exception : " + e.getMessage()).build();
        return new ResponseEntity<>(ex, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(ValidationException.class)
    public ResponseEntity<CoreResponseDto> validationException(ValidationException e) {
        CoreResponseDto ex = CoreResponseDto.builder().operationSuccessful(false).message("Validation Exception : " + e.getMessage()).build();
        return new ResponseEntity<>(ex, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<CoreResponseDto> recordNotFound(RecordNotFoundException e) {
        CoreResponseDto ex = CoreResponseDto.builder().operationSuccessful(false).message("Record Not Found : " + e.getMessage()).build();
        return new ResponseEntity<>(ex, HttpStatus.NOT_FOUND);
    }


}