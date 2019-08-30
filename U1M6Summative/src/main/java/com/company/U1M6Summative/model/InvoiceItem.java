package com.company.U1M6Summative.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.util.Objects;

public class InvoiceItem {
    private int invoiceItemId;
    @NotEmpty(message = "Must provide invoiceId")
    private int invoiceId;
    @NotEmpty(message = "Must provide itemId")
    private int itemId;
    @NotEmpty(message = "Must provide quantity")
    @Size(min = 1, message = "You must have a quantity of at least 1")
    private int quantity;
    @NotEmpty(message = "Must provide unitRate")
    private BigDecimal unitRate;
    @NotEmpty(message = "Must provide discount value")
    private BigDecimal discount;

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public int getInvoiceItemId() {
        return invoiceItemId;
    }

    public void setInvoiceItemId(int invoiceItemId) {
        this.invoiceItemId = invoiceItemId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getUnitRate() {
        return unitRate;
    }

    public void setUnitRate(BigDecimal unitRate) {
        this.unitRate = unitRate;
    }

    public BigDecimal getDiscount() {
        return discount;
    }

    public void setDiscount(BigDecimal discount) {
        this.discount = discount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceItem that = (InvoiceItem) o;
        return invoiceItemId == that.invoiceItemId &&
                itemId == that.itemId &&
                quantity == that.quantity &&
                unitRate.equals(that.unitRate) &&
                discount.equals(that.discount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceItemId, itemId, quantity, unitRate, discount);
    }
}
