package com.springapp.mvc.grains;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;

/**
 * Created by Sasha on 3/20/2015.
 */
@Component
public class PrintForm
{
    private boolean isDoublePage = false;
    private boolean isBlack = true;
    private String comment;
    private String printer;
    private MultipartFile file;

    public String getPrinter()
    {
        return printer;
    }

    public void setPrinter(String printer)
    {
        this.printer = printer;
    }

    public String getComment()
    {
        return comment;
    }

    public void setComment(String comment)
    {
        this.comment = comment;
    }

    public MultipartFile getFile()
    {
        return file;
    }

    public void setFile(MultipartFile file)
    {
        this.file = file;
    }

    public boolean isBlack()
    {
        return isBlack;
    }

    public void setBlack(boolean isBlack)
    {
        this.isBlack = isBlack;
    }

    public boolean isDoublePage()
    {

        return isDoublePage;
    }

    public void setDoublePage(boolean isDoublePage)
    {
        this.isDoublePage = isDoublePage;
    }
}
