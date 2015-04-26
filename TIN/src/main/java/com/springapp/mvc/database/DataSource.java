package com.springapp.mvc.database;

import com.springapp.mvc.grains.Basket;
import com.springapp.mvc.grains.Record;
import com.springapp.mvc.grains.User;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by PK on 4/6/2015.
 */
@Service
public interface DataSource
{
    public List<User> getUserByMail(String mail);
    public User saveUser(User user);

    public List<Basket> getBasketsByUser(User user);
    public Basket addBasket(Basket basket);
    public void deleteBasket(Basket basket);

    public Record getRecordById(long id);

    public List<Record> getRecordsByBasket(Basket basket);

    public Record saveRecord(Record record);

    public Iterable<Record> saveRecords(List<Record> records);

    public void deleteRecord(Record record);
}
