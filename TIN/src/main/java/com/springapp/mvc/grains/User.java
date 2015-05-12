package com.springapp.mvc.grains;

import javax.persistence.*;
import java.util.List;

/**
 * @author asmolik
 */
@Entity
@Table(name = "users")
public class User
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(nullable = false, unique = true)
    private String mail;
    @Column
    private String name;
    @Column
    private String surname;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<Basket> baskets;


    protected User() {}

    public User(String mail, String name, String surname) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
    }

    public User(String mail, String name, String surname, List<Basket> baskets) {
        this.mail = mail;
        this.name = name;
        this.surname = surname;
        this.baskets = baskets;
    }

    public void addBasket(Basket basket) {
        basket.setUser(this);
        baskets.add(basket);
    }

    public List<Basket> getBaskets() {
        return baskets;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", mail='" + mail + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
