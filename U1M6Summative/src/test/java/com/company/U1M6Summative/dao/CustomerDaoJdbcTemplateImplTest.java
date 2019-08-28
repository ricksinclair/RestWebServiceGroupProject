package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Customer;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class CustomerDaoJdbcTemplateImplTest {
    @Autowired
    CustomerDao customerDao;

    @Before
    public void setUp() throws Exception {

        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.stream().forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addGetDeleteCustomer() {
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Quest");
        customer.setCompany("Cartoon Network");
        customer.setEmail("Johnny.Quest@cartoonnetwork.com");
        customer.setPhone("212-555-5555");

        customer = customerDao.addCustomer(customer);

        Customer customer2 = customerDao.getCustomer(customer.getCustomerId());
        assertEquals(customer, customer2);

        List<Customer> customerList = customerDao.getAllCustomers();

        assertEquals(customerList.size(), 1);

        customerDao.deleteCustomer(customer.getCustomerId());

        customer2 = customerDao.getCustomer(customer.getCustomerId());
        assertNull(customer2);
    }

    @Test
    public void getAllCustomers() {
        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Quest");
        customer.setCompany("Cartoon Network");
        customer.setEmail("Johnny.Quest@cartoonnetwork.com");
        customer.setPhone("212-555-5555");

        customerDao.addCustomer(customer);

        List<Customer> customerList = customerDao.getAllCustomers();

        assertEquals(customerList.size(), 1);
    }


    @Test
    public void updateCustomer() {

        Customer customer = new Customer();
        customer.setFirstName("Johnny");
        customer.setLastName("Quest");
        customer.setCompany("Cartoon Network");
        customer.setEmail("Johnny.Quest@cartoonnetwork.com");
        customer.setPhone("212-555-5555");

        customer = customerDao.addCustomer(customer);

        customer.setFirstName("Hadji");
        customer.setLastName("Quest");
        customer.setCompany("Cartoon Network");
        customer.setEmail("Hadji.Quest@cartoonnetwork.com");
        customer.setPhone("212-555-5555");

        customerDao.updateCustomer(customer);

        Customer customer2 = customerDao.getCustomer(customer.getCustomerId());
        assertEquals(customer, customer2);

    }
}
