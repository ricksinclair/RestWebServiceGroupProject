package com.company.U1M6Summative.dao;

import com.company.U1M6Summative.model.Item;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class ItemDaoJdbcImplTest {
    @Autowired
    ItemDao itemDao;

    @Before
    public void setUp() throws Exception{

        List<Item>  itemList = itemDao.getAllItems();
        itemList.stream().forEach(item -> itemDao.deleteItem(item.getItemId()));
    }

    @After
    public void tearDown() throws Exception{

    }

    @Test
    public void addGetDeleteItem(){
        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");
        item.setDailyRate(new BigDecimal( "3.34"));
        item = itemDao.addItem(item);
        Item item2 = itemDao.getItem(item.getItemId());
        assertEquals(item, item2);
        itemDao.deleteItem(item.getItemId());
        item2 = itemDao.getItem(item.getItemId());
        assertNull(item2);
    }

    @Test
    public void updateItem(){
        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");
        item.setDailyRate(new BigDecimal( "3.34"));
        item = itemDao.addItem(item);

        item.setDailyRate(new BigDecimal("4.00"));

        itemDao.updateItem(item);

        Item item2 = itemDao.getItem(item.getItemId());
        assertEquals(item, item2);
    }

    @Test
    public void getAllItems(){
        Item item = new Item();
        item.setName("Free Willy");
        item.setDescription("A joyous tale of a boy and a killer whale.");
        item.setDailyRate(new BigDecimal( "3.34"));
        itemDao.addItem(item);
        item.setName("Lion King");
        item.setDescription("A joyous tale of a lion who will grow to be a king.");
        item.setDailyRate(new BigDecimal( "4.50"));
        itemDao.addItem(item);

        List<Item> itemList = itemDao.getAllItems();

        assertEquals(itemList.size(), 2);

    }

}
