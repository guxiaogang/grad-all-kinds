package com.stu.ns.controller;

import com.stu.ns.domain.Account;
import com.stu.ns.domain.Address;
import com.stu.ns.domain.Customer;
import com.stu.ns.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/findAll", method = RequestMethod.GET)
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @RequestMapping(value = "/add", method = RequestMethod.GET)
    public Customer addCustomer() {
        Customer customer = new Customer();
        customer.setId(String.valueOf(new Date().getTime()));
        customer.setName(UUID.randomUUID().toString());
        customer.setBirthday(new Date());
        Address address = new Address();
        address.setPhone(String.valueOf(new Date().getTime()));
        address.setLocation("ChenDu");
        customer.addAddress(address);
        customerService.save(customer);
        return customer;
    }

    @RequestMapping(value = "/{customerId}/addAddress", method = RequestMethod.POST)
    public void addAddress(@PathVariable String customerId, @RequestBody Address address) {
        Customer customer = customerService.findById(customerId, Customer.class);
        if (customer != null) {
            customer.addAddress(address);
            customerService.save(customer);
        }
    }

    @RequestMapping(value = "/{customerId}/addAccount", method = RequestMethod.POST)
    public void addAccount(@PathVariable String customerId, @RequestBody Account account) {
        Customer customer = customerService.findById(customerId, Customer.class);
        if (customer != null) {
            customerService.saveObject(account);
            customer.addAccount(account);
            customerService.save(customer);
        }
    }
}
