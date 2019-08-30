package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.service.InvoiceServiceLayer;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class InvoiceController {


    @Autowired
    InvoiceServiceLayer invoiceServiceLayer;

    @RequestMapping(path = "/invoice", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceViewModel addInvoice(@Valid @RequestBody InvoiceViewModel ivm) {

        return invoiceServiceLayer.saveInvoice(ivm);
    }

    @RequestMapping(path = "/invoice", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<InvoiceViewModel> getAllInvoices() {
        return invoiceServiceLayer.findAllInvoices();
    }

    @RequestMapping(path = "/invoice", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void updateInvoice(@Valid @RequestBody InvoiceViewModel ivm) {
        invoiceServiceLayer.updateInvoice(ivm);
    }

    @RequestMapping(path = "/invoice/{invoiceId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public InvoiceViewModel getInvoice(@PathVariable int invoiceId) {
        return invoiceServiceLayer.findInvoice(invoiceId);
    }

    @RequestMapping(path = "/invoice/{invoiceId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteInvoice(@PathVariable int invoiceId) {
        invoiceServiceLayer.removeInvoice(invoiceId);
    }


}
