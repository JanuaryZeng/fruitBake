package com.fruitBake.domain;

import java.io.Serializable;

public class Users implements Serializable {

    private String Uname;
    private String Upassword;
    private Integer ovenCount;

    public Users() {
    }

    public Users(String uname, String upassword) {
        Uname = uname;
        Upassword = upassword;
    }

    public Users(String uname, String upassword, Integer ovenCount) {
        Uname = uname;
        Upassword = upassword;
        this.ovenCount = ovenCount;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Uname='" + Uname + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", ovenCount=" + ovenCount +
                '}';
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }

    public String getUpassword() {
        return Upassword;
    }

    public void setUpassword(String upassword) {
        Upassword = upassword;
    }

    public Integer getOvenCount() {
        return ovenCount;
    }

    public void setOvenCount(Integer ovenCount) {
        this.ovenCount = ovenCount;
    }
}
