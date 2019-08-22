package com.fruitBake.domain;

import java.io.Serializable;

public class Logs implements Serializable {

    private Integer id;

    private Integer noteId;

    private Float temp;

    private Float humi;

    private String Ltime;

    private String Level;

    @Override
    public String toString() {
        return "Logs{" +
                "id=" + id +
                ", noteId=" + noteId +
                ", temp=" + temp +
                ", humi=" + humi +
                ", Ltime='" + Ltime + '\'' +
                ", Level='" + Level + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Float getTemp() {
        return temp;
    }

    public void setTemp(Float temp) {
        this.temp = temp;
    }

    public Float getHumi() {
        return humi;
    }

    public void setHumi(Float humi) {
        this.humi = humi;
    }

    public String getLtime() {
        return Ltime;
    }

    public void setLtime(String ltime) {
        Ltime = ltime;
    }

    public String getLevel() {
        return Level;
    }

    public void setLevel(String level) {
        Level = level;
    }
}
