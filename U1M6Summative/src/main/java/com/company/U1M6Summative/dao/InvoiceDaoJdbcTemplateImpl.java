package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository
public class InvoiceDaoJdbcTemplateImpl implements InvoiceDao {

    // Prepared statement strings
    private static final String INSERT_INVOICE_SQL = "insert into invoice (customer_id, order_date, pickup_date, return_date, late_fee) values (?, ?, ?, ?, ?)";

    private static final String SELECT_INVOICE_SQL = "select * from invoice where invoice_id = ?";

    private static final String SELECT_ALL_INVOICES_SQL = "select * from invoice";

    private static final String DELETE_INVOICE_SQL = "delete from invoice where invoice_id = ?";

    private static final String UPDATE_INVOICE_SQL = "update invoice set customer_id = ?, order_date = ?, pickup_date = ?, return_date = ?, late_fee = ? where invoice_id = ?";

    private static final String SELECT_INVOICES_BY_CUSTOMER_SQL = "select * from invoice where customer_id = ?";

    //*********************************************************************************************************************
    private JdbcTemplate jdbcTemplate; // this is a dependency

    @Autowired
    public InvoiceDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }

    @Override
    @Transactional
    public Invoice addInvoice(Invoice invoice) {
        jdbcTemplate.update(INSERT_INVOICE_SQL,
                invoice.getCustomerId(),
                invoice.getOrderDate(),
                invoice.getPickupDate(),
                invoice.getReturnDate(),
                invoice.getLateFee()
                );

        int id = jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        invoice.setInvoiceId(id);
        return invoice;
    }

    @Override
    public Invoice getInvoice(int invoiceId) {

        try{
            return jdbcTemplate.queryForObject(SELECT_INVOICE_SQL, this::mapRowToInvoice,invoiceId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Invoice> getAllInvoices() {

        return jdbcTemplate.query(SELECT_ALL_INVOICES_SQL, this::mapRowToInvoice);
    }

    @Override
    public List<Invoice> getInvoicesByCustomerId(int customerId) {

        return jdbcTemplate.query(SELECT_INVOICES_BY_CUSTOMER_SQL, this::mapRowToInvoice,customerId);
    }

    @Override
    public void updateInvoice(Invoice invoice) {

        jdbcTemplate.update(UPDATE_INVOICE_SQL,

                invoice.getCustomerId(),
                invoice.getOrderDate(),
                invoice.getPickupDate(),
                invoice.getReturnDate(),
                invoice.getLateFee(),
                invoice.getInvoiceId()
                );

    }

    @Override
    public void deleteInvoice(int invoiceId) {

        jdbcTemplate.update(DELETE_INVOICE_SQL, invoiceId);

    }
    //*************************************************************************************
    private Invoice mapRowToInvoice(ResultSet rs, int rowNum) throws SQLException{

        Invoice invoice = new Invoice();

        invoice.setInvoiceId(rs.getInt("invoice_id"));
        invoice.setCustomerId(rs.getInt("customer_id"));
        invoice.setOrderDate(rs.getDate("order_date"));
        invoice.setPickupDate(rs.getDate("pickup_date"));
        invoice.setReturnDate(rs.getDate("return_date"));
        invoice.setLateFee(rs.getBigDecimal("late_fee"));

        return invoice;
    }

    @Override
    public void deleteAllInvoicesByCustomer(int customerId) {

    }
}
