/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月21日
 * @author chengq
 */
public class UserVacationDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1312730106943911354L;

    private Long userId;

    private String userName;

    private String userCode;

    private String departName;

    private String companyName;

    private Date entryDate;

    private Integer entryAge;

    private String overTimeTotal;

    private String overTimeUsered;

    private String overTimeUserAble;

    Map<String, String> vacationList;

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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            要设置的 userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * @return the userCode
     */
    public String getUserCode() {
        return userCode;
    }

    /**
     * @param userCode
     *            要设置的 userCode
     */
    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    /**
     * @return the departName
     */
    public String getDepartName() {
        return departName;
    }

    /**
     * @param departName
     *            要设置的 departName
     */
    public void setDepartName(String departName) {
        this.departName = departName;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     *            要设置的 companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the entryDate
     */
    public Date getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate
     *            要设置的 entryDate
     */
    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @return the entryAge
     */
    public Integer getEntryAge() {
        return entryAge;
    }

    /**
     * @param entryAge
     *            要设置的 entryAge
     */
    public void setEntryAge(Integer entryAge) {
        this.entryAge = entryAge;
    }

    /**
     * @return the overTimeTotal
     */
    public String getOverTimeTotal() {
        return overTimeTotal;
    }

    /**
     * @param overTimeTotal
     *            要设置的 overTimeTotal
     */
    public void setOverTimeTotal(String overTimeTotal) {
        this.overTimeTotal = overTimeTotal;
    }

    /**
     * @return the overTimeUsered
     */
    public String getOverTimeUsered() {
        return overTimeUsered;
    }

    /**
     * @param overTimeUsered
     *            要设置的 overTimeUsered
     */
    public void setOverTimeUsered(String overTimeUsered) {
        this.overTimeUsered = overTimeUsered;
    }

    /**
     * @return the overTimeUserAble
     */
    public String getOverTimeUserAble() {
        return overTimeUserAble;
    }

    /**
     * @param overTimeUserAble
     *            要设置的 overTimeUserAble
     */
    public void setOverTimeUserAble(String overTimeUserAble) {
        this.overTimeUserAble = overTimeUserAble;
    }

    /**
     * @return the vacationList
     */
    public Map<String, String> getVacationList() {
        return vacationList;
    }

    /**
     * @param vacationList
     *            要设置的 vacationList
     */
    public void setVacationList(Map<String, String> vacationList) {
        this.vacationList = vacationList;
    }

    @Override
    public String toString() {
        return "UserVacationDTO [userId=" + userId + ", userName=" + userName + ", userCode=" + userCode + ", departName=" + departName + ", companyName="
                + companyName + ", entryDate=" + entryDate + ", entryAge=" + entryAge + ", overTimeTotal=" + overTimeTotal + ", overTimeUsered="
                + overTimeUsered + ", overTimeUserAble=" + overTimeUserAble + ", vacationList=" + vacationList + "]";
    }

}
