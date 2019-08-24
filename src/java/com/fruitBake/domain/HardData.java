package com.fruitBake.domain;

public class HardData {

    private String MAC;

    private String mean;

    private Integer noteId;

    private String startTime;

    private String endTime;

    public HardData() {
    }

    public HardData(String MAC, String mean) {
        this.MAC = MAC;
        this.mean = mean;
    }

    public String getMAC() {
        return MAC;
    }

    public void setMAC(String MAC) {
        this.MAC = MAC;
    }

    public String getMean() {
        return mean;
    }

    public void setMean(String mean) {
        this.mean = mean;
    }

    public Integer getNoteId() {
        return noteId;
    }

    public void setNoteId(Integer noteId) {
        this.noteId = noteId;
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
}
