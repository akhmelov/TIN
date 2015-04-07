package com.springapp.mvc.model.printers;

import org.springframework.stereotype.Component;

import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import java.util.ArrayList;

/**
 * Created by PK on 3/22/2015.
 */
@Component
public class Printers
{
    /**
     *
     * @return Zwrava nazwe dostepnych drukarek na tym komputerze
     */
    public ArrayList<String> availiblePrinters()
    {
        ArrayList<String> retList = new ArrayList<String>();
        DocFlavor flavor = DocFlavor.URL.GIF;
        PrintService[] services = PrintServiceLookup.lookupPrintServices(flavor, null);
        if(services.length == 0)
            return null;
        for (PrintService tmp: services)
        {
            retList.add(tmp.getName());
        }
        return retList;
    }
}
