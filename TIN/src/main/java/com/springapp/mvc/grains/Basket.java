package com.springapp.mvc.grains;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * Created by PK on 4/19/2015.
 */
@Entity
@Table(name = "baskets")
public class Basket implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    @CreatedDate
    Date dateCreate;
    @LastModifiedDate
    Date dateEdit;
    int contain;

    public Basket() {}

    public Basket(String name, Date dateCreate, Date dateEdit) {
        this.name = name;
        this.dateCreate = dateCreate;
        this.dateEdit = dateEdit;
    }


    public int getContain()
    {
        return contain;
    }

    public void setContain(int contain)
    {
        this.contain = contain;
    }

    public Date getDateEdit()
    {
        return dateEdit;
    }

    public void setDateEdit(Date dateEdit)
    {
        this.dateEdit = dateEdit;
    }

    public Date getDateCreate()
    {
        return dateCreate;
    }

    public void setDateCreate(Date dateCreate)
    {
        this.dateCreate = dateCreate;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateCreate=" + dateCreate +
                ", dateEdit=" + dateEdit +
                '}';
    }
}
