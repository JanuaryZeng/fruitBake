package com.fruitBake.domain;

import java.io.Serializable;

public class Users implements Serializable {

    private String Uname;
    private String Upassword;
    private Integer ovenCount;
    private String Ucontext;
    private String phone;

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
                ", Ucontext='" + Ucontext + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public Users(String uname, String upassword, Integer ovenCount, String ucontext, String phone) {
        Uname = uname;
        Upassword = upassword;
        this.ovenCount = ovenCount;
        Ucontext = ucontext;
        this.phone = phone;
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

    public String getUcontext() {
        return Ucontext;
    }

    public void setUcontext(String ucontext) {
        Ucontext = ucontext;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
