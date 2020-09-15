package com.example.services;

import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.Date;

public class CatFacts implements Comparable<CatFacts> {

    private String text;
    private Date createdAt;
    private Date updatedAt;

    public CatFacts(){}

    public void setText(String text)
    {
        this.text = text;
    }

    public void setCreatedAt(Date createdAt)
    {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(Date updatedAt)
    {
        this.updatedAt = updatedAt;
    }

    public String getText()
    {
        return text;
    }

    public Date getCreatedAt()
    {
        return createdAt;
    }

    public Date getUpdatedAt()
    {
        return updatedAt;
    }


    @Override
    public int compareTo(CatFacts cf)
    {
        return getCreatedAt().compareTo(cf.getCreatedAt());
    }


    @Override
    public String toString()
    {
        return "\n\n\"Created at= " + createdAt + "Text = " + text + " Updated at: " + updatedAt;
    }
}
