package com.cq.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cq.common.convert.DateConverter;
import com.cq.model.file.File;
import com.cq.model.user.UserLeaderInfo;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>
 * 类描述:人员档案基本信息
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
public class UserDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2799911225490404094L;

    /** 主键ID */
    private Integer id;

    /** 人员档案id */
    private Long userId;

    /** erp用户id */
    private Long erpUserId;

    /** 员工编号 */
    private String userNo;

    /** 人员姓名 */
    private String userName;

    /** 花名/英文名 */
    private String englishName;

    /** 用户头像地址 */
    private String imgUrl;

    /** 用户头像key */
    private String imgKey;

    /** 证件类型 默认0 0身份证 1护照 */
    private Integer idCardType;

    /** 证件号 */
    private String idCardNo;

    /** 出生日期类型 默认0 0阳历 1阴历 */
    private Integer birthdateType;

    /** 出生日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date birthdate;

    /** 年龄 */
    private Integer age;

    /** 性别默认0 男0、女1 */
    private Integer sex;

    /** 工号（系统账号） */
    private String userCode;

    /** 所属公司ID */
    private Long companyId;

    /** 所属公司名称 */
    private String companyName;

    /** 所属部门ID **/
    private Long mainDepartId;

    /** 所属部门名称 **/
    private String mainDepartName;

    /** 班组ID */
    private Long classId;

    /** 班组名称 */
    private String className;

    /** 入职日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date entryDate;

    /** 司龄 */
    private Double entryAge;

    /** 试用期(月) */
    private Integer probationaryPeriod;

    /** 延迟转正(天) */
    private Integer delayDay;

    /** 转正日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date regularDate;

    /** 离职日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date leaveDate;

    /** 参加工作日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date startworkDate;

    /** 社会工龄 */
    private Double socialAge;

    /** 任职类型 默认0 全职0、兼职1、实习2 */
    private Integer jobCategory;

    /** 人员类别 默认0 正式工0、合同工1、临时工2、退休返聘3、劳务派遣4 */
    private Integer userCategory;

    /** 婚姻情况 默认0 未婚0、已婚1、离婚2、丧偶3、不详4 */
    private Integer maritalStatus;

    /** 孕育状况 默认0 未育0、已育1 */
    private Integer pregnantStatus;

    /** 户口类别 默认0 本地城镇0、外地城镇1、本地农村2、外地农村3 */
    private Integer accountCategory;

    /** 户口地址 */
    private String accountAddress;

    /** 民族 */
    private String nation;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /** 政治面貌 默认0 群众0、共青团员1、中共党员2、中共预备党员3、民主党派4 */
    private Integer politicsStatus;

    /** 入党日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date joinPartyDate;

    /** 技能特长 **/
    private List<UserSpecialDTO> userSpecialList;

    /** 兴趣爱好 */
    private String hobby;

    /** 手机号码 */
    private String phone;

    /** QQ号 */
    private String qq;

    /** 办公号码 */
    private String officePhone;

    /** 内线电话 */
    private String housePhone;

    /** 邮箱 */
    private String mail;

    /** 个人网址 */
    private String profileUrl;

    /** 现居住地址 */
    private String address;

    /** 家庭地址 */
    private String homeAddress;

    /** 入职体检日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date physicalDate;

    /** 入职培训日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date trainDate;

    /** 网络招聘0、校园招聘1、招聘会2、内推3、猎头4、其他5 */
    private Integer recruitType;

    /** 内推人姓名 */
    private String pushUsername;

    /** 与内推人关系 */
    private String pushRelation;

    /** 备注 */
    private String memo;

    /** 是否在编 0不在编 1在编 */
    private Integer isOrganised;

    /** 人员状态 0在职 1不在职 2停职 3离职 4退休 5借调 */
    private Integer userStatus;

    /** 直接上级职位（任职人） **/
    private List<UserLeaderInfo> parentPosition;

    /** 直接管理职位（任职人） **/
    private List<UserLeaderInfo> subPosition;

    /** 上下级关系 0上级，1下级 **/
    private List<UserLeaderInfo> userLeaderList;

    /** 学历状态 **/
    private Integer eduStatus;

    /** 最高学历 **/
    private Integer educationLevel;

    /** 专业 **/
    private String major;

    /** 毕业学校 **/
    private String school;

    /** 毕业时间 **/
    @JsonSerialize(using = DateConverter.class)
    private Date endDate;

    /** 近期合同到期时间 **/
    @JsonSerialize(using = DateConverter.class)
    private Date labourContractDate;

    /** 合同签订情况 **/
    private String labourContractType;

    /** 个人附件ID **/
    private Long fileId;

    /** 个人附件List **/
    private List<File> fileList;

    /** */
    @JsonSerialize(using = DateConverter.class)
    private Date gmtCreate;

    /** */
    @JsonSerialize(using = DateConverter.class)
    private Date gmtModified;

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
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     *            要设置的 imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the imgKey
     */
    public String getImgKey() {
        return imgKey;
    }

    /**
     * @param imgKey
     *            要设置的 imgKey
     */
    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
    }

    /**
     * @return the idCardType
     */
    public Integer getIdCardType() {
        return idCardType;
    }

    /**
     * @param idCardType
     *            要设置的 idCardType
     */
    public void setIdCardType(Integer idCardType) {
        this.idCardType = idCardType;
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
     * @return the birthdateType
     */
    public Integer getBirthdateType() {
        return birthdateType;
    }

    /**
     * @param birthdateType
     *            要设置的 birthdateType
     */
    public void setBirthdateType(Integer birthdateType) {
        this.birthdateType = birthdateType;
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
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     *            要设置的 age
     */
    public void setAge(Integer age) {
        this.age = age;
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
     * @return the userLeaderList
     */
    public List<UserLeaderInfo> getUserLeaderList() {
        return userLeaderList;
    }

    /**
     * @param userLeaderList
     *            要设置的 userLeaderList
     */
    public void setUserLeaderList(List<UserLeaderInfo> userLeaderList) {
        this.userLeaderList = userLeaderList;
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
     * @return the regularDate
     */
    public Date getRegularDate() {
        return regularDate;
    }

    /**
     * @param regularDate
     *            要设置的 regularDate
     */
    public void setRegularDate(Date regularDate) {
        this.regularDate = regularDate;
    }

    /**
     * @return the leaveDate
     */
    public Date getLeaveDate() {
        return leaveDate;
    }

    /**
     * @param leaveDate
     *            要设置的 leaveDate
     */
    public void setLeaveDate(Date leaveDate) {
        this.leaveDate = leaveDate;
    }

    /**
     * @return the startworkDate
     */
    public Date getStartworkDate() {
        return startworkDate;
    }

    /**
     * @param startworkDate
     *            要设置的 startworkDate
     */
    public void setStartworkDate(Date startworkDate) {
        this.startworkDate = startworkDate;
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
     * @return the maritalStatus
     */
    public Integer getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus
     *            要设置的 maritalStatus
     */
    public void setMaritalStatus(Integer maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the pregnantStatus
     */
    public Integer getPregnantStatus() {
        return pregnantStatus;
    }

    /**
     * @param pregnantStatus
     *            要设置的 pregnantStatus
     */
    public void setPregnantStatus(Integer pregnantStatus) {
        this.pregnantStatus = pregnantStatus;
    }

    /**
     * @return the accountCategory
     */
    public Integer getAccountCategory() {
        return accountCategory;
    }

    /**
     * @param accountCategory
     *            要设置的 accountCategory
     */
    public void setAccountCategory(Integer accountCategory) {
        this.accountCategory = accountCategory;
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
     * @return the nation
     */
    public String getNation() {
        return nation;
    }

    /**
     * @param nation
     *            要设置的 nation
     */
    public void setNation(String nation) {
        this.nation = nation;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     *            要设置的 province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            要设置的 city
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return the politicsStatus
     */
    public Integer getPoliticsStatus() {
        return politicsStatus;
    }

    /**
     * @param politicsStatus
     *            要设置的 politicsStatus
     */
    public void setPoliticsStatus(Integer politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    /**
     * @return the joinPartyDate
     */
    public Date getJoinPartyDate() {
        return joinPartyDate;
    }

    /**
     * @param joinPartyDate
     *            要设置的 joinPartyDate
     */
    public void setJoinPartyDate(Date joinPartyDate) {
        this.joinPartyDate = joinPartyDate;
    }

    /**
     * @return the hobby
     */
    public String getHobby() {
        return hobby;
    }

    /**
     * @param hobby
     *            要设置的 hobby
     */
    public void setHobby(String hobby) {
        this.hobby = hobby;
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
     * @return the housePhone
     */
    public String getHousePhone() {
        return housePhone;
    }

    /**
     * @param housePhone
     *            要设置的 housePhone
     */
    public void setHousePhone(String housePhone) {
        this.housePhone = housePhone;
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
     * @return the profileUrl
     */
    public String getProfileUrl() {
        return profileUrl;
    }

    /**
     * @param profileUrl
     *            要设置的 profileUrl
     */
    public void setProfileUrl(String profileUrl) {
        this.profileUrl = profileUrl;
    }

    /**
     * @return the address
     */
    public String getAddress() {
        return address;
    }

    /**
     * @param address
     *            要设置的 address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    /**
     * @return the homeAddress
     */
    public String getHomeAddress() {
        return homeAddress;
    }

    /**
     * @param homeAddress
     *            要设置的 homeAddress
     */
    public void setHomeAddress(String homeAddress) {
        this.homeAddress = homeAddress;
    }

    /**
     * @return the physicalDate
     */
    public Date getPhysicalDate() {
        return physicalDate;
    }

    /**
     * @param physicalDate
     *            要设置的 physicalDate
     */
    public void setPhysicalDate(Date physicalDate) {
        this.physicalDate = physicalDate;
    }

    /**
     * @return the trainDate
     */
    public Date getTrainDate() {
        return trainDate;
    }

    /**
     * @param trainDate
     *            要设置的 trainDate
     */
    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    /**
     * @return the recruitType
     */
    public Integer getRecruitType() {
        return recruitType;
    }

    /**
     * @param recruitType
     *            要设置的 recruitType
     */
    public void setRecruitType(Integer recruitType) {
        this.recruitType = recruitType;
    }

    /**
     * @return the pushUsername
     */
    public String getPushUsername() {
        return pushUsername;
    }

    /**
     * @param pushUsername
     *            要设置的 pushUsername
     */
    public void setPushUsername(String pushUsername) {
        this.pushUsername = pushUsername;
    }

    /**
     * @return the pushRelation
     */
    public String getPushRelation() {
        return pushRelation;
    }

    /**
     * @param pushRelation
     *            要设置的 pushRelation
     */
    public void setPushRelation(String pushRelation) {
        this.pushRelation = pushRelation;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     *            要设置的 memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return the isOrganised
     */
    public Integer getIsOrganised() {
        return isOrganised;
    }

    /**
     * @param isOrganised
     *            要设置的 isOrganised
     */
    public void setIsOrganised(Integer isOrganised) {
        this.isOrganised = isOrganised;
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

    /**
     * @return the parentPosition
     */
    public List<UserLeaderInfo> getParentPosition() {
        return parentPosition;
    }

    /**
     * @param parentPosition
     *            要设置的 parentPosition
     */
    public void setParentPosition(List<UserLeaderInfo> parentPosition) {
        this.parentPosition = parentPosition;
    }

    /**
     * @return the subPosition
     */
    public List<UserLeaderInfo> getSubPosition() {
        return subPosition;
    }

    /**
     * @param subPosition
     *            要设置的 subPosition
     */
    public void setSubPosition(List<UserLeaderInfo> subPosition) {
        this.subPosition = subPosition;
    }

    /**
     * @return the entryAge
     */
    public Double getEntryAge() {
        return entryAge;
    }

    /**
     * @param entryAge
     *            要设置的 entryAge
     */
    public void setEntryAge(Double entryAge) {
        this.entryAge = entryAge;
    }

    /**
     * @return the socialAge
     */
    public Double getSocialAge() {
        return socialAge;
    }

    /**
     * @param socialAge
     *            要设置的 socialAge
     */
    public void setSocialAge(Double socialAge) {
        this.socialAge = socialAge;
    }

    /**
     * @return the userSpecialList
     */
    public List<UserSpecialDTO> getUserSpecialList() {
        return userSpecialList;
    }

    /**
     * @param userSpecialList
     *            要设置的 userSpecialList
     */
    public void setUserSpecialList(List<UserSpecialDTO> userSpecialList) {
        this.userSpecialList = userSpecialList;
    }

    /**
     * @return the educationLevel
     */
    public Integer getEducationLevel() {
        return educationLevel;
    }

    /**
     * @param educationLevel
     *            要设置的 educationLevel
     */
    public void setEducationLevel(Integer educationLevel) {
        this.educationLevel = educationLevel;
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
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            要设置的 endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the labourContractDate
     */
    public Date getLabourContractDate() {
        return labourContractDate;
    }

    /**
     * @param labourContractDate
     *            要设置的 labourContractDate
     */
    public void setLabourContractDate(Date labourContractDate) {
        this.labourContractDate = labourContractDate;
    }

    /**
     * @return the labourContractType
     */
    public String getLabourContractType() {
        return labourContractType;
    }

    /**
     * @param labourContractType
     *            要设置的 labourContractType
     */
    public void setLabourContractType(String labourContractType) {
        this.labourContractType = labourContractType;
    }

    /**
     * @return the eduStatus
     */
    public Integer getEduStatus() {
        return eduStatus;
    }

    /**
     * @param eduStatus
     *            要设置的 eduStatus
     */
    public void setEduStatus(Integer eduStatus) {
        this.eduStatus = eduStatus;
    }

    /**
     * @return the fileId
     */
    public Long getFileId() {
        return fileId;
    }

    /**
     * @param fileId
     *            要设置的 fileId
     */
    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    /**
     * @return the fileList
     */
    public List<File> getFileList() {
        return fileList;
    }

    /**
     * @param fileList
     *            要设置的 fileList
     */
    public void setFileList(List<File> fileList) {
        this.fileList = fileList;
    }

}