package com.braidsencurls.phonebooking.service;

import com.braidsencurls.phonebooking.dto.BookingRequest;
import com.braidsencurls.phonebooking.errorhandling.MobilePhoneAvailabilityException;
import com.braidsencurls.phonebooking.inventory.DefaultMobilePhoneInventory;
import com.braidsencurls.phonebooking.inventory.MobilePhoneInventory;
import com.braidsencurls.phonebooking.validator.BookingRequestValidator;
import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MobilePhoneBookingServiceTest {

    private static MobilePhoneBookingService service;

    @BeforeAll
    public static void setup() {
        MobilePhoneInventory inventory = new DefaultMobilePhoneInventory();
        BookingRequestValidator validator = new BookingRequestValidator();
        service = new MobilePhoneBookingServiceImpl(inventory, validator);
    }

    @Test
    @Order(1)
    public void shouldSuccessfullyBookWhenAvailablePhone() {
        BookingRequest bookingRequest = new BookingRequest(1, "Apple iPhone 11", "Christine");
        service.book(bookingRequest);
    }

    @Test
    @Order(2)
    public void shouldThrowAnExceptionWhenTryingToBookUnAvailablePhone() {
        BookingRequest bookingRequest = new BookingRequest(1, "Apple iPhone 11", "Christine");
        MobilePhoneAvailabilityException ex = Assertions.assertThrows(MobilePhoneAvailabilityException.class, () -> {
            service.book(bookingRequest);
        });
        Assertions.assertEquals("Apple iPhone 11 is unavailable for now", ex.getMessage());
    }

    @Test
    @Order(3)
    public void shouldSuccessfullyReturnPhone() {
        BookingRequest bookingRequest = new BookingRequest(1, "Apple iPhone 11", "Christine");
        service.returnBack(bookingRequest);
    }

    @Test
    @Order(4)
    public void shouldThrowAnExceptionWhenTryingToReturnOnHandPhone() {
        BookingRequest bookingRequest = new BookingRequest(1, "Apple iPhone 11", "Christine");
        MobilePhoneAvailabilityException ex = Assertions.assertThrows(MobilePhoneAvailabilityException.class, () -> {
            service.returnBack(bookingRequest);
        });
        Assertions.assertEquals("Apple iPhone 11 is currently on-hand", ex.getMessage());
    }
}
