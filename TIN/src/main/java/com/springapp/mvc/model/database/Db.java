package com.springapp.mvc.model.database;

import com.springapp.mvc.common.dao.Record;
import org.springframework.stereotype.Component;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * Created by PK on 4/6/2015.
 */
@Component
public class Db
{
    private LinkedList<Record> records; //only for test

    public Db()
    {
        this.records = new LinkedList<Record>();
        int n = 10;
        for(int i = 0; i < n; i++)
        {   //test
            Record tmp = new Record();
            tmp.setId(n - i -1); //started 0
            tmp.setMA(false);
            tmp.setNameStudent("TestName " + i);
            tmp.setMailStudent("test");
            tmp.setSurnamePromoter("TestName " + i);
            tmp.setNamePromoter("test");
            tmp.setSurnameStudent("Test Name " + i);
            tmp.setAbstractEN("");
            tmp.setAbstractPL("");
            tmp.setTitleEN("test");
            tmp.setTitlePL("test");
            tmp.setKeyWordsEN("test");
            tmp.setKeyWordsPL("test");

            records.push(tmp);
        }
    }

    public Record getRecord(int idPromoter, int idBasket, int idRecord)
    {
        return records.get(idRecord);
    }

    public LinkedList<Record> getRecordsByBasket(int idPromoter, int idBasket)
    {
        return records;
    }

    public boolean saveRecord(int idPromoter, int idBasket, int idRecord, Record record)
    {
        records.set(idRecord, record);
        return true;
    }

    public boolean saveRecordsByBasket(int idPromoter, int idBasket, LinkedList<Record> records)
    {
        this.records = records;
        return true;
    }

    public boolean deleteRecord(int idPromoter, int idBasket, int idRecord)
    {
        records.remove(idRecord);
        return true;
    }
}
