package kz.iitu.midterm.services.impl;

import kz.iitu.midterm.entities.room.Phone;
import kz.iitu.midterm.entities.room.PhoneType;
import kz.iitu.midterm.repository.PhoneRepository;
import kz.iitu.midterm.services.PhoneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PhoneServiceImpl implements PhoneService {
    @Autowired
    private PhoneRepository phoneRepository;

    @Override
    public void makePhoneIsnotAvailable(int id) {
        Phone phone = phoneRepository.getById(id);
        phone.setAvailable(false);
        phoneRepository.save(phone);
    }

    @Override
    public void createPhone(Phone phone) {
        phoneRepository.save(phone);
    }

    @Override
    public void deletePhone(int id) {
        phoneRepository.deleteById(id);
    }

    @Override
    public List<Phone> availablePhones() {
        return phoneRepository.findAll();
    }

    @Override
    public Phone findById(int id) {
         Phone phone = phoneRepository.getById(id);
         return phone;
    }

    @Override
    public void phonesByType(PhoneType phoneType) {
        List<Phone> phoneList = phoneRepository.findByType(phoneType);
        System.out.println(phoneType + " phone list: ");
        for (Phone phone : phoneList) {
            System.out.println(phone);
        }
    }
}
