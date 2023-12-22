package com.braidsencurls.phonebooking.controller;

import com.braidsencurls.phonebooking.controllers.MobilePhoneBookingController;
import com.braidsencurls.phonebooking.dto.BookingRequest;
import com.braidsencurls.phonebooking.service.MobilePhoneBookingService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(value = MobilePhoneBookingController.class)
public class MobilePhoneBookingControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MobilePhoneBookingService service;

    private ObjectMapper objectMapper = new ObjectMapper();

    @Test
    public void shouldReturn200OnBooking() throws Exception {
        BookingRequest bookingRequest = new BookingRequest(1, "Apple iPhone 11", "christine");
        mockMvc.perform(MockMvcRequestBuilders.post("/mobile-phones/booking")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingRequest)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.status").value("OK"));
    }

    @Test
    public void shouldReturn200OnReturns() throws Exception {
        BookingRequest bookingRequest = new BookingRequest(1, "Apple iPhone 11", "christine");

        mockMvc.perform(MockMvcRequestBuilders.post("/mobile-phones/returns")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(bookingRequest)))
                .andExpect(status().is(200))
                .andExpect(jsonPath("$.status").value("OK"));
    }
}
