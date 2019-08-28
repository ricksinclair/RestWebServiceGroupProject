package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;

import java.util.List;

public interface CustomerDao {
    public Customer addCustomer(Customer customer);

    public Customer getCustomer(int customerId);

    public List<Customer> getAllCustomers();

    public void updateCustomer(Customer customer);

    public void deleteCustomer(int customerId);
}
