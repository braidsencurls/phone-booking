package com.braidsencurls.phonebooking.validator;

import com.braidsencurls.phonebooking.dto.BookingRequest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class BookingRequestValidatorTest {

    private static BookingRequestValidator validator;

    @BeforeAll
    public static void setup() {
        validator = new BookingRequestValidator();
    }


    @Test
    public void shouldSuccessfullyValidateBookingRequest() {
        BookingRequest request = new BookingRequest(1, "iPhone 11", "christine");
        validator.validateRequest("book", request);
    }

    @Test
    public void shouldSuccessfullyValidateReturnRequestOnNullBorrower() {
        BookingRequest request = new BookingRequest(1, "iPhone 11", null);
        validator.validateRequest("return", request);
    }

    @Test
    public void shouldThrowExceptionWhenActionIsUnknown() {
        BookingRequest request = new BookingRequest(1, "iPhone 11", "christine");
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            validator.validateRequest("unknown", request);
        });
        Assertions.assertEquals("Unsupported action", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenIdIsZeroOnBooking() {
        BookingRequest request = new BookingRequest(0, "iPhone 11", "christine");
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            validator.validateRequest("book", request);
        });
        Assertions.assertEquals("mobile phone id is required", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenIdIsZeroOnReturns() {
        BookingRequest request = new BookingRequest(0, "iPhone 11", "christine");
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            validator.validateRequest("return", request);
        });
        Assertions.assertEquals("mobile phone id is required", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenDisplayNameIsNullOnBooking() {
        BookingRequest request = new BookingRequest(1, null, "christine");
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            validator.validateRequest("book", request);
        });
        Assertions.assertEquals("mobile phone name is required", ex.getMessage());
    }

    @Test
    public void shouldThrowExceptionWhenDisplayNameIsNullOnReturns() {
        BookingRequest request = new BookingRequest(1, null, "christine");
        IllegalArgumentException ex = Assertions.assertThrows(IllegalArgumentException.class, ()-> {
            validator.validateRequest("return", request);
        });
        Assertions.assertEquals("mobile phone name is required", ex.getMessage());
    }
}
