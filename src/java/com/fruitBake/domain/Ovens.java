package com.fruitBake.domain;

import java.io.Serializable;

public class Ovens implements Serializable {
    String Oname;
    String Ostatus;
    String IP;

    @Override
    public String toString() {
        return "Ovens{" +
                "Oname='" + Oname + '\'' +
                ", Ostatus='" + Ostatus + '\'' +
                ", IP='" + IP + '\'' +
                '}';
    }

    public String getIP() {
        return IP;
    }

    public void setIP(String IP) {
        this.IP = IP;
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
