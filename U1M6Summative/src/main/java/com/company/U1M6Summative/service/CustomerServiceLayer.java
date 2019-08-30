package com.company.U1M6Summative.service;

import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.viewmodel.CustomerViewModel;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class CustomerServiceLayer {

    private CustomerDao customerDao;
    private InvoiceDao invoiceDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    public CustomerServiceLayer(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao){

        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    public CustomerViewModel findCustomer(int id) {

        // Get the List of invoices for that customer first
        List<Invoice> invoicesPerCustomer = invoiceDao.getInvoicesByCustomerId(id);

        //List of InvoiceItem per invoice
        List <InvoiceItem[]> invoiceItemsPerCustomerInvoice = new ArrayList<>();


        invoicesPerCustomer.forEach(invoice -> {
            invoiceItemsPerCustomerInvoice.add((InvoiceItem[])invoiceItemDao.getAllInvoiceItemsByInvoiceId(invoice.getInvoiceId()).toArray());
        });

        //Map to store an Invoice object with theirs correspondent InvoiceItems
        Map<Invoice,Object[]> invoiceMap = new HashMap<>();

        //Filling the map
        for(int i = 0; i < invoicesPerCustomer.size(); i++){
            invoiceMap.put(invoicesPerCustomer.get(i), invoiceItemsPerCustomerInvoice.get(i));
        }

        /////////////////////////////////////////////////////////////////////////////////////////////////////////////
        //Building the CustomerViewModel
        Customer customer = customerDao.getCustomer(id);

        CustomerViewModel cvm = new CustomerViewModel();

        cvm.setId(customer.getCustomerId());
        cvm.setFirstName(customer.getFirstName());
        cvm.setLastName(customer.getLastName());
        cvm.setEmail(customer.getEmail());
        cvm.setCompany(customer.getCompany());
        cvm.setPhone(customer.getPhone());

        cvm.setInvoiceListMap(invoiceMap);

        return cvm;
    }

//    //Helper method
//    private CustomerViewModel buildCustomerViewModel(List<Invoice> invoiceList){
//
//    }

}
