package com.braidsencurls.phonebooking.inventory;

import com.braidsencurls.phonebooking.mobilephone.MobilePhone;

import java.util.Map;

public abstract class MobilePhoneInventory {

    Map<Long, MobilePhone> mobilePhones;
    public Map<Long, MobilePhone> getMobilePhones() {
        return mobilePhones;
    }
    protected abstract void discoverMobilePhones();
}
