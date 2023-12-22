package com.braidsencurls.phonebooking.mobilephone;

import com.braidsencurls.phonebooking.errorhandling.MobilePhoneAvailabilityException;

import java.time.LocalDateTime;

public class MobilePhone {
    private long id;
    private String displayName;
    private boolean isAvailable;
    private LocalDateTime bookedOn;
    private String bookedBy;

    public synchronized void book(String bookedBy, LocalDateTime bookedOn) {
        if(!isAvailable()) {
            throw new MobilePhoneAvailabilityException(this.displayName + " is unavailable for now");
        }

        setBookedBy(bookedBy);
        setBookedOn(bookedOn);
        setAvailable(false);
    }

    public synchronized void returnBack() {
        if(isAvailable()) {
            throw new MobilePhoneAvailabilityException(this.displayName + " is currently on-hand");
        }
        setAvailable(true);
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public LocalDateTime getBookedOn() {
        return bookedOn;
    }

    public void setBookedOn(LocalDateTime bookedOn) {
        this.bookedOn = bookedOn;
    }

    public String getBookedBy() {
        return bookedBy;
    }

    public void setBookedBy(String bookedBy) {
        this.bookedBy = bookedBy;
    }
}
