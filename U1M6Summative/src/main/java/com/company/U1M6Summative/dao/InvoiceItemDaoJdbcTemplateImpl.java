package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class InvoiceItemDaoJdbcTemplateImpl implements InvoiceItemDao {
    @Override
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem) {
        return null;
    }

    @Override
    public InvoiceItem getInvoiceItem(int invoiceItemId) {
        return null;
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItems() {
        return null;
    }

    @Override
    public List<InvoiceItem> getAllInvoiceItemsByInvoiceId(int invoiceId) {
        return null;
    }

    @Override
    public void updateInvoiceItem(InvoiceItem invoiceItem) {

    }

    @Override
    public void deleteInvoiceItem(int invoiceItemId) {

    }

    @Override
    public void deleteInvoiceItemsByInvoiceId(int invoiceId) {

    }

    @Override
    public void deleteInvoiceItemsByItemId(int itemId) {

    }


}
