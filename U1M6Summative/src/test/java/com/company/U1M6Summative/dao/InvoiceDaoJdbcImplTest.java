package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.sql.Date;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest

public class InvoiceDaoJdbcImplTest {

    @Autowired
    InvoiceDao invoiceDao;
    @Autowired
    CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));
        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addGetDeleteInvoice() {
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Quest");
        customer.setCompany("Cartoon Network");
        customer.setEmail("Johnny.Quest@cartoonnetwork.com");
        customer.setPhone("212-555-5555");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(Date.valueOf("2019-08-27"));
        invoice.setPickupDate(Date.valueOf("2019-08-27"));
        invoice.setReturnDate(Date.valueOf("2019-08-28"));
        invoice.setLateFee(new BigDecimal(0));


        invoice = invoiceDao.addInvoice(invoice);

        Invoice invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());

        assertEquals(invoice, invoice2);

        invoiceDao.deleteInvoice(invoice.getInvoiceId());
        invoice2 = invoiceDao.getInvoice(invoice.getInvoiceId());
        assertNull(invoice2);
    }

    @Test
    public void getAllInvoices() {
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Quest");
        customer.setCompany("Cartoon Network");
        customer.setEmail("Johnny.Quest@cartoonnetwork.com");
        customer.setPhone("212-555-5555");

        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(Date.valueOf("2019-08-27"));
        invoice.setPickupDate(Date.valueOf("2019-08-27"));
        invoice.setReturnDate(Date.valueOf("2019-08-28"));
        invoice.setLateFee(new BigDecimal(0));

        invoiceDao.addInvoice(invoice);
        invoice.setOrderDate(Date.valueOf("2019-08-22"));
        invoice.setPickupDate(Date.valueOf("2019-08-22"));
        invoice.setReturnDate(Date.valueOf("2019-08-23"));
        invoice.setLateFee(new BigDecimal(0));
        invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        assertEquals(invoiceList.size(), 2);

    }

    @Test
    public void getAllInvoicesByCustomerId() {
        Customer customer = new Customer();
        customer.setFirstName("Darth");
        customer.setLastName("Vader");
        customer.setCompany("DarkSide Industries");
        customer.setEmail("Darth@deathstar.net");
        customer.setPhone("212-555-5555");
        customer = customerDao.addCustomer(customer);

        Invoice invoice = new Invoice();
        invoice.setCustomerId(customer.getCustomerId());
        invoice.setOrderDate(Date.valueOf("2019-08-27"));
        invoice.setPickupDate(Date.valueOf("2019-08-27"));
        invoice.setReturnDate(Date.valueOf("2019-08-28"));
        invoice.setLateFee(new BigDecimal(0));

        Customer customer2 = new Customer();
        customer2.setFirstName("Johnny");
        customer2.setLastName("Quest");
        customer2.setCompany("Cartoon Network");
        customer2.setEmail("Johnny.Quest@cartoonnetwork.com");
        customer2.setPhone("212-555-5555");

        customer2 = customerDao.addCustomer(customer2);
        invoice.setCustomerId(customer2.getCustomerId());
        invoice.setOrderDate(Date.valueOf("2019-08-27"));
        invoice.setPickupDate(Date.valueOf("2019-08-27"));
        invoice.setReturnDate(Date.valueOf("2019-08-28"));
        invoice.setLateFee(new BigDecimal(0));

        invoiceDao.addInvoice(invoice);
        invoice.setCustomerId(customer2.getCustomerId());
        invoice.setOrderDate(Date.valueOf("2019-08-22"));
        invoice.setPickupDate(Date.valueOf("2019-08-22"));
        invoice.setReturnDate(Date.valueOf("2019-08-23"));
        invoice.setLateFee(new BigDecimal(0));
        invoiceDao.addInvoice(invoice);

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();

        assertEquals(invoiceList.size(), 2);

    }
}
