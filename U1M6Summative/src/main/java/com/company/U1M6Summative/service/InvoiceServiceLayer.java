package com.company.U1M6Summative.service;
import com.company.U1M6Summative.dao.CustomerDao;
import com.company.U1M6Summative.dao.InvoiceDao;
import com.company.U1M6Summative.dao.InvoiceItemDao;
import com.company.U1M6Summative.dao.ItemDao;
import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.model.Invoice;
import com.company.U1M6Summative.model.InvoiceItem;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import java.util.ArrayList;
import java.util.List;
@Component
public class InvoiceServiceLayer {
    private InvoiceDao invoiceDao;
    private CustomerDao customerDao;
    private InvoiceItemDao invoiceItemDao;
    private ItemDao itemDao;

    @Autowired
    public InvoiceServiceLayer(InvoiceDao invoiceDao, CustomerDao customerDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.invoiceDao = invoiceDao;
        this.customerDao = customerDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel viewModel) {
        Invoice i = new Invoice();
        i.setCustomerId(viewModel.getCustomer().getCustomerId());
        i.setOrderDate(viewModel.getOrderDate());
        i.setPickupDate(viewModel.getPickupDate());
        i.setReturnDate(viewModel.getReturnDate());
        i.setLateFee(viewModel.getLateFee());
        i = invoiceDao.addInvoice(i);
        viewModel.setId(i.getInvoiceId());
        List<InvoiceItem> invoiceItems = viewModel.getInvoiceItems();
        invoiceItems.stream()
                .forEach(t ->
                {
                    t.setInvoiceId(viewModel.getId());
                    invoiceItemDao.addInvoiceItem(t);
                });
        invoiceItems = invoiceItemDao.getAllInvoiceItemsByInvoiceId(viewModel.getId());
        viewModel.setInvoiceItems(invoiceItems);
        return viewModel;
    }
    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        return buildInvoiceViewModel(invoice);
    }
    public List<InvoiceViewModel> findAllInvoices() {
        List<Invoice> invoiceList = invoiceDao.getAllInvoices();
        List<InvoiceViewModel> ivmList = new ArrayList<>();
        for (Invoice invoice : invoiceList) {
            InvoiceViewModel ivm = buildInvoiceViewModel(invoice);
            ivmList.add(ivm);
        }
        return ivmList;
    }

    @Transactional
    public void updateInvoice(InvoiceViewModel viewModel) {
        Invoice i = new Invoice();
        i.setInvoiceId(viewModel.getId());
        i.setCustomerId(viewModel.getCustomer().getCustomerId());
        i.setOrderDate(viewModel.getOrderDate());
        i.setPickupDate(viewModel.getPickupDate());
        i.setReturnDate(viewModel.getReturnDate());
        i.setLateFee(viewModel.getLateFee());
        invoiceDao.updateInvoice(i);
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItemsByInvoiceId(i.getInvoiceId());

    }
    @Transactional
    public void removeInvoice(int invoiceId) {
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItemsByInvoiceId(invoiceId);
        invoiceItemList.stream()
                .forEach(invoiceItem -> invoiceItemDao.deleteInvoiceItem(invoiceItem.getInvoiceItemId()));
        invoiceDao.deleteInvoice(invoiceId);
    }
    public Customer saveCustomer(Customer customer) {
        return customerDao.addCustomer(customer);
    }
    public Customer findCustomer(int id) {
        return customerDao.getCustomer(id);
    }
    public List<Customer> findAllCustomers() {
        return customerDao.getAllCustomers();
    }
    public void updateCustomer(Customer customer) {
        customerDao.updateCustomer(customer);
    }
    public void removeCustomer(int id) {
        customerDao.deleteCustomer(id);
    }
    // Helper Methods
    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
        Customer customer = customerDao.getCustomer(invoice.getCustomerId());
        List<InvoiceItem> invoiceItemList = invoiceItemDao.getAllInvoiceItemsByInvoiceId(invoice.getInvoiceId());
        InvoiceViewModel ivm = new InvoiceViewModel();
        ivm.setId(invoice.getInvoiceId());
        ivm.setCustomer(customer);
        ivm.setOrderDate(invoice.getOrderDate());
        ivm.setPickupDate(invoice.getPickupDate());
        ivm.setReturnDate(invoice.getReturnDate());
        ivm.setLateFee(invoice.getLateFee());
        ivm.setInvoiceItems(invoiceItemList);
        return ivm;
    }
}