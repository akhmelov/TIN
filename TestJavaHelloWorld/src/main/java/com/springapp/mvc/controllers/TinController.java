package com.springapp.mvc.controllers;

import com.springapp.mvc.common.dao.Record;
import com.springapp.mvc.model.Model;
import com.springapp.mvc.model.database.Db;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by PK on 4/3/2015.
 */
@Controller
@RequestMapping("/tin")
public class TinController
{
    @Autowired
    private Model model;
    @Autowired
    private Db database;

    @RequestMapping(value = "/home")
    public ModelAndView home()
    {
        ModelAndView modelAndView = new ModelAndView("maket");
        return modelAndView;
    }

    @RequestMapping(value = "/getRecordsJson", method = RequestMethod.POST)
    public @ResponseBody List<Record> getRecords()
    {
        //TODO
        return database.getRecordsByBasket(1, 1);
    }

    @RequestMapping(value = "/saveRecords", method = RequestMethod.POST)
    public ModelAndView saveRecords(@RequestBody LinkedList<Record> records)
    {
        //TODO
        database.saveRecordsByBasket(1, 1, records);
        ModelAndView modelAndView = new ModelAndView("maket");
        return modelAndView;
    }

    @RequestMapping(value = "/deleteRecord", method = RequestMethod.POST)
    public @ResponseBody Boolean deleteRecord(int idRecord)
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
