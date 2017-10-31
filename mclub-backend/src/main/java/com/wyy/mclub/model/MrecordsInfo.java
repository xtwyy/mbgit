package com.wyy.mclub.model;

import java.util.Date;

public class MrecordsInfo {
    private Integer seq;

    private String userid;

    private Date oprtime;

    private Date startday;

    private Date endday;

    private Date ovulationday;

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

    public Date getOprtime() {
        return oprtime;
    }

    public void setOprtime(Date oprtime) {
        this.oprtime = oprtime;
    }

    public Date getStartday() {
        return startday;
    }

    public void setStartday(Date startday) {
        this.startday = startday;
    }

    public Date getEndday() {
        return endday;
    }

    public void setEndday(Date endday) {
        this.endday = endday;
    }

    public Date getOvulationday() {
        return ovulationday;
    }

    public void setOvulationday(Date ovulationday) {
        this.ovulationday = ovulationday;
    }
}