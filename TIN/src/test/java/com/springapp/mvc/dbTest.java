package com.springapp.mvc;

import com.springapp.mvc.grains.User;
import com.springapp.mvc.grains.UserRepository;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author asmolik
 */
@Component
public class dbTest {


    @Autowired
    UserRepository repository;

    @Test
    public void test()
    {
        repository.save(new User("asmolik@lol", "Olek", "Sm"));
        repository.save(new User("elo@lol", "Elo", "Ziomek"));

        for (User user : repository.findAll()) {
            System.out.println(user);
        }
        for (User user : repository.findByMail("asmolik@lol")) {
            System.out.println(user);
        }
    }
}
