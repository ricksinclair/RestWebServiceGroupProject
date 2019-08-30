package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.model.Customer;
import com.company.U1M6Summative.service.CustomerServiceLayer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
public class CustomerController {

    @Autowired
    CustomerServiceLayer customerServiceLayer;

    @RequestMapping(path = "/customer", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer addCustomer(@RequestBody Customer customer){


    }

    @RequestMapping(path = "/customer", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public <List>Customer getCustomers(){


    }

    @RequestMapping(path = "/customer/{customerId}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public Customer getCustomer(@PathVariable int customerId){


    }

    @RequestMapping(path = "/customer/{customerId}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public Customer getCustomer(@PathVariable int customerId){


    }

    @RequestMapping(path = "/customer", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.CREATED)
    public Customer getCustomer(@RequestBody Customer customer){


    }
}
