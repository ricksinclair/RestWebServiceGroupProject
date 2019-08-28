package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {
    @Override
    public Invoice addInvoice(Invoice invoice) {
        return null;
    }

    @Override
    public Invoice getInvoice(int invoiceId) {
        return null;
    }

    @Override
    public List<Invoice> getAllInvoices() {
        return null;
    }

    @Override
    public List<Invoice> getInvoicesByCustomerId(int customerId) {
        return null;
    }

    @Override
    public void updateInvoice(Invoice invoice) {

    }

    @Override
    public void deleteInvoice(int invoiceId) {

    }
}
