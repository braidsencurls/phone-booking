package com.braidsencurls.phonebooking.errorhandling;

public class UnknownMobilePhoneException extends RuntimeException {
    public UnknownMobilePhoneException(String message) {
        super(message);
    }
}
