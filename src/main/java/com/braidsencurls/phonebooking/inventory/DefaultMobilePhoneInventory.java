package com.braidsencurls.phonebooking.inventory;

import com.braidsencurls.phonebooking.mobilephone.MobilePhone;
import org.reflections.Reflections;
import org.springframework.stereotype.Component;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class DefaultMobilePhoneInventory extends MobilePhoneInventory {
    private static final Logger LOGGER = Logger.getLogger(DefaultMobilePhoneInventory.class.getName());

     public DefaultMobilePhoneInventory() {
         mobilePhones = new HashMap<>();
         discoverMobilePhones();
     }
     @Override
     protected void discoverMobilePhones() {
        // Get all subclasses of MobilePhone
        Set<Class<? extends MobilePhone>> phoneClasses = getSubclasses(MobilePhone.class);

        for (Class<? extends MobilePhone> phoneClass : phoneClasses) {
            // Check if the class is a subclass of MobilePhone
            if (MobilePhone.class.isAssignableFrom(phoneClass) && !phoneClass.equals(MobilePhone.class)) {
                try {
                    Constructor<?> constructor = phoneClass.getDeclaredConstructor();
                    MobilePhone mobilePhone = (MobilePhone) constructor.newInstance();
                    mobilePhones.put(mobilePhone.getId(), mobilePhone);
                } catch (NoSuchMethodException | IllegalAccessException | InstantiationException |
                         InvocationTargetException e) {
                   LOGGER.warning("Something went wrong: " + e);
                }
            }
        }
    }

    public static Set<Class<? extends MobilePhone>> getSubclasses(Class<MobilePhone> clazz) {
         String packageName = clazz.getPackageName();

        Reflections reflections = new Reflections(packageName);
        return reflections.getSubTypesOf(MobilePhone.class);

    }
}
