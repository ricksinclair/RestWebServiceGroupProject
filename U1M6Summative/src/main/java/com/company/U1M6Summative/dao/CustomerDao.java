package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;

import java.util.List;

public interface CustomerDao {
    Customer addCustomer(Customer customer);

    Customer getCustomer(int customerId);

    List<Customer> getAllCustomers();

    void updateCustomer(Customer customer);

    void deleteCustomer(int customerId);
}
