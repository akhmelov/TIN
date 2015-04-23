package com.springapp.mvc;

import com.springapp.mvc.grains.User;
import com.springapp.mvc.grains.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Created by PK on 4/8/2015.
 */
@SpringBootApplication
public class App implements CommandLineRunner
{
    public static final String TIN_CONTROLLER_URL = "/tin/";
    public static final String HOME = "index";
    public static final String BASKETS = "baskets";
    public static final String BASKET = "basket";
    public static final String ADD_BASKET = "addBasket";
    public static final String DELETE_BASKET = "deleteBasket";
    public static final String EDIT_BASKET = "editBasket";
    public static final String ADD_ESSAY = "addEssay";
    public static final String DELETE_ESSAY = "deleteEssay";
    public static final String EDIT_ESSAY = "editEssay";
    public static final String ADMIN = "admin";
    public static final String NAME_NEW_BASKET_PARAMETER = "nameBasket";
    public static final String ID_EXIST_BASKET_PARAMETER =  "idBasket";

    public static final String PIK_CONTROLLER_URL = "/pik/";
    public static final String STUDENT_CONTROLLER_URL = "/student/";
    public static final String PROMOTER_CONTROLLER_URL = "/promoter/";
    public static final String ADMIN_CONSTROLLER_URL = "/admin/";
    public static final String PIK_START_PAGE = "index";
    public static final String STUDENT = "student";
    public static final String PROMOTER = "promoter";




    @Autowired
    UserRepository repository;

    public static void main(String[] args) {
        SpringApplication.run(App.class);
    }

    @Override
    public void run(String... strings) throws Exception {

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
