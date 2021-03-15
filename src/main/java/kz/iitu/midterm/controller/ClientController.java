package kz.iitu.midterm.controller;

import kz.iitu.midterm.entities.Payment;
import kz.iitu.midterm.entities.room.Phone;
import kz.iitu.midterm.entities.room.PhoneType;
import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.services.PaymentService;
import kz.iitu.midterm.services.PhoneService;
import kz.iitu.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class ClientController {

    @Autowired
    private UserService userService;

    @Autowired
    private PhoneService phoneService;

    @Autowired
    private PaymentService paymentService;

    public User verificationUser(String login, String password) {
        return userService.verificationUser(login,password);
    }
    public void showAvailablePhone() {
        phoneService.availablePhones();
    }
    public void phonesByType(PhoneType phoneType){
        phoneService.phonesByType(phoneType);
    }
    public Phone findById(int id){
        return phoneService.findById(id);
    }

    public void addReservation(Payment payment){
        paymentService.createPayment(payment);
        phoneService.makePhoneIsnotAvailable(payment.getPhoneId());
    }
}
