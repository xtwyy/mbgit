package com.wyy.mclub.model;

import java.util.Date;

public class MbasicDataInfo {
    private String userid;

    private String period;

    private Byte mdays;

    private Byte mcycle;

    private Date initime;

    private Date opttime;

    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid == null ? null : userid.trim();
    }

    public String getPeriod() {
        return period;
    }

    public void setPeriod(String period) {
        this.period = period == null ? null : period.trim();
    }

    public Byte getMdays() {
        return mdays;
    }

    public void setMdays(Byte mdays) {
        this.mdays = mdays;
    }

    public Byte getMcycle() {
        return mcycle;
    }

    public void setMcycle(Byte mcycle) {
        this.mcycle = mcycle;
    }

    public Date getInitime() {
        return initime;
    }

    public void setInitime(Date initime) {
        this.initime = initime;
    }

    public Date getOpttime() {
        return opttime;
    }

    public void setOpttime(Date opttime) {
        this.opttime = opttime;
    }
}