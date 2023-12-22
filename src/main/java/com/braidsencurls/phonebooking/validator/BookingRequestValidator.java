package com.braidsencurls.phonebooking.validator;

import com.braidsencurls.phonebooking.dto.BookingRequest;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class BookingRequestValidator {
    public void validateRequest(String action, BookingRequest request) {
        try {
            if(request == null) {
                throw new IllegalArgumentException();
            }
            switch (action) {
                case "book": {
                    validateMobilePhoneId(request.getMobilePhoneId());
                    validateMobilePhoneName(request.getMobilePhoneName());
                    validateBorrower(request.getBorrower());
                    break;
                }
                case "return": {
                    validateMobilePhoneId(request.getMobilePhoneId());
                    validateMobilePhoneName(request.getMobilePhoneName());
                    break;
                }
                default: {
                    throw new IllegalArgumentException("Unsupported action");
                }
            }
        } catch (Exception e) {
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    private static void validateMobilePhoneId(long id) {
        if(id == 0) {
            throw new IllegalArgumentException("mobile phone id is required");
        }
    }
    private static void validateMobilePhoneName(String name) {
        Objects.requireNonNull(name, "mobile phone name is required");
    }

    private static void validateBorrower(String borrower) {
        Objects.requireNonNull(borrower, "borrower is required");
    }
}
