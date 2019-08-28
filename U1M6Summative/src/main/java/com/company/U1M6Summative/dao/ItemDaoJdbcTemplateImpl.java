package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public class ItemDaoJdbcTemplateImpl implements ItemDao {
    @Override
    public Item addItem(Item item) {
        return null;
    }

    @Override
    public Item getItem(int itemId) {
        return null;
    }

    @Override
    public List<Item> getAllItems() {
        return null;
    }

    @Override
    public void updateItem(Item item) {

    }

    @Override
    public void deleteItem(int itemId) {

    }
}
