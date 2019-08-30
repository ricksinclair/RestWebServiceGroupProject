package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.InvoiceItem;

import java.util.List;

public interface InvoiceItemDao {
    InvoiceItem addInvoiceItem(InvoiceItem invoiceItem);

    InvoiceItem getInvoiceItem(int invoiceItemId);

    List<InvoiceItem> getAllInvoiceItems();

    List<InvoiceItem> getAllInvoiceItemsByInvoiceId(int invoiceId);

    void updateInvoiceItem(InvoiceItem invoiceItem);

    void deleteInvoiceItem(int invoiceItemId);

    void deleteInvoiceItemsByInvoiceId(int invoiceId);

    void deleteInvoiceItemsByItemId(int itemId);
}
