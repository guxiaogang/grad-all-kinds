package com.stu.ns.service;

import com.stu.ns.domain.Customer;

import java.util.List;

public interface CustomerService extends BaseService<Customer, String> {

    List<Customer> findWithoutAccounts();

}
