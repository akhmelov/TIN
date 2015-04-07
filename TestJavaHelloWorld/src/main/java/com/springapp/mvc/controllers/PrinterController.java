package com.springapp.mvc.controllers;

import com.springapp.mvc.grains.PrintForm;
import com.springapp.mvc.model.Model;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Sasha on 3/20/2015.
 */
@Controller
@RequestMapping("/printer")
public class PrinterController
{
    @Autowired
    private Model model;

    @RequestMapping(value = "/printer", method = RequestMethod.GET)
    public String newBlanckPrint(ModelMap modelMap)
    {
        modelMap.addAttribute("printerForm", new PrintForm());
        modelMap.addAttribute("listPrinters", model.getAvailiblePrinters());
        return "printerForm";
    }

    @RequestMapping(value = "/status", method = RequestMethod.POST)
    public String statusPrinting(@ModelAttribute("SpringWeb") PrintForm printForm, ModelMap modelMap)
    {
        modelMap.addAttribute("properties", printForm);
        return "printerStatus";
    }
}
