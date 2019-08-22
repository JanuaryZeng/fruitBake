package com.fruitBake.domain;

import java.io.Serializable;

public class Notes implements Serializable {

    private Integer noteId;

    private Integer id;

    private String Fname;

    private String startTime;

    private String endTime;

    private String Uname;

    @Override
    public String toString() {
        return "Notes{" +
                "noteId=" + noteId +
                ", id=" + id +
                ", Fname='" + Fname + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", Uname='" + Uname + '\'' +
                '}';
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFname() {
        return Fname;
    }

    public void setFname(String fname) {
        Fname = fname;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getUname() {
        return Uname;
    }

    public void setUname(String uname) {
        Uname = uname;
    }
}
