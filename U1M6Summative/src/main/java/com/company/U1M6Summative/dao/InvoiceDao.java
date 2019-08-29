package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;

import java.util.List;

public interface InvoiceDao {
    public Invoice addInvoice(Invoice invoice);

    public Invoice getInvoice(int invoiceId);

    public List<Invoice> getAllInvoices();

    public List<Invoice> getInvoicesByCustomerId(int customerId);

    public void updateInvoice(Invoice invoice);

    public void deleteInvoice(int invoiceId);

    public void deleteAllInvoicesByCustomer(int customerId);

}
