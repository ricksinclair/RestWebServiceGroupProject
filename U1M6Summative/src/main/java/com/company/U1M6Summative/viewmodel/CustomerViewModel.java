package com.company.U1M6Summative.viewmodel;

import com.company.U1M6Summative.model.Invoice;


import java.util.*;

public class CustomerViewModel {

    private int id;
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String phone;

    private Map<Invoice,Object[]> invoiceListMap = new HashMap<>();

   //Getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Map<Invoice, Object[]> getInvoiceListMap() {
        return invoiceListMap;
    }

    public void setInvoiceListMap(Map<Invoice, Object[]> invoiceListMap) {
        this.invoiceListMap = invoiceListMap;
    }

    //hashcode and equals

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerViewModel that = (CustomerViewModel) o;
        return getId() == that.getId() &&
                getFirstName().equals(that.getFirstName()) &&
                getLastName().equals(that.getLastName()) &&
                getEmail().equals(that.getEmail()) &&
                getCompany().equals(that.getCompany()) &&
                getPhone().equals(that.getPhone()) &&
                getInvoiceListMap().equals(that.getInvoiceListMap());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFirstName(), getLastName(), getEmail(), getCompany(), getPhone(), getInvoiceListMap());
    }
}
