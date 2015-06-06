package com.springapp.mvc.controllers;

import com.springapp.mvc.App;
import com.springapp.mvc.database.DataSourceImp;
import com.springapp.mvc.forms.SingInForm;
import com.springapp.mvc.grains.Basket;
import com.springapp.mvc.grains.Record;
import com.springapp.mvc.grains.User;
import com.springapp.mvc.grains.UserSession;
import com.springapp.mvc.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

/**
 * Created by PK on 4/8/2015.
 */
@Controller
@Scope("session")
@RequestMapping(App.TIN_CONTROLLER_URL)
public class TinController
{
    @Autowired
    private Model model;
    @Autowired
    private DataSourceImp database;
    @Autowired
    private UserSession session;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(ModelMap modelMap)
    {
        if(session.getWho().equals(UserSession.Who.Admin)){
            return new ModelAndView("redirect:" + App.TIN_CONTROLLER_URL + App.ADMIN);
        } else if(session.getWho().equals(UserSession.Who.Promoter)){
            return new ModelAndView("redirect:" + App.TIN_CONTROLLER_URL + App.BASKETS);
        }
        ModelAndView modelAndView = new ModelAndView(App.HOME);
        modelAndView.addObject("singInForm", new SingInForm());
        return modelAndView;
    }

    @RequestMapping(value = App.HOME, method = RequestMethod.POST)
    public String homePost(@ModelAttribute("SpringWeb") SingInForm singInForm)
    {   //TODO
        User user;
        ModelAndView modelAndView = new ModelAndView();
        if(singInForm.getUsername().equals(App.ADMIN_USERNAME) && singInForm.getPassword().equals(App.ADMIN_PASSWORD)){
            singInForm.setWho(SingInForm.Who.Admin);
            session.setWho(UserSession.Who.Admin);
            session.setId(0);
        } else {
            List<User> users = database.getUserByMail(singInForm.getUsername());
            if(!users.isEmpty()){
                user = database.getUserByMail(singInForm.getUsername()).get(0);
                singInForm.setWho(SingInForm.Who.Promoter);
                session.setWho(UserSession.Who.Promoter);
                session.setId(user.getId());
            } else {
                singInForm.setWho(SingInForm.Who.None);
            }
        }
        switch (session.getWho())
        {
            case Promoter:
                return "redirect:" + App.BASKETS;
            case Admin:
                return "redirect:" + App.ADMIN;
            default:
                return "redirect:.." + App.TIN_CONTROLLER_URL;
        }
    }

    @RequestMapping(value = App.LOG_OUT, method = RequestMethod.GET)
    public String logOut()
    {
        session.setWho(UserSession.Who.None);
        return  "redirect:" + App.TIN_CONTROLLER_URL;
    }

    @RequestMapping(value = App.BASKETS, method = RequestMethod.GET)
    public ModelAndView basketsPage()
    {
        if(!hasPermission()){
            return new ModelAndView(App.TIN_CONTROLLER_URL);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(App.BASKETS);
        modelAndView.addObject("baskets", database.getBaskets(session.getId()));
        return  modelAndView;
    }

    @RequestMapping(value = App.BASKET)
    public ModelAndView homeTin(HttpServletRequest request)
    {
        if(!hasPermission()){
            return new ModelAndView(App.TIN_CONTROLLER_URL);
        }
        String idBasket = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
        int id = Integer.valueOf(idBasket);

        ModelAndView modelAndView = new ModelAndView(App.BASKET);
        modelAndView.addObject("idBasket", id);
        return modelAndView;
    }

    @RequestMapping(value = App.BASKETS, method = RequestMethod.POST)
    public String addNewBasket(HttpServletRequest request)
    {
        if(!hasPermission()){
            return "redirect:" + App.TIN_CONTROLLER_URL;
        }
        String basketName = request.getParameter(App.NAME_NEW_BASKET_PARAMETER);
        User user = database.getUser(session.getId());
        Basket basket = new Basket(basketName, user);
        database.saveBasket(basket);
        return "redirect:" + App.BASKETS;
    }

    @RequestMapping(value = App.DELETE_BASKET, method = RequestMethod.POST)
    public String deleteBasket(HttpServletRequest request)
    {
        if(!hasPermission()){
            return "redirect:" + App.TIN_CONTROLLER_URL;
        }
        String idBasket = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
        int id = Integer.valueOf(idBasket);
        database.deleteBasket(session.getId(), id);
        return "redirect:" + App.BASKETS;
    }

    @RequestMapping(value = App.EDIT_BASKET, method = RequestMethod.POST)
    public String editBasket(HttpServletRequest request)
    {
        if(!hasPermission()){
            return "redirect:" + App.TIN_CONTROLLER_URL;
        }
        String idBasket = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
        String newBasketName = request.getParameter(App.NAME_NEW_BASKET_PARAMETER);
        int id = Integer.valueOf(idBasket);
        Basket basket = database.getBasketById(id);
        basket.setName(newBasketName);
        database.saveBasket(basket);
        return "redirect:" + App.BASKETS;
    }

    @RequestMapping(value = App.GET_RECORDS_JSON, method = RequestMethod.POST)
    public @ResponseBody List<Record> getRecords(@RequestParam(value = "" + App.ID_EXIST_BASKET_PARAMETER) Integer idBasket)
    {
        if(!hasPermission()){
            return new LinkedList<Record>();
        }
        List<Record> tmp = database.getRecordsByBasket(session.getId(), idBasket);
        return tmp;
    }

    @RequestMapping(value = App.SAVE_RECORDS, method = RequestMethod.POST)
    public ModelAndView saveRecords(@RequestBody LinkedList<Record> records)
    {
        //TODO NOT WORKS
        if(!hasPermission()){
            return new ModelAndView(App.TIN_CONTROLLER_URL);
        }
        List<Record> list = new ArrayList<>();
        database.saveRecordsByBasket(session.getId(), 1, list);
        ModelAndView modelAndView = new ModelAndView("basket");
        return modelAndView;
    }

    @RequestMapping(value = App.ADD_RECORD, method = RequestMethod.POST)
    public @ResponseBody Integer addRecord(@RequestParam(value = "" + App.ID_EXIST_BASKET_PARAMETER) Integer idBasket)
    {
        if(!hasPermission()){
            return new Integer(-1);
        }
        Record record = new Record();
        return (int)(long)database.addNewRecord(session.getId(), idBasket, record).getId();
    }

    @RequestMapping(value = App.GET_RECORD, method = RequestMethod.POST)
    public @ResponseBody Record getRecords(@RequestParam(value = "" + App.ID_EXIST_BASKET_PARAMETER) Integer idBasket,
                                           @RequestParam(value = "" + App.ID_EXIST_RECORD_PARAMETER) Integer idRecord)
    {
        if(!hasPermission()){
            return new Record();
        }
        Record record = database.getRecord(session.getId(), idBasket, idRecord);
        return record;
    }

    @RequestMapping(value = App.DELETE_RECORD, method = RequestMethod.POST)
    public @ResponseBody Boolean deleteRecord(HttpServletRequest request)
    {
        if(!hasPermission()){
            return new Boolean(false);
        }
        int idBasket = Integer.valueOf(request.getParameter(App.ID_EXIST_BASKET_PARAMETER));
        int idRecord = Integer.valueOf(request.getParameter(App.ID_EXIST_RECORD_PARAMETER));
        if(database.deleteRecord(session.getId(), idBasket, idRecord))
            return new Boolean(true);
        return new Boolean(true);
    }

    @RequestMapping(value = App.SAVE_RECORD, method = RequestMethod.POST)
    public @ResponseBody Boolean saveRecord(@RequestParam("idBasket") Integer idBasket,@RequestBody Record record)
    {
        if(!hasPermission()){
            return new Boolean(false);
        }
        if(database.saveRecord(session.getId(), idBasket, record) != null)
            return new Boolean(true);
        return new Boolean(false);
    }

    @RequestMapping(value = App.GENERATE_XML_INZ)
    public @ResponseBody String generateXMLInz(@RequestParam("idBasket") Integer idBasket)
    {
        if(!hasPermission()){
            return "You don't have permission";
        }
        List<Record> records = database.getRecordsByBasket(idBasket);
        String ret="";
        for(Record rec: records) {
            if (!rec.isMA()){
                ret += WriteXMLFile.create(rec);
                ret += '\n';
            }
        }
        return ret;
    }

    @RequestMapping(value = App.GENERATE_XML_MGR)
    public @ResponseBody String generateXMLMgr(@RequestParam("idBasket") Integer idBasket)
    {
        if(!hasPermission()){
            return "You don't have permission";
        }
        List<Record> records = database.getRecordsByBasket(idBasket);
        String ret="";
        for(Record rec: records){
            if (rec.isMA()){
                ret += WriteXMLFile.create(rec);
                ret += '\n';
            }
        }
        return ret;
    }

    boolean hasPermission()
    {
        if(session.getWho().equals(UserSession.Who.None))
            return false;
        return true;
    }

    ///ADMIN section below

    @RequestMapping(value = App.ADMIN, method = RequestMethod.GET)
    public ModelAndView usersPage()
    {
        if(!hasPermission() && !session.getWho().equals(UserSession.Who.Admin)){
            return new ModelAndView(App.TIN_CONTROLLER_URL);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(App.ADMIN);
        modelAndView.addObject("users", database.getUsers());
        return  modelAndView;
    }

    @RequestMapping(value = App.ADMIN, method = RequestMethod.POST)
    public String addNewUser(HttpServletRequest request)
    {
        if(!hasPermission() && !session.getWho().equals(UserSession.Who.Admin)){
            return "redirect:" + App.TIN_CONTROLLER_URL;
        }
        String basketName = request.getParameter(App.NAME_NEW_BASKET_PARAMETER);
        User olek = new User(basketName, basketName + "Olek44", basketName + "Sm44");
        database.saveUser(olek);
        return "redirect:" + App.ADMIN;
    }

    @RequestMapping(value = App.DELETE_USER, method = RequestMethod.POST)
    public String deleteUser(HttpServletRequest request)
    {
        if(!hasPermission() && !session.getWho().equals(UserSession.Who.Admin)){
            return "redirect:" + App.TIN_CONTROLLER_URL;
        }
        String idUser = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
        int id = Integer.valueOf(idUser);
        database.deleteUser(database.getUser(id));
        return "redirect:" + App.ADMIN;
    }

    @RequestMapping(value = App.EDIT_USER, method = RequestMethod.POST)
    public String editUser(HttpServletRequest request)
    {
        if(!hasPermission() && !session.getWho().equals(UserSession.Who.Admin)){
            return "redirect:" + App.TIN_CONTROLLER_URL;
        }
        String idBasket = request.getParameter(App.ID_EXIST_BASKET_PARAMETER);
        int id = Integer.valueOf(idBasket);
        database.deleteBasket(1, id);
        return "redirect:" + App.ADMIN;
    }
}
