package com.fruitBake.domain;

public class FruitCount {
    private String Fname;
    private String num;

    @Override
    public String toString() {
        return "FruitCount{" +
                "Fname='" + Fname + '\'' +
                ", num='" + num + '\'' +
                '}';
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        this.num = num;
    }
}
