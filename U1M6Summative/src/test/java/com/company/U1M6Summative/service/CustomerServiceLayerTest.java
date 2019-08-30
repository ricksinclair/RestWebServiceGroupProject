package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class CustomerServiceLayerTest {

    //
    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;

    //For the CostumerViewModel
    CustomerServiceLayer CustomerServiceLayer;

    @Before
    public void setUp() throws Exception {

        setUpCustomerDaoMock();
        setUpInvoiceDaoMock();
        setUpInvoiceItemDaoMock();

        CustomerServiceLayer = new CustomerServiceLayer(customerDao,invoiceDao,invoiceItemDao);
    }

    @Test
    public void findCustomer() {
    }

    //Mock objects
    private void setUpCustomerDaoMock() {

        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);

        Customer customer = new Customer();
        customer.setCustomerId(12);
        customer.setFirstName("Jack");
        customer.setLastName("Black");
        customer.setEmail("allblack@gmail.com");
        customer.setCompany("Cognizant");
        customer.setPhone("718-963789");

        //Method to be called
        doReturn(customer).when(customerDao).getCustomer(12);
    }

    private void setUpInvoiceDaoMock(){

        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);

        Invoice invoice = new Invoice();
        invoice.setInvoiceId(1);
        invoice.setCustomerId(12);
        invoice.setOrderDate(Date.valueOf("2019-08-27"));
        invoice.setPickupDate(Date.valueOf("2019-08-27"));
        invoice.setReturnDate(Date.valueOf("2019-08-28"));
        invoice.setLateFee(new BigDecimal("0.00"));

        //Creating a second invoice for the same customer
        Invoice invoice2 = new Invoice();
        invoice2.setInvoiceId(2);
        invoice2.setCustomerId(12);
        invoice2.setOrderDate(Date.valueOf("2019-09-27"));
        invoice2.setPickupDate(Date.valueOf("2019-09-27"));
        invoice2.setReturnDate(Date.valueOf("2019-09-28"));
        invoice2.setLateFee(new BigDecimal("0.00"));

        //Creating a third invoice for the same customer
        Invoice invoice3 = new Invoice();
        invoice3.setInvoiceId(3);
        invoice3.setCustomerId(12);
        invoice3.setOrderDate(Date.valueOf("2019-10-27"));
        invoice3.setPickupDate(Date.valueOf("2019-10-27"));
        invoice3.setReturnDate(Date.valueOf("2019-10-28"));
        invoice3.setLateFee(new BigDecimal("0.00"));

        //Adding all the invoices to the list
        List<Invoice> invoiceList = new ArrayList<>();
        invoiceList.add(invoice);
        invoiceList.add(invoice2);
        invoiceList.add(invoice3);

        //Method to be called
        doReturn(invoiceList).when(invoiceDao).getInvoicesByCustomerId(12);
    }

    private void setUpInvoiceItemDaoMock(){

        invoiceItemDao = mock(InvoiceItemDaoJdbcTemplateImpl.class);
    }
}