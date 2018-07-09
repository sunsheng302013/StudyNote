package com.cq.model;

import java.util.Date;

public class Boss {
    private Integer id;

    private String bossLoginId;

    private String bossName;

    private String bossPwd;

    private String bossEmail;

    private Boolean bossRole;

    private Integer bossMoney;

    private Boolean isStatus;

    private Date gmtCreate;

    private Date gmtModified;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBossLoginId() {
        return bossLoginId;
    }

    public void setBossLoginId(String bossLoginId) {
        this.bossLoginId = bossLoginId == null ? null : bossLoginId.trim();
    }

    public String getBossName() {
        return bossName;
    }

    public void setBossName(String bossName) {
        this.bossName = bossName == null ? null : bossName.trim();
    }

    public String getBossPwd() {
        return bossPwd;
    }

    public void setBossPwd(String bossPwd) {
        this.bossPwd = bossPwd == null ? null : bossPwd.trim();
    }

    public String getBossEmail() {
        return bossEmail;
    }

    public void setBossEmail(String bossEmail) {
        this.bossEmail = bossEmail == null ? null : bossEmail.trim();
    }

    public Boolean getBossRole() {
        return bossRole;
    }

    public void setBossRole(Boolean bossRole) {
        this.bossRole = bossRole;
    }

    public Integer getBossMoney() {
        return bossMoney;
    }

    public void setBossMoney(Integer bossMoney) {
        this.bossMoney = bossMoney;
    }

    public Boolean getIsStatus() {
        return isStatus;
    }

    public void setIsStatus(Boolean isStatus) {
        this.isStatus = isStatus;
    }

    public Date getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public Date getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }
}