package com.fruitBake.domain;

import java.io.Serializable;

public class Ovens implements Serializable {
    Integer id;
    String Oname;
    String Ostatus;

    @Override
    public String toString() {
        return "Ovens{" +
                "id=" + id +
                ", Oname='" + Oname + '\'' +
                ", Ostatus='" + Ostatus + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOname() {
        return Oname;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    public String getOstatus() {
        return Ostatus;
    }

    public void setOstatus(String ostatus) {
        Ostatus = ostatus;
    }
}
