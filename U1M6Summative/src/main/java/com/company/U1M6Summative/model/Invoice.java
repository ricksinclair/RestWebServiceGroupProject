package com.company.U1M6Summative.model;

import javax.validation.constraints.NotEmpty;
import java.math.BigDecimal;
import java.sql.Date;
import java.util.Objects;

public class Invoice {
    private int invoiceId;
    @NotEmpty(message = "Must provide customerId")
    private int customerId;
    @NotEmpty(message = "Must provide orderDate")
    private Date orderDate;
    @NotEmpty(message = "Must provide pickupDate")
    private Date pickupDate;
    @NotEmpty(message = "Must provide returnDate")
    private Date returnDate;
    @NotEmpty(message = "must provide late fee")
    private BigDecimal lateFee;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(int invoiceId) {
        this.invoiceId = invoiceId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getPickupDate() {
        return pickupDate;
    }

    public void setPickupDate(Date pickupDate) {
        this.pickupDate = pickupDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public BigDecimal getLateFee() {
        return lateFee;
    }

    public void setLateFee(BigDecimal lateFee) {
        this.lateFee = lateFee;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Invoice invoice = (Invoice) o;
        return invoiceId == invoice.invoiceId &&
                orderDate.equals(invoice.orderDate) &&
                pickupDate.equals(invoice.pickupDate) &&
                returnDate.equals(invoice.returnDate) &&
                lateFee.equals(invoice.lateFee);
    }

    @Override
    public int hashCode() {
        return Objects.hash(invoiceId, orderDate, pickupDate, returnDate, lateFee);
    }
}
