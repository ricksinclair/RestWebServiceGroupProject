package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.*;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;
import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.mockito.Mockito.*;

public class InvoiceServiceLayerTest {
    InvoiceServiceLayer service;
    InvoiceDao invoiceDao;
    CustomerDao customerDao;
    InvoiceItemDao invoiceItemDao;
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception {
        setUpInvoiceDaoMock();
        setUpCustomerDaoMock();

        service = new InvoiceServiceLayer(invoiceDao, customerDao, invoiceItemDao, itemDao);
    }

    @Test
    public void saveInvoice() {
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setOrderDate(Date.valueOf( LocalDate.of(2018, 10, 11)));
        ivm.setPickupDate(Date.valueOf(LocalDate.of(2018, 10, 12)));
        ivm.setReturnDate(Date.valueOf(LocalDate.of(2018, 10, 15)));
        ivm.setLateFee(new BigDecimal("0"));
        Customer customer = new Customer();
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("jd@gmail.com");
        customer.setCompany("TheRockStar");
        customer.setPhone("347567891");
        customer = service.saveCustomer(customer);
        ivm.setCustomer(customer);
        InvoiceItem invoiceItem = new InvoiceItem();
        invoiceItem.setQuantity(10);
        invoiceItem.setUnitRate(new BigDecimal("50.00"));
        invoiceItem.setDiscount(new BigDecimal("2.00"));
        List<InvoiceItem> iList = new ArrayList<>();
        iList.add(invoiceItem);
        ivm.setInvoiceItems(iList);
        Item item = new Item();
        item.setName("Titanic");
        item.setDescription("DVD");
        item.setDailyRate(new BigDecimal("10.00"));
        List<Item> itemList = new ArrayList<>();
        itemList.add(item);
        ivm.setItems(itemList);
        ivm = service.saveInvoice(ivm);
        InvoiceViewModel fromService = service.findInvoice(ivm.getId());
        assertEquals(ivm, fromService);
    }

    @Test
    public void findInvoice() {
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(12);
        invoice.setCustomerId(40);
        invoice.setOrderDate(Date.valueOf(LocalDate.of(2018, 10, 11)));
        invoice.setPickupDate(Date.valueOf(LocalDate.of(2018, 10, 12)));
        invoice.setReturnDate(Date.valueOf(LocalDate.of(2018, 10, 15)));
        invoice.setLateFee(new BigDecimal("0"));
        InvoiceViewModel ivm = service.findInvoice(12);
        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(ivm.getCustomer().getCustomerId());
        invoice1.setOrderDate(ivm.getOrderDate());
        invoice1.setPickupDate(ivm.getPickupDate());
        invoice1.setReturnDate(ivm.getReturnDate());
        invoice1.setLateFee(ivm.getLateFee());
        invoice1.setInvoiceId(ivm.getId());
        assertEquals(invoice, invoice1);
    }

    @Test
    public void findAllInvoices() {
        List<InvoiceViewModel> fromService = service.findAllInvoices();
        assertEquals(1, fromService.size());
    }

    @Test
    public void removeInvoice() {
        service.removeInvoice(12);
        InvoiceViewModel ivm = service.findInvoice(12);
        assertNull(ivm);
    }

    private void setUpInvoiceDaoMock() {
        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
        Invoice invoice = new Invoice();
        invoice.setInvoiceId(12);
        invoice.setCustomerId(40);
        invoice.setOrderDate(Date.valueOf(LocalDate.of(2018, 10, 11)));
        invoice.setPickupDate(Date.valueOf(LocalDate.of(2018, 10, 12)));
        invoice.setReturnDate(Date.valueOf(LocalDate.of(2018, 10, 15)));
        invoice.setLateFee(new BigDecimal("0"));
        Invoice invoice1 = new Invoice();
        invoice1.setCustomerId(40);
        invoice1.setOrderDate(Date.valueOf(LocalDate.of(2018, 10, 11)));
        invoice1.setPickupDate(Date.valueOf(LocalDate.of(2018, 10, 12)));
        invoice1.setReturnDate(Date.valueOf(LocalDate.of(2018, 10, 15)));
        invoice1.setLateFee(new BigDecimal("0"));
        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
        List<Invoice> iList = new ArrayList<>();
        iList.add(invoice);
        doReturn(iList).when(invoiceDao).getAllInvoices();
        doReturn(invoice).when(invoiceDao).getInvoice(1);
        Invoice invoiceUpdate = new Invoice();
        invoiceUpdate.setInvoiceId(12);
        invoiceUpdate.setCustomerId(40);
        invoiceUpdate.setOrderDate(Date.valueOf(LocalDate.of(2018, 10, 11)));
        invoiceUpdate.setPickupDate(Date.valueOf(LocalDate.of(2018, 10, 12)));
        invoiceUpdate.setReturnDate(Date.valueOf(LocalDate.of(2018, 10, 15)));
        invoiceUpdate.setLateFee(new BigDecimal("0"));
        doNothing().when(invoiceDao).updateInvoice(invoiceUpdate);
        doReturn(invoiceUpdate).when(invoiceDao).getInvoice(2);
        Invoice invoiceDelete = new Invoice();
        invoiceDelete.setInvoiceId(11);
        invoiceDelete.setCustomerId(50);
        invoiceDelete.setOrderDate(Date.valueOf(LocalDate.of(2018, 1, 9)));
        invoiceDelete.setPickupDate(Date.valueOf(LocalDate.of(2018, 1, 12)));
        invoiceDelete.setReturnDate(Date.valueOf(LocalDate.of(2018, 1, 15)));
        invoiceDelete.setLateFee(new BigDecimal("0"));
        doNothing().when(invoiceDao).deleteInvoice(3);
        doReturn(null).when(invoiceDao).getInvoice(3);
    }

    private void setUpCustomerDaoMock() {
        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
        Customer customer = new Customer();
        customer.setCustomerId(19);
        customer.setFirstName("John");
        customer.setLastName("Doe");
        customer.setEmail("jd@gmail.com");
        customer.setCompany("TheRockStar");
        customer.setPhone("347567891");
        Customer customer1 = new Customer();
        customer1.setFirstName("John");
        customer1.setLastName("Doe");
        customer1.setEmail("jd@gmail.com");
        customer1.setCompany("TheRockStar");
        customer1.setPhone("347567891");
        doReturn(customer).when(customerDao).addCustomer(customer1);
        List<Customer> cList = new ArrayList<>();
        cList.add(customer);
        doReturn(cList).when(customerDao).getAllCustomers();
        doReturn(customer).when(customerDao).getCustomer(19);
        Customer customerUpdate = new Customer();
        customerUpdate.setCustomerId(19);
        customerUpdate.setFirstName("John");
        customerUpdate.setLastName("Doe");
        customerUpdate.setEmail("jd@gmail.com");
        customerUpdate.setCompany("TheRockStar");
        customerUpdate.setPhone("347567891");
        doNothing().when(customerDao).updateCustomer(customerUpdate);
        doReturn(customerUpdate).when(customerDao).getCustomer(1);
        Customer customerDelete = new Customer();
        customerDelete.setCustomerId(19);
        customerDelete.setFirstName("John");
        customerDelete.setLastName("Doe");
        customerDelete.setEmail("jd@gmail.com");
        customerDelete.setCompany("TheRockStar");
        customerDelete.setPhone("347567891");
        doNothing().when(customerDao).deleteCustomer(3);
        doReturn(null).when(customerDao).getCustomer(3);
    }
}

