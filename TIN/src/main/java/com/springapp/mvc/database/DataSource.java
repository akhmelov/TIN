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
    public User getUser(long id);
    public User saveUser(User user);

    public List<Basket> getBaskets(long idUser);
    public List<Basket> getBasketsByUser(User user);
    public Basket addBasket(Basket basket);
    public void deleteBasket(Basket basket);
    public void deleteBasket(long idUser, long idBasket);

    public Record getRecordById(long id);
    public Record getRecord(long idUser, long idBasket, long idRecord);

    public List<Record> getRecordsByBasket(Basket basket);
    public List<Record> getRecordsByBasket(long idBasket);
    public List<Record> getRecordsByBasket(long idUser, long idBasket);

    public Record saveRecord(Record record);
    public Record saveRecord(long idUser, long idBasket, Record record);

    public Iterable<Record> saveRecords(List<Record> records);
    public void saveRecordsByBasket(long idUser, long idBasket, List<Record> records);

    public Record addNewRecord(long idUser, long idBasket, Record record);
    public void deleteRecord(Record record);
    public boolean deleteRecord(long idUser, long idBasket, long idRecord);
}
