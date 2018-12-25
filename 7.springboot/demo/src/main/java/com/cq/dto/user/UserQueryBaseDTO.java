/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

import com.cq.common.annotation.DbTable;

/**
 * <p>
 * 类描述:人员资料表头查询-显示列字段表头查询
 * </p>
 *
 * @since 2018年10月30日
 * @author chengq
 */
public class UserQueryBaseDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8244842908629450501L;

    /** 主键ID */
    private Integer id;

    /** 左侧过滤-新增类型 今日新增0，昨日新增1，本周新增2， 本月新增3 **/
    private Integer addType;

    /** 人员档案id */
    private Long userId;
    private List<Long> userIds;
    private List<Long> userIdList;

    /** erp用户id */
    private String erpUserId;

    /** 员工编号 */
    private String userNo;
    private String userNoLike;

    /** 人员姓名 */
    private String userName;
    private String userNameLike;

    /** 花名/英文名 */
    private String englishName;
    private String englishNameLike;

    /** 证件号 */
    private String idCardNo;
    private String idCardNoLike;

    /** 出生日期 */
    private String birthdate;
    private String birthdateEquals;
    private String birthdateGte;
    private String birthdateLte;
    private String birthdateGt;
    private String birthdateLt;

    /** 性别默认0 男0、女1 */
    private String sex;
    private String sexIn;

    /** 工号（系统账号） */
    private String userCode;
    private String userCodeLike;

    /** 所属公司ID */
    private String companyId;
    private String companyIdIn;

    /** 所属公司名称 */
    private String companyName;
    private String companyNameLike;

    /** 所属部门ID */
    private String departId;
    private String departIdIn;

    /** 所属部门名称 */
    private String departName;
    private String departNameLike;

    /** 班组ID */
    private String classId;
    private String classIdIn;

    /** 班组名称 */
    private String className;
    private String classNameLike;

    /** 入职日期 */
    private String entryDate;
    private String entryDateEquals;
    private String entryDateGte;
    private String entryDateLte;
    private String entryDateGt;
    private String entryDateLt;

    /** 试用期(月) */
    private String probationaryPeriod;
    private String probationaryPeriodEquals;
    private String probationaryPeriodGte;
    private String probationaryPeriodLte;
    private String probationaryPeriodGt;
    private String probationaryPeriodLt;

    /** 延迟转正(天) */
    private String delayDay;
    private String delayDayEquals;
    private String delayDayGte;
    private String delayDayLte;
    private String delayDayGt;
    private String delayDayLt;

    /** 转正日期 */
    private String regularDate;
    private String regularDateEquals;
    private String regularDateGte;
    private String regularDateLte;
    private String regularDateGt;
    private String regularDateLt;

    /** 是否在编 0不在编 1在编 */
    private String isOrganised;
    private String isOrganIsedIn;

    /** 离职日期 */
    private String leaveDate;
    private String leaveDateEquals;
    private String leaveDateGte;
    private String leaveDateLte;
    private String leaveDateGt;
    private String leaveDateLt;

    /** 直属上级 **/
    @DbTable(name = "j_oa_user_leader_info")
    private String parentPosition;
    @DbTable(name = "j_oa_user_leader_info")
    private String parentPositionLike;

    /** 直属下级 **/
    @DbTable(name = "j_oa_user_leader_info")
    private String subPosition;
    @DbTable(name = "j_oa_user_leader_info")
    private String subPositionLike;

    /** 任职类型 默认0 全职0、兼职1、实习2 */
    private String jobCategory;
    private String jobCategoryIn;

    /** 人员类别 默认0 正式工0、合同工1、临时工2、退休返聘3、劳务派遣4 */
    private String userCategory;
    private String userCategoryIn;

    /** 人员状态 0在职 1不在职 2停职 3离职 4退休 5借调 */
    private String userStatus;
    private String userStatusIn;

    /** 户口地址 */
    private String accountAddress;
    private String accountAddressLike;

    /** 籍贯 */
    private String birthPlace;
    private String birthPlaceLike;

    /** 技能特长id */
    @DbTable(name = "j_oa_user_special")
    private String specialId;
    @DbTable(name = "j_oa_user_special")
    private String specialIdIn;

    /** 手机号码 */
    private String phone;
    private String phoneLike;

    /** QQ号 */
    private String qq;
    private String qqLike;

    /** 办公号码 */
    private String officePhone;
    private String officePhoneLike;

    /** 邮箱 */
    private String mail;
    private String mailLike;

    /** 最高学历 **/
    @DbTable(name = "j_oa_user_education_info")
    private String educationLevel;
    @DbTable(name = "j_oa_user_education_info")
    private String educationLevelIn;

    /** 专业 **/
    @DbTable(name = "j_oa_user_education_info")
    private String major;
    @DbTable(name = "j_oa_user_education_info")
    private String majorLike;

    /** 学校 **/
    @DbTable(name = "j_oa_user_education_info")
    private String school;
    @DbTable(name = "j_oa_user_education_info")
    private String schoolLike;

    /** 毕业时间 **/
    @DbTable(name = "j_oa_user_education_info")
    private String endDate;
    @DbTable(name = "j_oa_user_education_info")
    private String endDateEquals;
    @DbTable(name = "j_oa_user_education_info")
    private String endDateGte;
    @DbTable(name = "j_oa_user_education_info")
    private String endDateLte;
    @DbTable(name = "j_oa_user_education_info")
    private String endDateGt;
    @DbTable(name = "j_oa_user_education_info")
    private String endDateLt;

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
     * @return the addType
     */
    public Integer getAddType() {
        return addType;
    }

    /**
     * @param addType
     *            要设置的 addType
     */
    public void setAddType(Integer addType) {
        this.addType = addType;
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
     * @return the userIds
     */
    public List<Long> getUserIds() {
        return userIds;
    }

    /**
     * @param userIds
     *            要设置的 userIds
     */
    public void setUserIds(List<Long> userIds) {
        this.userIds = userIds;
    }

    /**
     * @return the userIdList
     */
    public List<Long> getUserIdList() {
        return userIdList;
    }

    /**
     * @param userIdList
     *            要设置的 userIdList
     */
    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

    /**
     * @return the erpUserId
     */
    public String getErpUserId() {
        return erpUserId;
    }

    /**
     * @param erpUserId
     *            要设置的 erpUserId
     */
    public void setErpUserId(String erpUserId) {
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
     * @return the userNoLike
     */
    public String getUserNoLike() {
        return userNoLike;
    }

    /**
     * @param userNoLike
     *            要设置的 userNoLike
     */
    public void setUserNoLike(String userNoLike) {
        this.userNoLike = userNoLike;
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
     * @return the userNameLike
     */
    public String getUserNameLike() {
        return userNameLike;
    }

    /**
     * @param userNameLike
     *            要设置的 userNameLike
     */
    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }

    /**
     * @return the englishName
     */
    public String getEnglishName() {
        return englishName;
    }

    /**
     * @param englishName
     *            要设置的 englishName
     */
    public void setEnglishName(String englishName) {
        this.englishName = englishName;
    }

    /**
     * @return the englishNameLike
     */
    public String getEnglishNameLike() {
        return englishNameLike;
    }

    /**
     * @param englishNameLike
     *            要设置的 englishNameLike
     */
    public void setEnglishNameLike(String englishNameLike) {
        this.englishNameLike = englishNameLike;
    }

    /**
     * @return the idCardNo
     */
    public String getIdCardNo() {
        return idCardNo;
    }

    /**
     * @param idCardNo
     *            要设置的 idCardNo
     */
    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    /**
     * @return the idCardNoLike
     */
    public String getIdCardNoLike() {
        return idCardNoLike;
    }

    /**
     * @param idCardNoLike
     *            要设置的 idCardNoLike
     */
    public void setIdCardNoLike(String idCardNoLike) {
        this.idCardNoLike = idCardNoLike;
    }

    /**
     * @return the birthdate
     */
    public String getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate
     *            要设置的 birthdate
     */
    public void setBirthdate(String birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the birthdateEquals
     */
    public String getBirthdateEquals() {
        return birthdateEquals;
    }

    /**
     * @param birthdateEquals
     *            要设置的 birthdateEquals
     */
    public void setBirthdateEquals(String birthdateEquals) {
        this.birthdateEquals = birthdateEquals;
    }

    /**
     * @return the birthdateGte
     */
    public String getBirthdateGte() {
        return birthdateGte;
    }

    /**
     * @param birthdateGte
     *            要设置的 birthdateGte
     */
    public void setBirthdateGte(String birthdateGte) {
        this.birthdateGte = birthdateGte;
    }

    /**
     * @return the birthdateLte
     */
    public String getBirthdateLte() {
        return birthdateLte;
    }

    /**
     * @param birthdateLte
     *            要设置的 birthdateLte
     */
    public void setBirthdateLte(String birthdateLte) {
        this.birthdateLte = birthdateLte;
    }

    /**
     * @return the birthdateGt
     */
    public String getBirthdateGt() {
        return birthdateGt;
    }

    /**
     * @param birthdateGt
     *            要设置的 birthdateGt
     */
    public void setBirthdateGt(String birthdateGt) {
        this.birthdateGt = birthdateGt;
    }

    /**
     * @return the birthdateLt
     */
    public String getBirthdateLt() {
        return birthdateLt;
    }

    /**
     * @param birthdateLt
     *            要设置的 birthdateLt
     */
    public void setBirthdateLt(String birthdateLt) {
        this.birthdateLt = birthdateLt;
    }

    /**
     * @return the sex
     */
    public String getSex() {
        return sex;
    }

    /**
     * @param sex
     *            要设置的 sex
     */
    public void setSex(String sex) {
        this.sex = sex;
    }

    /**
     * @return the sexIn
     */
    public String getSexIn() {
        return sexIn;
    }

    /**
     * @param sexIn
     *            要设置的 sexIn
     */
    public void setSexIn(String sexIn) {
        this.sexIn = sexIn;
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
     * @return the userCodeLike
     */
    public String getUserCodeLike() {
        return userCodeLike;
    }

    /**
     * @param userCodeLike
     *            要设置的 userCodeLike
     */
    public void setUserCodeLike(String userCodeLike) {
        this.userCodeLike = userCodeLike;
    }

    /**
     * @return the companyId
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     *            要设置的 companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the companyIdIn
     */
    public String getCompanyIdIn() {
        return companyIdIn;
    }

    /**
     * @param companyIdIn
     *            要设置的 companyIdIn
     */
    public void setCompanyIdIn(String companyIdIn) {
        this.companyIdIn = companyIdIn;
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
     * @return the companyNameLike
     */
    public String getCompanyNameLike() {
        return companyNameLike;
    }

    /**
     * @param companyNameLike
     *            要设置的 companyNameLike
     */
    public void setCompanyNameLike(String companyNameLike) {
        this.companyNameLike = companyNameLike;
    }

    /**
     * @return the departId
     */
    public String getDepartId() {
        return departId;
    }

    /**
     * @param departId
     *            要设置的 departId
     */
    public void setDepartId(String departId) {
        this.departId = departId;
    }

    /**
     * @return the departIdIn
     */
    public String getDepartIdIn() {
        return departIdIn;
    }

    /**
     * @param departIdIn
     *            要设置的 departIdIn
     */
    public void setDepartIdIn(String departIdIn) {
        this.departIdIn = departIdIn;
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
     * @return the departNameLike
     */
    public String getDepartNameLike() {
        return departNameLike;
    }

    /**
     * @param departNameLike
     *            要设置的 departNameLike
     */
    public void setDepartNameLike(String departNameLike) {
        this.departNameLike = departNameLike;
    }

    /**
     * @return the classId
     */
    public String getClassId() {
        return classId;
    }

    /**
     * @param classId
     *            要设置的 classId
     */
    public void setClassId(String classId) {
        this.classId = classId;
    }

    /**
     * @return the classIdIn
     */
    public String getClassIdIn() {
        return classIdIn;
    }

    /**
     * @param classIdIn
     *            要设置的 classIdIn
     */
    public void setClassIdIn(String classIdIn) {
        this.classIdIn = classIdIn;
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
     * @return the classNameLike
     */
    public String getClassNameLike() {
        return classNameLike;
    }

    /**
     * @param classNameLike
     *            要设置的 classNameLike
     */
    public void setClassNameLike(String classNameLike) {
        this.classNameLike = classNameLike;
    }

    /**
     * @return the entryDate
     */
    public String getEntryDate() {
        return entryDate;
    }

    /**
     * @param entryDate
     *            要设置的 entryDate
     */
    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    /**
     * @return the entryDateEquals
     */
    public String getEntryDateEquals() {
        return entryDateEquals;
    }

    /**
     * @param entryDateEquals
     *            要设置的 entryDateEquals
     */
    public void setEntryDateEquals(String entryDateEquals) {
        this.entryDateEquals = entryDateEquals;
    }

    /**
     * @return the entryDateGte
     */
    public String getEntryDateGte() {
        return entryDateGte;
    }

    /**
     * @param entryDateGte
     *            要设置的 entryDateGte
     */
    public void setEntryDateGte(String entryDateGte) {
        this.entryDateGte = entryDateGte;
    }

    /**
     * @return the entryDateLte
     */
    public String getEntryDateLte() {
        return entryDateLte;
    }

    /**
     * @param entryDateLte
     *            要设置的 entryDateLte
     */
    public void setEntryDateLte(String entryDateLte) {
        this.entryDateLte = entryDateLte;
    }

    /**
     * @return the entryDateGt
     */
    public String getEntryDateGt() {
        return entryDateGt;
    }

    /**
     * @param entryDateGt
     *            要设置的 entryDateGt
     */
    public void setEntryDateGt(String entryDateGt) {
        this.entryDateGt = entryDateGt;
    }

    /**
     * @return the entryDateLt
     */
    public String getEntryDateLt() {
        return entryDateLt;
    }

    /**
     * @param entryDateLt
     *            要设置的 entryDateLt
     */
    public void setEntryDateLt(String entryDateLt) {
        this.entryDateLt = entryDateLt;
    }

    /**
     * @return the probationaryPeriod
     */
    public String getProbationaryPeriod() {
        return probationaryPeriod;
    }

    /**
     * @param probationaryPeriod
     *            要设置的 probationaryPeriod
     */
    public void setProbationaryPeriod(String probationaryPeriod) {
        this.probationaryPeriod = probationaryPeriod;
    }

    /**
     * @return the probationaryPeriodEquals
     */
    public String getProbationaryPeriodEquals() {
        return probationaryPeriodEquals;
    }

    /**
     * @param probationaryPeriodEquals
     *            要设置的 probationaryPeriodEquals
     */
    public void setProbationaryPeriodEquals(String probationaryPeriodEquals) {
        this.probationaryPeriodEquals = probationaryPeriodEquals;
    }

    /**
     * @return the probationaryPeriodGte
     */
    public String getProbationaryPeriodGte() {
        return probationaryPeriodGte;
    }

    /**
     * @param probationaryPeriodGte
     *            要设置的 probationaryPeriodGte
     */
    public void setProbationaryPeriodGte(String probationaryPeriodGte) {
        this.probationaryPeriodGte = probationaryPeriodGte;
    }

    /**
     * @return the probationaryPeriodLte
     */
    public String getProbationaryPeriodLte() {
        return probationaryPeriodLte;
    }

    /**
     * @param probationaryPeriodLte
     *            要设置的 probationaryPeriodLte
     */
    public void setProbationaryPeriodLte(String probationaryPeriodLte) {
        this.probationaryPeriodLte = probationaryPeriodLte;
    }

    /**
     * @return the probationaryPeriodGt
     */
    public String getProbationaryPeriodGt() {
        return probationaryPeriodGt;
    }

    /**
     * @param probationaryPeriodGt
     *            要设置的 probationaryPeriodGt
     */
    public void setProbationaryPeriodGt(String probationaryPeriodGt) {
        this.probationaryPeriodGt = probationaryPeriodGt;
    }

    /**
     * @return the probationaryPeriodLt
     */
    public String getProbationaryPeriodLt() {
        return probationaryPeriodLt;
    }

    /**
     * @param probationaryPeriodLt
     *            要设置的 probationaryPeriodLt
     */
    public void setProbationaryPeriodLt(String probationaryPeriodLt) {
        this.probationaryPeriodLt = probationaryPeriodLt;
    }

    /**
     * @return the delayDay
     */
    public String getDelayDay() {
        return delayDay;
    }

    /**
     * @param delayDay
     *            要设置的 delayDay
     */
    public void setDelayDay(String delayDay) {
        this.delayDay = delayDay;
    }

    /**
     * @return the delayDayEquals
     */
    public String getDelayDayEquals() {
        return delayDayEquals;
    }

    /**
     * @param delayDayEquals
     *            要设置的 delayDayEquals
     */
    public void setDelayDayEquals(String delayDayEquals) {
        this.delayDayEquals = delayDayEquals;
    }

    /**
     * @return the delayDayGte
     */
    public String getDelayDayGte() {
        return delayDayGte;
    }

    /**
     * @param delayDayGte
     *            要设置的 delayDayGte
     */
    public void setDelayDayGte(String delayDayGte) {
        this.delayDayGte = delayDayGte;
    }

    /**
     * @return the delayDayLte
     */
    public String getDelayDayLte() {
        return delayDayLte;
    }

    /**
     * @param delayDayLte
     *            要设置的 delayDayLte
     */
    public void setDelayDayLte(String delayDayLte) {
        this.delayDayLte = delayDayLte;
    }

    /**
     * @return the delayDayGt
     */
    public String getDelayDayGt() {
        return delayDayGt;
    }

    /**
     * @param delayDayGt
     *            要设置的 delayDayGt
     */
    public void setDelayDayGt(String delayDayGt) {
        this.delayDayGt = delayDayGt;
    }

    /**
     * @return the delayDayLt
     */
    public String getDelayDayLt() {
        return delayDayLt;
    }

    /**
     * @param delayDayLt
     *            要设置的 delayDayLt
     */
    public void setDelayDayLt(String delayDayLt) {
        this.delayDayLt = delayDayLt;
    }

    /**
     * @return the regularDate
     */
    public String getRegularDate() {
        return regularDate;
    }

    /**
     * @param regularDate
     *            要设置的 regularDate
     */
    public void setRegularDate(String regularDate) {
        this.regularDate = regularDate;
    }

    /**
     * @return the regularDateEquals
     */
    public String getRegularDateEquals() {
        return regularDateEquals;
    }

    /**
     * @param regularDateEquals
     *            要设置的 regularDateEquals
     */
    public void setRegularDateEquals(String regularDateEquals) {
        this.regularDateEquals = regularDateEquals;
    }

    /**
     * @return the regularDateGte
     */
    public String getRegularDateGte() {
        return regularDateGte;
    }

    /**
     * @param regularDateGte
     *            要设置的 regularDateGte
     */
    public void setRegularDateGte(String regularDateGte) {
        this.regularDateGte = regularDateGte;
    }

    /**
     * @return the regularDateLte
     */
    public String getRegularDateLte() {
        return regularDateLte;
    }

    /**
     * @param regularDateLte
     *            要设置的 regularDateLte
     */
    public void setRegularDateLte(String regularDateLte) {
        this.regularDateLte = regularDateLte;
    }

    /**
     * @return the regularDateGt
     */
    public String getRegularDateGt() {
        return regularDateGt;
    }

    /**
     * @param regularDateGt
     *            要设置的 regularDateGt
     */
    public void setRegularDateGt(String regularDateGt) {
        this.regularDateGt = regularDateGt;
    }

    /**
     * @return the regularDateLt
     */
    public String getRegularDateLt() {
        return regularDateLt;
    }

    /**
     * @param regularDateLt
     *            要设置的 regularDateLt
     */
    public void setRegularDateLt(String regularDateLt) {
        this.regularDateLt = regularDateLt;
    }

    /**
     * @return the isOrganised
     */
    public String getIsOrganised() {
        return isOrganised;
    }

    /**
     * @param isOrganised
     *            要设置的 isOrganised
     */
    public void setIsOrganised(String isOrganised) {
        this.isOrganised = isOrganised;
    }

    /**
     * @return the isOrganIsedIn
     */
    public String getIsOrganIsedIn() {
        return isOrganIsedIn;
    }

    /**
     * @param isOrganIsedIn
     *            要设置的 isOrganIsedIn
     */
    public void setIsOrganIsedIn(String isOrganIsedIn) {
        this.isOrganIsedIn = isOrganIsedIn;
    }

    /**
     * @return the leaveDate
     */
    public String getLeaveDate() {
        return leaveDate;
    }

    /**
     * @param leaveDate
     *            要设置的 leaveDate
     */
    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    /**
     * @return the leaveDateEquals
     */
    public String getLeaveDateEquals() {
        return leaveDateEquals;
    }

    /**
     * @param leaveDateEquals
     *            要设置的 leaveDateEquals
     */
    public void setLeaveDateEquals(String leaveDateEquals) {
        this.leaveDateEquals = leaveDateEquals;
    }

    /**
     * @return the leaveDateGte
     */
    public String getLeaveDateGte() {
        return leaveDateGte;
    }

    /**
     * @param leaveDateGte
     *            要设置的 leaveDateGte
     */
    public void setLeaveDateGte(String leaveDateGte) {
        this.leaveDateGte = leaveDateGte;
    }

    /**
     * @return the leaveDateLte
     */
    public String getLeaveDateLte() {
        return leaveDateLte;
    }

    /**
     * @param leaveDateLte
     *            要设置的 leaveDateLte
     */
    public void setLeaveDateLte(String leaveDateLte) {
        this.leaveDateLte = leaveDateLte;
    }

    /**
     * @return the leaveDateGt
     */
    public String getLeaveDateGt() {
        return leaveDateGt;
    }

    /**
     * @param leaveDateGt
     *            要设置的 leaveDateGt
     */
    public void setLeaveDateGt(String leaveDateGt) {
        this.leaveDateGt = leaveDateGt;
    }

    /**
     * @return the leaveDateLt
     */
    public String getLeaveDateLt() {
        return leaveDateLt;
    }

    /**
     * @param leaveDateLt
     *            要设置的 leaveDateLt
     */
    public void setLeaveDateLt(String leaveDateLt) {
        this.leaveDateLt = leaveDateLt;
    }

    /**
     * @return the parentPosition
     */
    public String getParentPosition() {
        return parentPosition;
    }

    /**
     * @param parentPosition
     *            要设置的 parentPosition
     */
    public void setParentPosition(String parentPosition) {
        this.parentPosition = parentPosition;
    }

    /**
     * @return the parentPositionLike
     */
    public String getParentPositionLike() {
        return parentPositionLike;
    }

    /**
     * @param parentPositionLike
     *            要设置的 parentPositionLike
     */
    public void setParentPositionLike(String parentPositionLike) {
        this.parentPositionLike = parentPositionLike;
    }

    /**
     * @return the subPosition
     */
    public String getSubPosition() {
        return subPosition;
    }

    /**
     * @param subPosition
     *            要设置的 subPosition
     */
    public void setSubPosition(String subPosition) {
        this.subPosition = subPosition;
    }

    /**
     * @return the subPositionLike
     */
    public String getSubPositionLike() {
        return subPositionLike;
    }

    /**
     * @param subPositionLike
     *            要设置的 subPositionLike
     */
    public void setSubPositionLike(String subPositionLike) {
        this.subPositionLike = subPositionLike;
    }

    /**
     * @return the jobCategory
     */
    public String getJobCategory() {
        return jobCategory;
    }

    /**
     * @param jobCategory
     *            要设置的 jobCategory
     */
    public void setJobCategory(String jobCategory) {
        this.jobCategory = jobCategory;
    }

    /**
     * @return the userCategory
     */
    public String getUserCategory() {
        return userCategory;
    }

    /**
     * @param userCategory
     *            要设置的 userCategory
     */
    public void setUserCategory(String userCategory) {
        this.userCategory = userCategory;
    }

    /**
     * @return the userCategoryIn
     */
    public String getUserCategoryIn() {
        return userCategoryIn;
    }

    /**
     * @param userCategoryIn
     *            要设置的 userCategoryIn
     */
    public void setUserCategoryIn(String userCategoryIn) {
        this.userCategoryIn = userCategoryIn;
    }

    /**
     * @return the userStatus
     */
    public String getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     *            要设置的 userStatus
     */
    public void setUserStatus(String userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return the userStatusIn
     */
    public String getUserStatusIn() {
        return userStatusIn;
    }

    /**
     * @param userStatusIn
     *            要设置的 userStatusIn
     */
    public void setUserStatusIn(String userStatusIn) {
        this.userStatusIn = userStatusIn;
    }

    /**
     * @return the accountAddress
     */
    public String getAccountAddress() {
        return accountAddress;
    }

    /**
     * @param accountAddress
     *            要设置的 accountAddress
     */
    public void setAccountAddress(String accountAddress) {
        this.accountAddress = accountAddress;
    }

    /**
     * @return the accountAddressLike
     */
    public String getAccountAddressLike() {
        return accountAddressLike;
    }

    /**
     * @param accountAddressLike
     *            要设置的 accountAddressLike
     */
    public void setAccountAddressLike(String accountAddressLike) {
        this.accountAddressLike = accountAddressLike;
    }

    /**
     * @return the birthPlace
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * @param birthPlace
     *            要设置的 birthPlace
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * @return the birthPlaceLike
     */
    public String getBirthPlaceLike() {
        return birthPlaceLike;
    }

    /**
     * @param birthPlaceLike
     *            要设置的 birthPlaceLike
     */
    public void setBirthPlaceLike(String birthPlaceLike) {
        this.birthPlaceLike = birthPlaceLike;
    }

    /**
     * @return the phone
     */
    public String getPhone() {
        return phone;
    }

    /**
     * @param phone
     *            要设置的 phone
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * @return the phoneLike
     */
    public String getPhoneLike() {
        return phoneLike;
    }

    /**
     * @param phoneLike
     *            要设置的 phoneLike
     */
    public void setPhoneLike(String phoneLike) {
        this.phoneLike = phoneLike;
    }

    /**
     * @return the qq
     */
    public String getQq() {
        return qq;
    }

    /**
     * @param qq
     *            要设置的 qq
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * @return the qqLike
     */
    public String getQqLike() {
        return qqLike;
    }

    /**
     * @param qqLike
     *            要设置的 qqLike
     */
    public void setQqLike(String qqLike) {
        this.qqLike = qqLike;
    }

    /**
     * @return the officePhone
     */
    public String getOfficePhone() {
        return officePhone;
    }

    /**
     * @param officePhone
     *            要设置的 officePhone
     */
    public void setOfficePhone(String officePhone) {
        this.officePhone = officePhone;
    }

    /**
     * @return the officePhoneLike
     */
    public String getOfficePhoneLike() {
        return officePhoneLike;
    }

    /**
     * @param officePhoneLike
     *            要设置的 officePhoneLike
     */
    public void setOfficePhoneLike(String officePhoneLike) {
        this.officePhoneLike = officePhoneLike;
    }

    /**
     * @return the mail
     */
    public String getMail() {
        return mail;
    }

    /**
     * @param mail
     *            要设置的 mail
     */
    public void setMail(String mail) {
        this.mail = mail;
    }

    /**
     * @return the mailLike
     */
    public String getMailLike() {
        return mailLike;
    }

    /**
     * @param mailLike
     *            要设置的 mailLike
     */
    public void setMailLike(String mailLike) {
        this.mailLike = mailLike;
    }

    /**
     * @return the educationLevel
     */
    public String getEducationLevel() {
        return educationLevel;
    }

    /**
     * @param educationLevel
     *            要设置的 educationLevel
     */
    public void setEducationLevel(String educationLevel) {
        this.educationLevel = educationLevel;
    }

    /**
     * @return the educationLevelIn
     */
    public String getEducationLevelIn() {
        return educationLevelIn;
    }

    /**
     * @param educationLevelIn
     *            要设置的 educationLevelIn
     */
    public void setEducationLevelIn(String educationLevelIn) {
        this.educationLevelIn = educationLevelIn;
    }

    /**
     * @return the major
     */
    public String getMajor() {
        return major;
    }

    /**
     * @param major
     *            要设置的 major
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * @return the majorLike
     */
    public String getMajorLike() {
        return majorLike;
    }

    /**
     * @param majorLike
     *            要设置的 majorLike
     */
    public void setMajorLike(String majorLike) {
        this.majorLike = majorLike;
    }

    /**
     * @return the school
     */
    public String getSchool() {
        return school;
    }

    /**
     * @param school
     *            要设置的 school
     */
    public void setSchool(String school) {
        this.school = school;
    }

    /**
     * @return the schoolLike
     */
    public String getSchoolLike() {
        return schoolLike;
    }

    /**
     * @param schoolLike
     *            要设置的 schoolLike
     */
    public void setSchoolLike(String schoolLike) {
        this.schoolLike = schoolLike;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            要设置的 endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endDateEquals
     */
    public String getEndDateEquals() {
        return endDateEquals;
    }

    /**
     * @param endDateEquals
     *            要设置的 endDateEquals
     */
    public void setEndDateEquals(String endDateEquals) {
        this.endDateEquals = endDateEquals;
    }

    /**
     * @return the endDateGte
     */
    public String getEndDateGte() {
        return endDateGte;
    }

    /**
     * @param endDateGte
     *            要设置的 endDateGte
     */
    public void setEndDateGte(String endDateGte) {
        this.endDateGte = endDateGte;
    }

    /**
     * @return the endDateLte
     */
    public String getEndDateLte() {
        return endDateLte;
    }

    /**
     * @param endDateLte
     *            要设置的 endDateLte
     */
    public void setEndDateLte(String endDateLte) {
        this.endDateLte = endDateLte;
    }

    /**
     * @return the endDateGt
     */
    public String getEndDateGt() {
        return endDateGt;
    }

    /**
     * @param endDateGt
     *            要设置的 endDateGt
     */
    public void setEndDateGt(String endDateGt) {
        this.endDateGt = endDateGt;
    }

    /**
     * @return the endDateLt
     */
    public String getEndDateLt() {
        return endDateLt;
    }

    /**
     * @param endDateLt
     *            要设置的 endDateLt
     */
    public void setEndDateLt(String endDateLt) {
        this.endDateLt = endDateLt;
    }

    /**
     * @return the jobCategoryIn
     */
    public String getJobCategoryIn() {
        return jobCategoryIn;
    }

    /**
     * @param jobCategoryIn
     *            要设置的 jobCategoryIn
     */
    public void setJobCategoryIn(String jobCategoryIn) {
        this.jobCategoryIn = jobCategoryIn;
    }

    /**
     * @return the specialId
     */
    public String getSpecialId() {
        return specialId;
    }

    /**
     * @param specialId
     *            要设置的 specialId
     */
    public void setSpecialId(String specialId) {
        this.specialId = specialId;
    }

    /**
     * @return the specialIdIn
     */
    public String getSpecialIdIn() {
        return specialIdIn;
    }

    /**
     * @param specialIdIn
     *            要设置的 specialIdIn
     */
    public void setSpecialIdIn(String specialIdIn) {
        this.specialIdIn = specialIdIn;
    }

}
