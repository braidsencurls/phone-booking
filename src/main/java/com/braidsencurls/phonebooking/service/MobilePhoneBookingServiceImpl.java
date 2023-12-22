package com.braidsencurls.phonebooking.service;

import com.braidsencurls.phonebooking.dto.BookingRequest;
import com.braidsencurls.phonebooking.validator.BookingRequestValidator;
import com.braidsencurls.phonebooking.errorhandling.UnknownMobilePhoneException;
import com.braidsencurls.phonebooking.inventory.MobilePhoneInventory;
import com.braidsencurls.phonebooking.mobilephone.MobilePhone;

import java.time.LocalDateTime;

public class MobilePhoneBookingServiceImpl implements MobilePhoneBookingService {

    private MobilePhoneInventory mobilePhoneInventory;
    private BookingRequestValidator bookingRequestValidator;

    public MobilePhoneBookingServiceImpl(MobilePhoneInventory mobilePhoneInventory,
                                         BookingRequestValidator bookingRequestValidator) {
        this.mobilePhoneInventory = mobilePhoneInventory;
        this.bookingRequestValidator = bookingRequestValidator;
    }

    @Override
    public void book(BookingRequest bookingRequest) {
        bookingRequestValidator.validateRequest("book", bookingRequest);
        getMobilePhone(bookingRequest.getMobilePhoneId())
                .book(bookingRequest.getBorrower(), LocalDateTime.now());
    }

    @Override
    public void returnBack(BookingRequest bookingRequest) {
        getMobilePhone(bookingRequest.getMobilePhoneId())
                .returnBack();
    }

    private MobilePhone getMobilePhone(long id) {
        MobilePhone mobilePhone = mobilePhoneInventory.getMobilePhones().get(id);
        if(mobilePhone == null) {
            throw new UnknownMobilePhoneException("Unknown mobile phone");
        }
        return mobilePhone;
    }
}
