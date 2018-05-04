package com.example.model;


import javax.persistence.*;

import java.io.Serializable;


@Entity
@Table (name = "t_user")
public class User implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    int id;
    @Column(name = "name")
    String name;
    @Column(name = "pwd")
    String pwd;

    public long getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public String getPwd()
    {
        return pwd;
    }

    public void setPwd(String pwd)
    {
        this.pwd = pwd;
    }

}