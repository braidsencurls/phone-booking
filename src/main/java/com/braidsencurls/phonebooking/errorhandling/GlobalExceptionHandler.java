package com.braidsencurls.phonebooking.errorhandling;

import com.braidsencurls.phonebooking.dto.BookingResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    public static final String ERROR = "ERROR";

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<BookingResponse> handleInvalidRequest(IllegalArgumentException ex) {
        return ResponseEntity.status(400).body(new BookingResponse(ERROR, ex.getMessage()));
    }
    @ExceptionHandler(UnknownMobilePhoneException.class)
    public ResponseEntity<BookingResponse> handleUnknownMobileException(UnknownMobilePhoneException ex) {
        return ResponseEntity.status(404).body(new BookingResponse(ERROR, ex.getMessage()));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<BookingResponse> handleGenericExceptions(RuntimeException ex) {
        return ResponseEntity.internalServerError().body(new BookingResponse(ERROR, ex.getMessage()));
    }
}
