package com.fruitBake.domain;

import java.io.Serializable;

public class Notes implements Serializable {

    private Integer noteId;

    private String Oname;

    private String Fname;

    private String startTime;

    private String endTime;

    private String Uname;

    private String Nstatus;

    @Override
    public String toString() {
        return "Notes{" +
                "noteId=" + noteId +
                ", Oname='" + Oname + '\'' +
                ", Fname='" + Fname + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", Uname='" + Uname + '\'' +
                ", Nstatus='" + Nstatus + '\'' +
                '}';
    }

    public String getNstatus() {
        return Nstatus;
    }

    public void setNstatus(String nstatus) {
        Nstatus = nstatus;
    }

    public String getOname() {
        return Oname;
    }

    public void setOname(String oname) {
        Oname = oname;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
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
