package com.company.U1M6Summative.dao;


import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
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
public class InvoiceItemDaoJdbcTemplateImplTest {

    @Autowired
    InvoiceItemDao invoiceItemDao;

    @Autowired
    CustomerDao customerDao;

    @Autowired
    InvoiceDao invoiceDao;

    @Autowired
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception {

        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItems();
        invoiceItemList.forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));

        List<Item> itemList = itemDao.getAllItems();
        itemList.forEach(item -> itemDao.deleteItem(item.getItemId()));

        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        invoiceList.forEach(invoice -> invoiceDao.deleteInvoice(invoice.getInvoiceId()));

        List<Customer> customerList = customerDao.getAllCustomers();
        customerList.forEach(customer -> customerDao.deleteCustomer(customer.getCustomerId()));

    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void addGetDeleteInvoiceItem() {
        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");

        item.setDailyRate(new BigDecimal("3.34"));

        item = itemDao.addItem(item);
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
        invoice.setLateFee(new BigDecimal("0.00"));
        invoiceDao.addInvoice(invoice);


        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setUnitRate(new BigDecimal("2.50"));
        invoiceItem.setDiscount(new BigDecimal("0.00"));
        invoiceItem.setQuantity(4);
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());
        assertEquals(invoiceItem, invoiceItem1);

        invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId());

        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);
    }

    @Test
    public void deleteInvoiceItemByItemId() {

        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");

        item.setDailyRate(new BigDecimal("3.34"));

        item = itemDao.addItem(item);
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
        invoice.setLateFee(new BigDecimal("0.00"));
        invoiceDao.addInvoice(invoice);


        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setUnitRate(new BigDecimal("2.50"));
        invoiceItem.setDiscount(new BigDecimal("0.00"));
        invoiceItem.setQuantity(4);
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());
        assertEquals(invoiceItem, invoiceItem1);

        invoiceItemDao.deleteInvoiceItemsByItemId(item.getItemId());

        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);
    }


    @Test
    public void deleteInvoiceItemsByInvoiceId(){

        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");

        item.setDailyRate(new BigDecimal("3.34"));

        item = itemDao.addItem(item);
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
        invoice.setLateFee(new BigDecimal("0.00"));
        invoiceDao.addInvoice(invoice);


        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setUnitRate(new BigDecimal("2.50"));
        invoiceItem.setDiscount(new BigDecimal("0.00"));
        invoiceItem.setQuantity(4);
        invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
        InvoiceItem invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());
        assertEquals(invoiceItem, invoiceItem1);

        invoiceItemDao.deleteInvoiceItemsByInvoiceId(invoice.getInvoiceId());

        invoiceItem1 = invoiceItemDao.getInvoiceItem(invoiceItem.getInvoiceItemId());

        assertNull(invoiceItem1);
    }

    @Test
    public void getAllInvoiceItems(){

        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");

        item.setDailyRate(new BigDecimal("3.34"));

        item = itemDao.addItem(item);
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
        invoice.setLateFee(new BigDecimal("0.00"));
        invoiceDao.addInvoice(invoice);


        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setItemId(item.getItemId());
        invoiceItem.setInvoiceId(invoice.getInvoiceId());
        invoiceItem.setUnitRate(new BigDecimal("2.50"));
        invoiceItem.setDiscount(new BigDecimal("0.00"));
        invoiceItem.setQuantity(4);
        invoiceItemDao.addInvoiceItem(invoiceItem);
        invoiceItemDao.addInvoiceItem(invoiceItem);
        List<InvoiceItem> invoiceItems = invoiceItemDao.getAllInvoiceItems();
        assertEquals(invoiceItems.size(), 2);
    }
}
