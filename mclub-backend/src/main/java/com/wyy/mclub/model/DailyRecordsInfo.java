package com.wyy.mclub.model;

public class DailyRecordsInfo {
    private Integer seq;

    private String userid;

    private String recday;

    private String mstatus;

    private String love;

    private String ovulation;

    private String leucorrhea;

    private Double temperature;

    private Double weight;

    private String mood;

    private String habit;

    private String uncomfortable;

    private String diary;

    public Integer getSeq() {
        return seq;
    }

    public void setSeq(Integer seq) {
        this.seq = seq;
    }

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getRecday() {
        return recday;
    }

    public void setRecday(String recday) {
        this.recday = recday == null ? null : recday.trim();
    }

    public String getMstatus() {
        return mstatus;
    }

    public void setMstatus(String mstatus) {
        this.mstatus = mstatus == null ? null : mstatus.trim();
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love == null ? null : love.trim();
    }

    public String getOvulation() {
        return ovulation;
    }

    public void setOvulation(String ovulation) {
        this.ovulation = ovulation == null ? null : ovulation.trim();
    }

    public String getLeucorrhea() {
        return leucorrhea;
    }

    public void setLeucorrhea(String leucorrhea) {
        this.leucorrhea = leucorrhea == null ? null : leucorrhea.trim();
    }

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public String getMood() {
        return mood;
    }

    public void setMood(String mood) {
        this.mood = mood == null ? null : mood.trim();
    }

    public String getHabit() {
        return habit;
    }

    public void setHabit(String habit) {
        this.habit = habit == null ? null : habit.trim();
    }

    public String getUncomfortable() {
        return uncomfortable;
    }

    public void setUncomfortable(String uncomfortable) {
        this.uncomfortable = uncomfortable == null ? null : uncomfortable.trim();
    }

    public String getDiary() {
        return diary;
    }

    public void setDiary(String diary) {
        this.diary = diary == null ? null : diary.trim();
    }
}