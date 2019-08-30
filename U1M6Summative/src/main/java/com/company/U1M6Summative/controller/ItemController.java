package com.company.U1M6Summative.controller;


import com.company.U1M6Summative.model.Item;
import com.company.U1M6Summative.viewmodel.InvoiceViewModel;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ItemController {
    @RequestMapping(path = "/item", method = RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Item addItem( @RequestBody Item item) {

    }

    @RequestMapping(path = "/item", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public List<Item> getItems() {

    }


    @RequestMapping(path = "/item", method = RequestMethod.PUT)
    @ResponseStatus(value = HttpStatus.CREATED)
    public void updateItem( @RequestBody Item item) {

    }

    @RequestMapping(path = "/item/{itemId}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.ACCEPTED)
    public void deleteItem( @PathVariable int itemId) {

    }

    @RequestMapping(path = "/item/{itemId}", method = RequestMethod.GET)
    @ResponseStatus(value = HttpStatus.OK)
    public void getItem( @PathVariable int itemId) {

    }




}
