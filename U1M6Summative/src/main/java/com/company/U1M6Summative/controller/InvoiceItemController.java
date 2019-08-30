package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.model.InvoiceItem;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class InvoiceItemController {

    @RequestMapping(path = "/invoiceitem", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceItem addInvoiceItem(@RequestBody InvoiceItem invoiceItem){

    }

    @RequestMapping(path = "/invoiceitem", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updateInvoiceItem(@RequestBody InvoiceItem invoiceItem){

    }

    @RequestMapping(path = "/invoiceitem", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.CREATED)
    public List<InvoiceItem> getInvoiceItems(){

    }

    @RequestMapping(path = "/invoiceitem/{invoiceItemId}", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public InvoiceItem getInvoiceItem(@PathVariable int invoiceItemId){

    }

    @RequestMapping(path = "/invoiceitem/{invoiceItemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void deleteInvoiceItem(@PathVariable int invoiceItemId){

    }


}
