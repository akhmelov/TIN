//package com.springapp.mvc.controllers;
//
//import com.springapp.mvc.App;
//import com.springapp.mvc.database.DataSourceImp;
//import com.springapp.mvc.forms.SingInForm;
//import com.springapp.mvc.grains.User;
//import com.springapp.mvc.grains.UserSession;
//import com.springapp.mvc.model.Model;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Scope;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.ModelMap;
//import org.springframework.web.bind.annotation.ModelAttribute;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.servlet.ModelAndView;
//
//import java.util.List;
//
///**
//* Created by PK on 6/4/2015.
//*/
//@Controller
//@Scope("session")
//public class StartController
//{
//    @Autowired
//    private Model model;
//
//    @Autowired
//    private DataSourceImp database;
//
//    @Autowired
//    private UserSession session;
//
//    @RequestMapping(method = RequestMethod.GET)
//    public String home(ModelMap modelMap)
//    {
//        User user;
//        switch (session.getWho())
//        {
//            case Promoter:
//                return "redirect:" + App.TIN_CONTROLLER_URL + App.BASKETS;
//            case Admin:
//                return "redirect:" + App.ADMIN_CONSTROLLER_URL + App.ADMIN;
//            default:
//                return "redirect:" + App.HOME + "1";
//        }
//    }
//
//    @RequestMapping(value = App.HOME + "1", method = RequestMethod.GET)
//    public ModelAndView home1(ModelMap modelMap)
//    {
//            ModelAndView modelAndView = new ModelAndView(App.HOME);
//            modelAndView.addObject("singInForm", new SingInForm());
//            return modelAndView;
//    }
//    @RequestMapping(value = App.HOME, method = RequestMethod.POST)
//    public String homePost(@ModelAttribute("SpringWeb") SingInForm singInForm)
//    {   //TODO
//        User user;
//        ModelAndView modelAndView = new ModelAndView();
//        if(singInForm.getUsername().equals(App.ADMIN_USERNAME) && singInForm.getPassword().equals(App.ADMIN_PASSWORD)){
//            singInForm.setWho(SingInForm.Who.Admin);
//            session.setWho(UserSession.Who.Admin);
//            session.setId(0);
//        } else {
//            List<User> users = database.getUserByMail(singInForm.getUsername());
//            if(!users.isEmpty()){
//                user = database.getUserByMail(singInForm.getUsername()).get(0);
//                singInForm.setWho(SingInForm.Who.Promoter);
//                session.setWho(UserSession.Who.Promoter);
//                session.setId(user.getId());
//            } else {
//                singInForm.setWho(SingInForm.Who.None);
//            }
//        }
//        return "redirect:/";
//    }
//}
