package com.springapp.mvc.controllers;

import com.springapp.mvc.App;
import com.springapp.mvc.forms.SingInForm;
import com.springapp.mvc.model.Model;
import com.springapp.mvc.database.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by PK on 4/3/2015.
 */
@Controller
@RequestMapping(App.PIK_CONTROLLER_URL)
public class PikController
{
    @Autowired
    private Model model;
    @Autowired
    private DataSource database;

    @RequestMapping(value = App.PIK_START_PAGE, method = RequestMethod.GET)
    public ModelAndView home(ModelMap modelMap)
    {
        ModelAndView modelAndView = new ModelAndView(App.PIK_START_PAGE);
        modelAndView.addObject("singInForm", new SingInForm());
        return modelAndView;
    }

    @RequestMapping(value = App.PIK_START_PAGE, method = RequestMethod.POST)
    public ModelAndView homePost(@ModelAttribute("SpringWeb") SingInForm singInForm)
    {
        ModelAndView modelAndView = new ModelAndView();
        switch (singInForm.getWho())
        {
            case Promoter:
                modelAndView.setViewName(App.PROMOTER);
                break;
            case Admin:
                modelAndView.setViewName(App.ADMIN);
                break;
            default:
                modelAndView.setViewName(App.PIK_START_PAGE);
        }
        return modelAndView;
    }
}
