package com.braidsencurls.phonebooking.configuration;

import com.braidsencurls.phonebooking.validator.BookingRequestValidator;
import com.braidsencurls.phonebooking.inventory.DefaultMobilePhoneInventory;
import com.braidsencurls.phonebooking.inventory.MobilePhoneInventory;
import com.braidsencurls.phonebooking.service.MobilePhoneBookingService;
import com.braidsencurls.phonebooking.service.MobilePhoneBookingServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.braidsencurls.testsphonebooking")
public class ApplicationConfiguration {

    @Bean
    public MobilePhoneInventory mobilePhoneInventory() {
        return new DefaultMobilePhoneInventory();
    }

    @Bean
    public BookingRequestValidator bookingRequestValidator() {
        return new BookingRequestValidator();
    }

    @Bean
    public MobilePhoneBookingService bookingService() {
        return new MobilePhoneBookingServiceImpl(mobilePhoneInventory(), bookingRequestValidator());
    }


}
