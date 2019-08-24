package com.fruitBake.domain;

import java.io.Serializable;

public class Users implements Serializable {

    private String Uname;
    private String Upassword;
    private String Uicon;
    private String Ucontext;
    private String phone;

    public Users() {
    }

    public Users(String uname, String upassword) {
        Uname = uname;
        Upassword = upassword;
    }

    public Users(String uname, String upassword, String Uicon) {
        Uname = uname;
        Upassword = upassword;
        this.Uicon = Uicon;
    }

    @Override
    public String toString() {
        return "Users{" +
                "Uname='" + Uname + '\'' +
                ", Upassword='" + Upassword + '\'' +
                ", ovenCount=" + Uicon +
                ", Ucontext='" + Ucontext + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }

    public String getUicon() {
        return Uicon;
    }

    public void setUicon(String uicon) {
        Uicon = uicon;
    }

    public Users(String uname, String upassword, String Uicon, String ucontext, String phone) {
        Uname = uname;
        Upassword = upassword;
        this.Uicon = Uicon;
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

    public String getOvenCount() {
        return Uicon;
    }

    public void setOvenCount(String Uicon) {
        this.Uicon = Uicon;
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
