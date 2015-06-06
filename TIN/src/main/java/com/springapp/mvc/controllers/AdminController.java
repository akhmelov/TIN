//package com.springapp.mvc.controllers;
//
//import com.springapp.mvc.App;
//import com.springapp.mvc.database.DataSource;
//import com.springapp.mvc.database.DataSourceImp;
//import com.springapp.mvc.grains.Basket;
//import com.springapp.mvc.grains.User;
//import com.springapp.mvc.grains.UserSession;
//import com.springapp.mvc.model.Model;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//
///**
// * Created by PK on 4/8/2015.
// */
//@Controller
//@Scope("session")
//@RequestMapping(App.ADMIN_CONSTROLLER_URL)
//public class AdminController
//{
//    @Autowired
//    private Model model;
//    @Autowired
//    private DataSourceImp database;
//    @Autowired
//    private UserSession session;
//
//    @RequestMapping(value = App.ADMIN, method = RequestMethod.GET)
//    public ModelAndView basketsPage()
//    {
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.setViewName(App.ADMIN);
//        modelAndView.addObject("users", database.getUsers());
//        return  modelAndView;
//    }
//
//    @RequestMapping(value = App.ADMIN, method = RequestMethod.POST)
//    public String addNewBasket(HttpServletRequest request)
//    {
//        String basketName = request.getParameter(App.NAME_NEW_BASKET_PARAMETER);
//        User olek = new User(basketName, basketName + "Olek44", basketName + "Sm44");
//        database.saveUser(olek);
//        return "redirect:" + App.ADMIN;
//    }
//
//    @RequestMapping(value = App.DELETE_USER, method = RequestMethod.POST)
//    public String deleteBasket(HttpServletRequest request)
//    {
//        String idUser = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
//        int id = Integer.valueOf(idUser);
//        database.deleteUser(database.getUser(id));
//        return "redirect:" + App.BASKETS;
//    }
//
//    @RequestMapping(value = App.EDIT_USER, method = RequestMethod.POST)
//    public String editBasket(HttpServletRequest request)
//    {
//        String idBasket = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
//        String newBasketName = request.getParameter(App.NAME_NEW_BASKET_PARAMETER);
//        int id = Integer.valueOf(idBasket);
//        database.deleteBasket(1, id);
//        return "redirect:" + App.BASKETS;
//    }
//}
