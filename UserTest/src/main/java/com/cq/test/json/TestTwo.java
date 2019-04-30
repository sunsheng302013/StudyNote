package com.cq.test.json;

import java.io.Serializable;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class TestTwo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1052335044576108781L;

    /** */
    @JsonIgnore
    private Integer id;

    /** 人员ID */
    private Long userId;

    private Long testId;

    /** 假期类型 */
    private String vacationType;

    /** 假期类型 */
    private Long vacationTypeId;

    /** */
    private Integer overDate;

    /** 假期时间 */
    private Integer verifyDate;

    /** */
    @JsonIgnore
    private Date gmtCreate;

    /** */
    @JsonIgnore
    private Date gmtModified;

    /**
     * @return the testId
     */
    public Long getTestId() {
        return testId;
    }

    /**
     * @param testId
     *            要设置的 testId
     */
    public void setTestId(Long testId) {
        this.testId = testId;
    }

    /**
     * @return the vacationTypeId
     */
    public Long getVacationTypeId() {
        return vacationTypeId;
    }

    /**
     * @param vacationTypeId
     *            要设置的 vacationTypeId
     */
    public void setVacationTypeId(Long vacationTypeId) {
        this.vacationTypeId = vacationTypeId;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            要设置的 id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            要设置的 userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the vacationType
     */
    public String getVacationType() {
        return vacationType;
    }

    /**
     * @param vacationType
     *            要设置的 vacationType
     */
    public void setVacationType(String vacationType) {
        this.vacationType = vacationType;
    }

    /**
     * @return the overDate
     */
    public Integer getOverDate() {
        return overDate;
    }

    /**
     * @param overDate
     *            要设置的 overDate
     */
    public void setOverDate(Integer overDate) {
        this.overDate = overDate;
    }

    /**
     * @return the verifyDate
     */
    public Integer getVerifyDate() {
        return verifyDate;
    }

    /**
     * @param verifyDate
     *            要设置的 verifyDate
     */
    public void setVerifyDate(Integer verifyDate) {
        this.verifyDate = verifyDate;
    }

    /**
     * @return the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     *            要设置的 gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    /**
     * @return the gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     *            要设置的 gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public String toString() {
        return "CheckVacationDetail [id=" + id + ", userId=" + userId + ", vacationType=" + vacationType + ", overDate=" + overDate + ", verifyDate="
                + verifyDate + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }

}