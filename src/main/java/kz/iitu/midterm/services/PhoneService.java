package kz.iitu.midterm.services;

import kz.iitu.midterm.entities.room.Phone;
import kz.iitu.midterm.entities.room.PhoneType;

import java.util.List;

public interface PhoneService {
    void createPhone(Phone phone);
    void deletePhone(int id);
    List<Phone> availablePhones();
    void phonesByType(PhoneType phoneType);
    Phone findById(int id);
    void makePhoneIsnotAvailable(int id);
}
