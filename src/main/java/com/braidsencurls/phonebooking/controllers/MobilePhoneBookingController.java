package com.braidsencurls.phonebooking.controllers;

import com.braidsencurls.phonebooking.dto.BookingRequest;
import com.braidsencurls.phonebooking.dto.BookingResponse;
import com.braidsencurls.phonebooking.service.MobilePhoneBookingService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/mobile-phones")
public class MobilePhoneBookingController {

    private MobilePhoneBookingService mobilePhoneBookingService;

    public MobilePhoneBookingController(MobilePhoneBookingService mobilePhoneBookingService) {
        this.mobilePhoneBookingService = mobilePhoneBookingService;
    }

    @PostMapping("/booking")
    public ResponseEntity<BookingResponse> book(@RequestBody BookingRequest bookingRequest) {
        mobilePhoneBookingService.book(bookingRequest);
        return ResponseEntity.ok().body(new BookingResponse("OK", "Successfully Booked"));
    }

    @PostMapping("/returns")
    public ResponseEntity<BookingResponse> returnBack(@RequestBody BookingRequest bookingRequest) {
        mobilePhoneBookingService.returnBack(bookingRequest);
        return ResponseEntity.ok().body(new BookingResponse("OK", "Successfully Returned"));
    }
}
