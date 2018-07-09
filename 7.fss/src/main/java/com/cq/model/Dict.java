package com.cq.model;

import java.util.Date;

public class Dict {
    private Integer dictId;

    private Integer bossLoginId;

    private String dictName;

    private String dictDesc;

    private Boolean dictType;

    private Boolean isExist;

    private Date gmtCreate;

    private Date gmtModified;

    private Integer dictNum;

    private Integer dictMoney;

    public Integer getDictId() {
        return dictId;
    }

    public void setDictId(Integer dictId) {
        this.dictId = dictId;
    }

    public Integer getBossLoginId() {
        return bossLoginId;
    }

    public void setBossLoginId(Integer bossLoginId) {
        this.bossLoginId = bossLoginId;
    }

    public String getDictName() {
        return dictName;
    }

    public void setDictName(String dictName) {
        this.dictName = dictName == null ? null : dictName.trim();
    }

    public String getDictDesc() {
        return dictDesc;
    }

    public void setDictDesc(String dictDesc) {
        this.dictDesc = dictDesc == null ? null : dictDesc.trim();
    }

    public Boolean getDictType() {
        return dictType;
    }

    public void setDictType(Boolean dictType) {
        this.dictType = dictType;
    }

    public Boolean getIsExist() {
        return isExist;
    }

    public void setIsExist(Boolean isExist) {
        this.isExist = isExist;
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

    public Integer getDictNum() {
        return dictNum;
    }

    public void setDictNum(Integer dictNum) {
        this.dictNum = dictNum;
    }

    public Integer getDictMoney() {
        return dictMoney;
    }

    public void setDictMoney(Integer dictMoney) {
        this.dictMoney = dictMoney;
    }
}