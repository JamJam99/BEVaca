package com.vacatime.controllers;

import java.util.List;

import com.vacatime.models.Payment;
import com.vacatime.services.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("payment")
public class PaymentController {

    private final PaymentService paymentService;

    public PaymentController(PaymentService paymentService) {
        this.paymentService = paymentService;
    }

    @GetMapping
    public List<Payment> findAllPayments() {
        return paymentService.findAll();
    }

    @GetMapping("{id}")
    public Payment findPaymentById(@PathVariable("id")Long id){
        return paymentService.findById(id);
    }
    
}
