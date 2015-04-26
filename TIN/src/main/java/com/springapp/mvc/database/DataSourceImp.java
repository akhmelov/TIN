package com.springapp.mvc.database;

import com.springapp.mvc.grains.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
    public List<User> getUserByMail(String mail) {
        return userRepository.findByMail(mail);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<Basket> getBasketsByUser(User user) {
        return basketRepository.findByUser(user);
    }

    @Override
    public Basket addBasket(Basket basket) {
        return basketRepository.save(basket);
    }

    @Override
    public void deleteBasket(Basket basket) {
        basketRepository.delete(basket);
    }

    @Override
    public Record getRecordById(long id) {
        return recordRepository.findOne(id);
    }

    @Override
    public List<Record> getRecordsByBasket(Basket basket) {
        return recordRepository.findByBasket(basket);
    }

    @Override
    public Record saveRecord(Record record) {
        return recordRepository.save(record);
    }

    @Override
    public Iterable<Record> saveRecords(List<Record> records) {
        return recordRepository.save(records);
    }

    @Override
    public void deleteRecord(Record record) {
        recordRepository.delete(record);
    }

}
