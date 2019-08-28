package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;


@Repository

public class ItemDaoJdbcTemplateImpl implements ItemDao{

    // Prepared statement strings
    private static final String INSERT_ITEM_SQL = "insert into item (name, description, daily_rate) values (?, ?, ?)";

    private static final String SELECT_ITEM_SQL = "select * from item where item_id = ?";

    private static final String SELECT_ALL_ITEMS_SQL = "select * from item";

    private static final String DELETE_ITEM_SQL = "delete from item where item_id = ?";

    private static final String UPDATE_ITEM_SQL = "update item set name = ?, description = ?, daily_rate = ? where item_id = ?";


    //*********************************************************************************************************************
    private JdbcTemplate jdbcTemplate; // this is a dependency

    @Autowired
    public ItemDaoJdbcTemplateImpl(JdbcTemplate newJdbcTemplate){
        this.jdbcTemplate = newJdbcTemplate;
    }



    @Override
    public Item addItem(Item item) {

        jdbcTemplate.update(INSERT_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate()
        );

        int id = jdbcTemplate.queryForObject("select last_insert_id()",Integer.class);
        item.setItemId(id);
        return item;
    }

    @Override
    public Item getItem(int itemId) {

        try{
            return jdbcTemplate.queryForObject(SELECT_ITEM_SQL, this::mapRowToItem,itemId);
        }catch(EmptyResultDataAccessException e){
            return null;
        }
    }

    @Override
    public List<Item> getAllItems() {

        return jdbcTemplate.query(SELECT_ALL_ITEMS_SQL, this::mapRowToItem);
    }

    @Override
    public void updateItem(Item item) {

        jdbcTemplate.update(UPDATE_ITEM_SQL,
                item.getName(),
                item.getDescription(),
                item.getDailyRate(),
                item.getItemId()
        );
    }

    @Override
    public void deleteItem(int itemId) {
        jdbcTemplate.update(DELETE_ITEM_SQL,itemId);

    }

    //This method will be called by spring. Map row and object
    private Item mapRowToItem(ResultSet rs, int rowNum) throws SQLException {

        Item item = new Item();

        item.setItemId(rs.getInt("item_id"));
        item.setName(rs.getString("name"));
        item.setDescription(rs.getString("description"));
        item.setDailyRate(rs.getBigDecimal("daily_rate"));

        return item;
    }
}
