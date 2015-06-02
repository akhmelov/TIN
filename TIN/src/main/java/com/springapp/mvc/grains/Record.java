package com.springapp.mvc.grains;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Created by PK on 4/3/2015.
 */
@Entity
@Table(name = "records")
public class Record implements Serializable
{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id;
    @Column(nullable = false)
    private boolean isMA = false;
    @Column
    private String nameStudent;
    @Column
    private String surnameStudent;
    @Column
    private String mailStudent;
    @Column
    private String titlePL;
    @Column
    private String titleEN;
    @Column
    private String namePromoter;
    @Column
    private String surnamePromoter;
    @Column
    private String abstractPL;
    @Column
    private String abstractEN;
    @Column
    private String keyWordsPL;
    @Column
    private String keyWordsEN;
    @Column
    private String issueDate;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "basket_id")
    private Basket basket;

    @Override
    public boolean equals(Object o)
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Record record = (Record) o;

        if (!id.equals(record.id)) return false;
        if (isMA != record.isMA) return false;
        if (abstractEN != null ? !abstractEN.equals(record.abstractEN) : record.abstractEN != null) return false;
        if (abstractPL != null ? !abstractPL.equals(record.abstractPL) : record.abstractPL != null) return false;
        if (keyWordsEN != null ? !keyWordsEN.equals(record.keyWordsEN) : record.keyWordsEN != null) return false;
        if (keyWordsPL != null ? !keyWordsPL.equals(record.keyWordsPL) : record.keyWordsPL != null) return false;
        if (mailStudent != null ? !mailStudent.equals(record.mailStudent) : record.mailStudent != null) return false;
        if (namePromoter != null ? !namePromoter.equals(record.namePromoter) : record.namePromoter != null)
            return false;
        if (nameStudent != null ? !nameStudent.equals(record.nameStudent) : record.nameStudent != null) return false;
        if (surnamePromoter != null ? !surnamePromoter.equals(record.surnamePromoter) : record.surnamePromoter != null)
            return false;
        if (surnameStudent != null ? !surnameStudent.equals(record.surnameStudent) : record.surnameStudent != null)
            return false;
        if (titleEN != null ? !titleEN.equals(record.titleEN) : record.titleEN != null) return false;
        if (titlePL != null ? !titlePL.equals(record.titlePL) : record.titlePL != null) return false;

        return true;
    }

    @Override
    public int hashCode()
    {
        int result = (int)(long)id;
        result = 31 * result + (isMA ? 1 : 0);
        result = 31 * result + (nameStudent != null ? nameStudent.hashCode() : 0);
        result = 31 * result + (surnameStudent != null ? surnameStudent.hashCode() : 0);
        result = 31 * result + (mailStudent != null ? mailStudent.hashCode() : 0);
        result = 31 * result + (titlePL != null ? titlePL.hashCode() : 0);
        result = 31 * result + (titleEN != null ? titleEN.hashCode() : 0);
        result = 31 * result + (namePromoter != null ? namePromoter.hashCode() : 0);
        result = 31 * result + (surnamePromoter != null ? surnamePromoter.hashCode() : 0);
        result = 31 * result + (abstractPL != null ? abstractPL.hashCode() : 0);
        result = 31 * result + (abstractEN != null ? abstractEN.hashCode() : 0);
        result = 31 * result + (keyWordsPL != null ? keyWordsPL.hashCode() : 0);
        result = 31 * result + (keyWordsEN != null ? keyWordsEN.hashCode() : 0);
        return result;
    }

    public String getKeyWordsEN()
    {
        return keyWordsEN;
    }

    public void setKeyWordsEN(String keyWordsEN)
    {
        this.keyWordsEN = keyWordsEN;
    }

    public String getKeyWordsPL()
    {
        return keyWordsPL;
    }

    public void setKeyWordsPL(String keyWordsPL)
    {
        this.keyWordsPL = keyWordsPL;
    }

    public String getAbstractEN()
    {
        return abstractEN;
    }

    public void setAbstractEN(String abstractEN)
    {
        this.abstractEN = abstractEN;
    }

    public String getAbstractPL()
    {
        return abstractPL;
    }

    public void setAbstractPL(String abstractPL)
    {
        this.abstractPL = abstractPL;
    }

    public String getSurnamePromoter()
    {
        return surnamePromoter;
    }

    public void setSurnamePromoter(String surnamePromoter)
    {
        this.surnamePromoter = surnamePromoter;
    }

    public String getNamePromoter()
    {
        return namePromoter;
    }

    public void setNamePromoter(String namePromoter)
    {
        this.namePromoter = namePromoter;
    }

    public String getTitleEN()
    {
        return titleEN;
    }

    public void setTitleEN(String titleEN)
    {
        this.titleEN = titleEN;
    }

    public String getTitlePL()
    {
        return titlePL;
    }

    public void setTitlePL(String titlePL)
    {
        this.titlePL = titlePL;
    }

    public String getMailStudent()
    {
        return mailStudent;
    }

    public void setMailStudent(String mailStudent)
    {
        this.mailStudent = mailStudent;
    }

    public String getSurnameStudent()
    {
        return surnameStudent;
    }

    public void setSurnameStudent(String surnameStudent)
    {
        this.surnameStudent = surnameStudent;
    }

    public String getNameStudent()
    {
        return nameStudent;
    }

    public void setNameStudent(String nameStudent)
    {
        this.nameStudent = nameStudent;
    }

    public String getIssueDate()
    {
        return issueDate;
    }

    public void setIssueDate(String issueDate)
    {
        this.issueDate = issueDate;
    }
    
    public boolean isMA()
    {
        return isMA;
    }

    public void setMA(boolean isMA)
    {
        this.isMA = isMA;
    }

    public Long getId()
    {
        return id;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    @Override
    public String toString() {
        return "Record{" +
                "id=" + id +
                ", isMA=" + isMA +
                ", nameStudent='" + nameStudent + '\'' +
                ", surnameStudent='" + surnameStudent + '\'' +
                ", mailStudent='" + mailStudent + '\'' +
                ", titlePL='" + titlePL + '\'' +
                ", titleEN='" + titleEN + '\'' +
                ", namePromoter='" + namePromoter + '\'' +
                ", surnamePromoter='" + surnamePromoter + '\'' +
                ", abstractPL='" + abstractPL + '\'' +
                ", abstractEN='" + abstractEN + '\'' +
                ", keyWordsPL='" + keyWordsPL + '\'' +
                ", keyWordsEN='" + keyWordsEN + '\'' +
                '}';
    }
}
