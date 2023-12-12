package com.javamasters.exceptions;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

public class ValidationException extends RuntimeException {
    public ValidationException(String message) {
        super(message);
    }
}
