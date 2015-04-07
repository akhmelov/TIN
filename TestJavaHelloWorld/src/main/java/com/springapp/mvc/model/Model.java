package com.springapp.mvc.model;

import com.springapp.mvc.model.printers.Printers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by PK on 3/21/2015.
 */
@Component
public class Model
{
    @Autowired
    Printers printers;
    /**
     *
     * @return zwraca liste dosptenych drukarek na danym komputerze
     */
    public ArrayList<String> getAvailiblePrinters()
    {


//        ArrayList<String> availiblePrinters = new ArrayList< String >();
//        availiblePrinters.add("Test1");
//        availiblePrinters.add("Test2");
//        availiblePrinters.add("Test3");
//        availiblePrinters.add("Test4");
//        availiblePrinters.add("Test5");

        return printers.availiblePrinters();
    }
}
