package com.vacatime.controllers;

import java.util.List;

import com.vacatime.dto.BookingReqDto;
import com.vacatime.dto.CustomerReqDto;
import com.vacatime.models.Booking;
import com.vacatime.models.Customer;
import com.vacatime.models.Package;
import com.vacatime.services.BookingService;
import com.vacatime.services.CustomerService;
import com.vacatime.services.PackageService;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("customers")
public class CustomerController {

    private final CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> findAllCustomers() {
        return customerService.findAll();
    }

    @GetMapping("{id}")
    public Customer findCustomerById(@PathVariable("id") Long id) {
        return customerService.findById(id);
    }

    @PostMapping
    public Customer registration(@Valid @RequestBody CustomerReqDto customer) {
        return customerService.saveCustomer(customer);

    }

}
