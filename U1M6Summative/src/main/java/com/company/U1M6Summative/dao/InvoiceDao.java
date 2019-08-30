package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;

import java.util.List;

public interface InvoiceDao {
    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int invoiceId);

    List<Invoice> getAllInvoices();

    List<Invoice> getInvoicesByCustomerId(int customerId);

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int invoiceId);

    void deleteAllInvoicesByCustomer(int customerId);

}
