package kz.iitu.midterm.controller;

import kz.iitu.midterm.entities.room.Phone;
import kz.iitu.midterm.entities.user.User;
import kz.iitu.midterm.services.PaymentService;
import kz.iitu.midterm.services.PhoneService;
import kz.iitu.midterm.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AdminController {

    @Autowired
    private UserService userService;
    @Autowired
    private PhoneService phoneService;
    @Autowired
    private PaymentService paymentService;

    public void createUser(User user){
        userService.createUser(user);
    }

    public void deleteUser(int id){
        userService.delelteUser(id);
    }

    public void findById(int id) {
        userService.findById(id);
    }

    public void createPhone(Phone phone) {
        phoneService.createPhone(phone);
    }

    public void deletePhone(int id) {
        phoneService.deletePhone(id);
    }

    public void showAvailablePhone() {
        System.out.println(phoneService.availablePhones());
    }

    public void paymentList() {
        paymentService.phoneList();
    }
}
