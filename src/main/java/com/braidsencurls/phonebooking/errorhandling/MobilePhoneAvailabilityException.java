package com.braidsencurls.phonebooking.errorhandling;

public class MobilePhoneAvailabilityException extends RuntimeException {
    public MobilePhoneAvailabilityException(String message) {
        super(message);
    }
}
