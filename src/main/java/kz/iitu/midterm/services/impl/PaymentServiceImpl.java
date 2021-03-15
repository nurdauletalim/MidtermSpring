package kz.iitu.midterm.services.impl;

import kz.iitu.midterm.entities.Payment;
import kz.iitu.midterm.repository.PaymentRepository;
import kz.iitu.midterm.services.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentServiceImpl implements PaymentService {
    @Autowired
    private PaymentRepository paymentRepository;
    @Override
    public void phoneList() {
        System.out.println(paymentRepository.findAll());
    }

    @Override
    public void createPayment(Payment payment) {
        paymentRepository.save(payment);
    }
}
