package com.springapp.mvc.grains;

import org.springframework.stereotype.Component;

/**
 * Created by Sasha on 3/19/2015.
 */
@Component
public class Student
{
    private Integer age;
    private String name;
    private Integer id;

    public void setAge(Integer age)
    {
        this.age = age;
    }
    public Integer getAge()
    {
        return age;
    }

    public void setName(String name)
    {
        this.name = name;
    }
    public String getName()
    {
        return name;
    }

    public void setId(Integer id)
    {
        this.id = id;
    }
    public Integer getId()
    {
        return id;
    }
}