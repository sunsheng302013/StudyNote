/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月13日
 * @author chengq
 */
public class UserTransferResultDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -9040468164807974459L;

    /** 人员档案id */
    private Long userId;

    /** 人员姓名 */
    private String userName;

    /** erp人员ID **/
    private Long erpUserId;

    /** 员工编号 */
    private String userNo;

    /** 出生日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date birthdate;

    /** 性别默认0 男0、女1 */
    private Integer sex;

    /** 所属公司ID */
    private Long companyId;

    /** 所属公司名称 */
    private String companyName;

    /** 所属主部门ID **/
    private Long mainDepartId;

    /** 所属主部门名称 **/
    private String mainDepartName;

    /** 班组ID */
    private Long classId;

    /** 班组名称 */
    private String className;

    /** 职位 **/
    private List<ReinstatementUserPositionDTO> positionList;

    /** 任职类型 全职0、兼职1、实习2 **/
    private Integer jobCategory;

    /** 人员类别 正式工0、合同工1、临时工2、退休返聘3、劳务派遣4 **/
    private Integer userCategory;

    /** 人员状态 0在职 1不在职 2停职 3离职 4退休 5借调 **/
    private Integer userStatus;

    /** 入职日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date entryDate;

    /** 试用期(月) */
    private Integer probationaryPeriod;

    /** 延迟转正(天) */
    private Integer delayDay;

    /** 预期转正日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date estimateRegularDate;

    /** 到期天数 **/
    private Integer maturityDay;

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
     * @return the erpUserId
     */
    public Long getErpUserId() {
        return erpUserId;
    }

    /**
     * @param erpUserId
     *            要设置的 erpUserId
     */
    public void setErpUserId(Long erpUserId) {
        this.erpUserId = erpUserId;
    }

    /**
     * @return the userNo
     */
    public String getUserNo() {
        return userNo;
    }

    /**
     * @param userNo
     *            要设置的 userNo
     */
    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate
     *            要设置的 birthdate
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     *            要设置的 sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     *            要设置的 companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
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
     * @return the mainDepartId
     */
    public Long getMainDepartId() {
        return mainDepartId;
    }

    /**
     * @param mainDepartId
     *            要设置的 mainDepartId
     */
    public void setMainDepartId(Long mainDepartId) {
        this.mainDepartId = mainDepartId;
    }

    /**
     * @return the mainDepartName
     */
    public String getMainDepartName() {
        return mainDepartName;
    }

    /**
     * @param mainDepartName
     *            要设置的 mainDepartName
     */
    public void setMainDepartName(String mainDepartName) {
        this.mainDepartName = mainDepartName;
    }

    /**
     * @return the classId
     */
    public Long getClassId() {
        return classId;
    }

    /**
     * @param classId
     *            要设置的 classId
     */
    public void setClassId(Long classId) {
        this.classId = classId;
    }

    /**
     * @return the className
     */
    public String getClassName() {
        return className;
    }

    /**
     * @param className
     *            要设置的 className
     */
    public void setClassName(String className) {
        this.className = className;
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
     * @return the probationaryPeriod
     */
    public Integer getProbationaryPeriod() {
        return probationaryPeriod;
    }

    /**
     * @param probationaryPeriod
     *            要设置的 probationaryPeriod
     */
    public void setProbationaryPeriod(Integer probationaryPeriod) {
        this.probationaryPeriod = probationaryPeriod;
    }

    /**
     * @return the delayDay
     */
    public Integer getDelayDay() {
        return delayDay;
    }

    /**
     * @param delayDay
     *            要设置的 delayDay
     */
    public void setDelayDay(Integer delayDay) {
        this.delayDay = delayDay;
    }

    /**
     * @return the estimateRegularDate
     */
    public Date getEstimateRegularDate() {
        return estimateRegularDate;
    }

    /**
     * @param estimateRegularDate
     *            要设置的 estimateRegularDate
     */
    public void setEstimateRegularDate(Date estimateRegularDate) {
        this.estimateRegularDate = estimateRegularDate;
    }

    /**
     * @return the maturityDay
     */
    public Integer getMaturityDay() {
        return maturityDay;
    }

    /**
     * @param maturityDay
     *            要设置的 maturityDay
     */
    public void setMaturityDay(Integer maturityDay) {
        this.maturityDay = maturityDay;
    }

    /**
     * @return the positionList
     */
    public List<ReinstatementUserPositionDTO> getPositionList() {
        return positionList;
    }

    /**
     * @param positionList
     *            要设置的 positionList
     */
    public void setPositionList(List<ReinstatementUserPositionDTO> positionList) {
        this.positionList = positionList;
    }

    /**
     * @return the jobCategory
     */
    public Integer getJobCategory() {
        return jobCategory;
    }

    /**
     * @param jobCategory
     *            要设置的 jobCategory
     */
    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    /**
     * @return the userCategory
     */
    public Integer getUserCategory() {
        return userCategory;
    }

    /**
     * @param userCategory
     *            要设置的 userCategory
     */
    public void setUserCategory(Integer userCategory) {
        this.userCategory = userCategory;
    }

    /**
     * @return the userStatus
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     *            要设置的 userStatus
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

}
