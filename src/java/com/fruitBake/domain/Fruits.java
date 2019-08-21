package com.fruitBake.domain;

import java.io.Serializable;

public class Fruits implements Serializable {

    private String Fname;
    private String mean;

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

    @Override
    public String toString() {
        return "Fruits{" +
                "Fname='" + Fname + '\'' +
                ", mean='" + mean + '\'' +
                '}';
    }
}
