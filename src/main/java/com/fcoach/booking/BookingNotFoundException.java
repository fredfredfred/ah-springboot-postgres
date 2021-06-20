package com.fcoach.booking;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "booking not found")
public class BookingNotFoundException extends RuntimeException {
}
