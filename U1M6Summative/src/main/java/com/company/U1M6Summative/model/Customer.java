package com.company.U1M6Summative.model;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Objects;

public class Customer {
    private int customerId;
    @NotEmpty(message = "Must provide customer firstName")
    @Size(max = 50, message = "firstName maximum of 50 characters")
    private String firstName;
    @NotEmpty(message = "Must provide customer lastName")
    @Size(max = 50, message = "lastName maximum of 50 characters")
    private String lastName;
    @NotEmpty(message = "Must provide customer email")
    @Size(max = 50, message = "firstName maximum of 75 characters")
    private String email;
    @NotEmpty(message = "Must provide customer company")
    @Size(max = 50, message = "company maximum of 50 characters")
    private String company;
    @NotEmpty(message = "Must provide customer phone")
    @Size(max = 50, message = "phone maximum of 50 characters")
    private String phone;

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerId == customer.customerId &&
                firstName.equals(customer.firstName) &&
                lastName.equals(customer.lastName) &&
                email.equals(customer.email) &&
                company.equals(customer.company) &&
                phone.equals(customer.phone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, firstName, lastName, email, company, phone);
    }
}
