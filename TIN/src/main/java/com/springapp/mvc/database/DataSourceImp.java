package com.springapp.mvc.database;

import com.google.common.collect.Lists;
import com.springapp.mvc.grains.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by PK on 4/8/2015.
 */
@Component
public class DataSourceImp implements DataSource
{
    @Autowired
    UserRepository userRepository;
    @Autowired
    BasketRepository basketRepository;
    @Autowired
    RecordRepository recordRepository;

    @Override
    public List<User> getUsers() {
        List<User> list = Lists.newArrayList(userRepository.findAll());
        return list;
    }

    @Override
    public List<User> getUserByMail(String mail) {
        List<User> ret = userRepository.findByMail(mail);
        return ret;
    }

    @Override
    public User getUser(long id) {
        return userRepository.findOne(id);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Basket> getBaskets(long idUser) {
        List<Basket> list;
        User user = userRepository.findOne(idUser);
        if (user == null) {
            list = new ArrayList<>();
        } else {
            list = basketRepository.findByUser(user);
        }
        return list;
    }

    @Override
    public List<Basket> getBasketsByUser(User user) {
        return basketRepository.findByUser(user);
    }

    @Override
    public Basket saveBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public void deleteBasket(Basket basket) {
        basketRepository.delete(basket);
    }

    @Override
    public void deleteUser(User user) {
        userRepository.delete(user);
    }

    @Override
    public Basket getBasketById(long id) {
        return basketRepository.findOne(id);
    }

    @Override
    public void deleteBasket(long idUser, long idBasket) {
        Basket basket = basketRepository.findOne(idBasket);
        if (basket != null) {
            basketRepository.delete(basket);
        }
    }

    @Override
    public Record getRecordById(long id) {
        return recordRepository.findOne(id);
    }

    @Override
    public Record getRecord(long idUser, long idBasket, long idRecord) {
        return recordRepository.findOne(idRecord);
    }

    @Override
    public List<Record> getRecordsByBasket(Basket basket) {
        return recordRepository.findByBasket(basket);
    }

    @Override
    public List<Record> getRecordsByBasket(long idBasket) {
        List<Record> list;
        Basket basket = basketRepository.findOne(idBasket);
        if (basket == null) {
            list = new ArrayList<>();
        } else {
            list = recordRepository.findByBasket(basket);
        }
        return list;
    }

    @Override
    public List<Record> getRecordsByBasket(long idUser, long idBasket) {
        List<Record> list;
        Basket basket = basketRepository.findOne(idBasket);
        if (basket == null) {
            list = new ArrayList<>();
        } else {
            list = recordRepository.findByBasket(basket);
        }
        return list;
    }

    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public Record saveRecord(long idUser, long idBasket, Record record) {
        Basket basket = basketRepository.findOne(idBasket);
        if (basket != null) {
            record.setBasket(basket);
            return recordRepository.save(record);
        }
        return null;
    }

    @Override
    public Iterable<Record> saveRecords(List<Record> records) {
        return recordRepository.save(records);
    }

    @Override
    public void saveRecordsByBasket(long idUser, long idBasket, List<Record> records) {
        Basket basket = basketRepository.findOne(idBasket);
        if (basket != null) {
            for (Record record : records) {
                record.setBasket(basket);
            }
            recordRepository.save(records);
        }
    }

    @Override
    public Record addNewRecord(long idUser, long idBasket, Record record) {
        Basket basket = basketRepository.findOne(idBasket);
        if (basket != null) {
            record.setBasket(basket);
            record = recordRepository.save(record);
            return record;
        }
        return null;
    }

    @Override
    public void deleteRecord(Record record) {
        recordRepository.delete(record);
    }

    @Override
    public boolean deleteRecord(long idUser, long idBasket, long idRecord) {
        Record record = recordRepository.findOne(idRecord);
        if (record == null) {
            return false;
        } else {
            recordRepository.delete(record);
            return true;
        }
    }

}
