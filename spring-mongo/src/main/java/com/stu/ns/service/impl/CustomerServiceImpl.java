package com.stu.ns.service.impl;

import com.stu.ns.domain.Customer;
import com.stu.ns.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("customerService")
public class CustomerServiceImpl extends BaseServiceImpl<Customer, String> implements CustomerService {

    @Override
    public List<Customer> findWithoutAccounts() {
        return null;
    }
}
