package com.braidsencurls.phonebooking.dto;

public class BookingRequest {
    private long mobilePhoneId;
    private String mobilePhoneName;
    private String borrower;

    public BookingRequest() {
    }

    public BookingRequest(long mobilePhoneId, String mobilePhoneName, String borrower) {
        this.mobilePhoneId = mobilePhoneId;
        this.mobilePhoneName = mobilePhoneName;
        this.borrower = borrower;
    }

    public long getMobilePhoneId() {
        return mobilePhoneId;
    }

    public void setMobilePhoneId(long mobilePhoneId) {
        this.mobilePhoneId = mobilePhoneId;
    }

    public String getMobilePhoneName() {
        return mobilePhoneName;
    }

    public void setMobilePhoneName(String mobilePhoneName) {
        this.mobilePhoneName = mobilePhoneName;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }
}
