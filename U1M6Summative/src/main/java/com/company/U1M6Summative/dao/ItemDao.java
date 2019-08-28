package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;

import java.util.List;

public interface ItemDao {
    public Item addItem(Item item);

    public Item getItem(int itemId);

    public List<Item> getAllItems();

    public void updateItem(Item item);

    public void deleteItem(int itemId);
}
