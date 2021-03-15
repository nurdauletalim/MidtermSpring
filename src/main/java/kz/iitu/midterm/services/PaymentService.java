package kz.iitu.midterm.services;

import kz.iitu.midterm.entities.Payment;

public interface PaymentService {
    void phoneList();
    void createPayment(Payment payment);
}
