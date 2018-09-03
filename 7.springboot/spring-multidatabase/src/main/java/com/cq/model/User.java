package com.cq.model;

import java.util.Date;

public class User {
    private Long userId;

    private String userName;

    private String password;

    private String email;

    private String mobile;

    private String realName;

    private Long mainDepartId;

    private String mainDepartName;

    private Integer positionId;

    private String positionName;

    private Long leaderDepartId;

    private String leaderDepartName;

    private Long leaderUserId;

    private String leaderUserName;

    private Integer leaderPositionId;

    private String leaderPositonName;

    private Date gmtCreate;

    private Date gmtModified;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public Long getMainDepartId() {
        return mainDepartId;
    }

    public void setMainDepartId(Long mainDepartId) {
        this.mainDepartId = mainDepartId;
    }

    public String getMainDepartName() {
        return mainDepartName;
    }

    public void setMainDepartName(String mainDepartName) {
        this.mainDepartName = mainDepartName == null ? null : mainDepartName.trim();
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public Long getLeaderDepartId() {
        return leaderDepartId;
    }

    public void setLeaderDepartId(Long leaderDepartId) {
        this.leaderDepartId = leaderDepartId;
    }

    public String getLeaderDepartName() {
        return leaderDepartName;
    }

    public void setLeaderDepartName(String leaderDepartName) {
        this.leaderDepartName = leaderDepartName == null ? null : leaderDepartName.trim();
    }

    public Long getLeaderUserId() {
        return leaderUserId;
    }

    public void setLeaderUserId(Long leaderUserId) {
        this.leaderUserId = leaderUserId;
    }

    public String getLeaderUserName() {
        return leaderUserName;
    }

    public void setLeaderUserName(String leaderUserName) {
        this.leaderUserName = leaderUserName == null ? null : leaderUserName.trim();
    }

    public Integer getLeaderPositionId() {
        return leaderPositionId;
    }

    public void setLeaderPositionId(Integer leaderPositionId) {
        this.leaderPositionId = leaderPositionId;
    }

    public String getLeaderPositonName() {
        return leaderPositonName;
    }

    public void setLeaderPositonName(String leaderPositonName) {
        this.leaderPositonName = leaderPositonName == null ? null : leaderPositonName.trim();
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