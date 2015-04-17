package com.springapp.mvc.controllers;

import com.springapp.mvc.App;
import com.springapp.mvc.database.DataSource;
import com.springapp.mvc.forms.SingInForm;
import com.springapp.mvc.grains.Record;
import com.springapp.mvc.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by PK on 4/8/2015.
 */
@Controller
@RequestMapping(App.TIN_CONTROLLER_URL)
public class TinController
{
    @Autowired
    private Model model;
    @Autowired
    private DataSource database;

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView home(ModelMap modelMap)
    {
        ModelAndView modelAndView = new ModelAndView(App.HOME);
        modelAndView.addObject("singInForm", new SingInForm());
        return modelAndView;
    }

    @RequestMapping(value = App.HOME, method = RequestMethod.POST)
    public ModelAndView homePost(@ModelAttribute("SpringWeb") SingInForm singInForm)
    {
        ModelAndView modelAndView = new ModelAndView();
        switch (singInForm.getWho())
        {
            case Promoter:
                modelAndView = basketsPage();
                break;
            case Admin:
                modelAndView.setViewName(App.ADMIN);
                break;
            default:
                modelAndView.setViewName(App.HOME);
        }
        return modelAndView;
    }

    @RequestMapping(value = App.BASKETS, method = RequestMethod.GET)
    public ModelAndView basketsPage()
    {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName(App.BASKETS);
        return  modelAndView;
    }

    @RequestMapping(value = App.BASKET)
    public ModelAndView homeTin(ModelMap modelMap)
    {
        ModelAndView modelAndView = new ModelAndView(App.BASKET);
        return modelAndView;
    }


    @RequestMapping(value = "/getRecordsJson", method = RequestMethod.POST)
    public @ResponseBody
    List<Record> getRecords()
    {
        //TODO
        List<Record> tmp = new LinkedList<Record>(database.getRecordsByBasket(1, 1).values());
        return tmp;
    }

    @RequestMapping(value = "/saveRecords", method = RequestMethod.POST)
    public ModelAndView saveRecords(@RequestBody LinkedList<Record> records)
    {
        //TODO
        Map<Integer, Record> map = new HashMap<Integer, Record>();
        for (Record i : records) map.put(i.getId(), i);
        database.saveRecordsByBasket(1, 1, map);
        ModelAndView modelAndView = new ModelAndView("basket");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.GET)
    public @ResponseBody Boolean deleteRecord(@RequestParam(value = "idRecord") Integer idRecord)
    {
        //TODO
        if(database.deleteRecord(1, 1, idRecord))
            return new Boolean(false);
        return new Boolean(true);
    }

    @RequestMapping(value = "/saveRecord", method = RequestMethod.POST)
    public @ResponseBody Boolean saveRecord(@RequestBody Record record)
    {
        //TODO
        if(database.saveRecord(1, 1, record.getId(), record))
            return new Boolean(false);
        return new Boolean(true);
    }

    @RequestMapping(value = "/hasChangeRecord", method = RequestMethod.POST)
    public @ResponseBody Boolean hasChangeRecord(@RequestBody Record record)
    {
        //TODO
        if(database.getRecord(1, 1, record.getId()).equals(record))
            return new Boolean(false);
        return new Boolean(true);
    }

    @RequestMapping(value = "/generateXML", method = RequestMethod.POST, consumes = "application/json")
    public @ResponseBody String generateXML()
    {
        //TODO
        String ret = "Hello";
        return ret;
    }
}
