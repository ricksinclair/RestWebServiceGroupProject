package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {
    public InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);

    public InvoiceItem getInvoiceItem(int invoiceItemId);

    public List<InvoiceItem> getAllInvoiceItems();

    public List<InvoiceItem> getAllInvoiceItemsByInvoiceId(int invoiceId);

    public void updateInvoiceItem(InvoiceItem invoiceItem);

    public void deleteInvoiceItem(int invoiceItemId);

    public void deleteInvoiceItemsByInvoiceId(int invoiceId);

    public void deleteInvoiceItemsByItemId(int itemId);
}
