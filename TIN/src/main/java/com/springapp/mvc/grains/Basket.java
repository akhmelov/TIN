package com.springapp.mvc.grains;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * Created by PK on 4/19/2015.
 */
@Entity
@Table(name = "baskets")
public class Basket implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column
    String name;
    @Column
    @CreatedDate
    Date dateCreate;
    @Column
    @LastModifiedDate
    Date dateEdit;
    int contain;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    private User user;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "basket")
    List<Record> records;


    public Basket() {}

    public Basket(String name, User user) {
        this.name = name;
        this.dateCreate = new Date();
        this.dateEdit = new Date();
        this.user = user;
    }

    public Basket(String name, Date dateCreate, Date dateEdit, User user) {
        this.name = name;
        this.dateCreate = dateCreate;
        this.dateEdit = dateEdit;
        this.user = user;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Basket)) return false;

        Basket basket = (Basket) o;

        if (!getId().equals(basket.getId())) return false;
        if (!getName().equals(basket.getName())) return false;
        return getUser().equals(basket.getUser());

    }

    @Override
    public int hashCode() {
        int result = getId().hashCode();
        result = 31 * result + getName().hashCode();
        result = 31 * result + getUser().hashCode();
        return result;
    }

    public void setUser(User owner) {
        this.user = owner;
    }

    public User getUser(){
        return user;
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

    public Long getId()
    {
        return id;
    }

    public void setId(long id)
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
                ", user=" + user.getId() +
                '}';
    }
}
