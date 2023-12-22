package com.braidsencurls.phonebooking.service;

import com.braidsencurls.phonebooking.dto.BookingRequest;

public interface MobilePhoneBookingService {
    void book(BookingRequest bookingRequest);
    void returnBack(BookingRequest bookingRequest);
}
