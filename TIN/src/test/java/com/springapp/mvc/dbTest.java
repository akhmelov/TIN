package com.springapp.mvc;

import com.springapp.mvc.config.ApplicationContext;
import com.springapp.mvc.database.DataSource;
import com.springapp.mvc.grains.Basket;
import com.springapp.mvc.grains.User;
import com.springapp.mvc.grains.UserRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @author asmolik
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {ApplicationContext.class})
public class dbTest {


    @Autowired
    DataSource dataSource;
    @Autowired
    UserRepository repository;

    @Test
    public void test()
    {
        User olek = new User("asmolik@lol", "Olek", "Sm");
        repository.save(olek);
        repository.save(new User("asmolik2@lol", "Olek", "Sm"));
        repository.save(new User("elo@lol", "Elo", "Ziomek"));

        List<User> users = dataSource.getUserByMail("asmolik@lol");
        olek = users.get(0);
        List<Basket> bs = dataSource.getBasketsByUser(olek);
        for (Basket b : bs) {
            System.out.println(b);
        }
        dataSource.saveBasket(new Basket("3", olek));

        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        for (User user : repository.findByMail("asmolik@lol")) {
            System.out.println(user);
        }
        User olek2 = dataSource.getUserByMail("asmolik@lol").get(0);
        for (Basket b : dataSource.getBasketsByUser(olek2)) {
            System.out.println(b);
        }
    }
}
