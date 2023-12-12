package com.javamasters.exceptions;

/**
 * @Author: subhag.jain
 * date: 03/12/23
 * project: BusRoutingScheduler
 */

public class RecordNotFoundException extends RuntimeException {
    public RecordNotFoundException(String message) {
        super(message);
    }
}
