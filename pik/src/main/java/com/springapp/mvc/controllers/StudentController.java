package com.springapp.mvc.controllers;

import com.springapp.mvc.App;
import com.springapp.mvc.grains.Student;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Sasha on 3/19/2015.
 */
@Controller
@RequestMapping(App.STUDENT_CONTROLLER_URL)
public class StudentController
{
}