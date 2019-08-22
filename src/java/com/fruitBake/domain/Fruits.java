package com.fruitBake.domain;

import java.io.Serializable;

public class Fruits implements Serializable {

    private String Fname;
    private String mean;
    private String Ficon;

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public String getFicon() {
        return Ficon;
    }

    public void setFicon(String ficon) {
        Ficon = ficon;
    }


    @Override
    public String toString() {
        return "Fruits{" +
                "Fname='" + Fname + '\'' +
                ", mean='" + mean + '\'' +
                ", Ficon='" + Ficon + '\'' +
                '}';
    }
}
