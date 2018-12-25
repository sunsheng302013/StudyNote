package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

import com.cq.common.annotation.DbTable;

/**
 *
 * <p>
 * 类描述:人员档案基本信息-全字段表头查询
 * </p>
 *
 * @since 2018年10月26日
 * @author chengq
 */
public class UserQueryDTO extends UserQueryBaseDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5956987005092963409L;

    // 左侧过滤
    /** 组织机构过滤-公司 **/
    private Long companyIdLeft;
    /** 组织机构过滤-部门 **/
    private Long departIdLeft;
    /** 组织机构过滤-班组 **/
    private Long classIdLeft;
    /** 任职类型过滤 **/
    private Integer jobCategoryLeft;
    /** 人员类别过滤 **/
    private Integer userCategoryLeft;
    /** 人员状态过滤 **/
    private Integer userStatusLeft;
    /** 是否在编过滤 0否，1是 **/
    private Integer isOrganisedLeft;
    /** 是否领导过滤 0否，1是 **/
    @DbTable(name = "j_oa_user_leader_info")
    private Integer isLeaderLeft;
    /** 是否内推过滤 0否，1是 **/
    private Integer isPushLeft;

    // 左侧筛选
    /** 是否在编 **/
    private List<Integer> isOrganiseds;
    /** 所属公司 **/
    private List<Long> companyIds;
    /** 所属部门 **/
    private List<Long> departIds;
    /** 所属班组 **/
    private List<Long> classIds;
    /** 直属上级 **/
    @DbTable(name = "j_oa_user_leader_info")
    private List<Long> leaders;
    /** 任职类型 **/
    private List<Integer> jobCategorys;
    /** 人员类别 **/
    private List<Integer> userCategorys;
    /** 人员状态 **/
    private List<Integer> userStatusList;
    /** 省份 **/
    private List<String> provinces;
    /** 技能特长 **/
    @DbTable(name = "j_oa_user_special")
    private List<Long> specialIds;
    /** 招聘方式 **/
    private List<Integer> recruitTypes;
    /** 招聘渠道 **/
    private List<Integer> recruitChannels;
    /** 职称 **/
    @DbTable(name = "j_oa_user_skill_info")
    private String skillNameLike;
    /** 工作单位 **/
    @DbTable(name = "j_oa_user_work_experience_info")
    private String workUnitLike;
    /** 是否内推 0否，1是，2所有 **/
    private Integer isPushType;
    /** 职务 erp岗位 **/
    private List<Long> erpPositionIdList;
    /** 职位筛选 **/
    private List<Long> positionIdList;
    /** 学历 **/
    private List<Integer> educationLevels;
    /** 合同签订情况 **/
    @DbTable(name = "j_oa_user_labour_contract")
    private List<String> labourContractTypes;
    /** 入职日期 **/
    private String startEntryDate;
    private String endEntryDate;
    /** 近期合同到期时间 **/
    @DbTable(name = "j_oa_user_labour_contract")
    private String startLabourContractDate;
    @DbTable(name = "j_oa_user_labour_contract")
    private String endLabourContractDate;
    /** 离职日期 **/
    private String startLeaveDate;
    private String endLeaveDate;
    /** 是否有小孩 0否，1是，2所有 多选 **/
    private Integer childrenType;
    // 隐藏字段表头查询
    /** 年龄 */
    private String age;
    private String ageEquals;
    private String ageGte;
    private String ageLte;
    private String ageGt;
    private String ageLt;

    /** 司龄 */
    private String entryAge;
    private String entryAgeEquals;
    private String entryAgeGte;
    private String entryAgeLte;
    private String entryAgeGt;
    private String entryAgeLt;

    /** 参见工作日期 */
    private String startworkDate;
    private String startworkDateEquals;
    private String startworkDateGte;
    private String startworkDateLte;
    private String startworkDateGt;
    private String startworkDateLt;

    /** 社会工龄 */
    private String socialAge;
    private String socialAgeEquals;
    private String socialAgeGte;
    private String socialAgeLte;
    private String socialAgeGt;
    private String socialAgeLt;

    /** 婚姻情况 默认0 未婚0、已婚1、离婚2、丧偶3、不详4 */
    private String maritalStatus;
    private String maritalStatusIn;

    /** 孕育状况 默认0 未育0、已育1 */
    private String pregnantStatus;
    private String pregnantStatusIn;

    /** 户口类别 默认0 本地城镇0、外地城镇1、本地农村2、外地农村3 */
    private String accountCategory;
    private String accountCategoryIn;

    /** 民族 */
    private String nation;
    private String nationLike;

    /** 政治面貌 默认0 群众0、共青团员1、中共党员2、中共预备党员3、民主党派4 */
    private String politicsStatus;
    private String politicsStatusIn;

    /** 入党日期 */
    private String joinPartyDate;
    private String joinPartyDateEquals;
    private String joinPartyDateGte;
    private String joinPartyDateLte;
    private String joinPartyDateGt;
    private String joinPartyDateLt;

    /** 兴趣爱好 */
    private String hobby;
    private String hobbyLike;

    /** 现居住地址 */
    private String address;
    private String addressLike;

    /** 家庭地址 */
    private String homeAddress;
    private String homeAddressLike;

    /** 入职体检日期 */
    private String physicalDate;
    private String physicalDateEquals;
    private String physicalDateGte;
    private String physicalDateLte;
    private String physicalDateGt;
    private String physicalDateLt;

    /** 入职培训日期 */
    private String trainDate;
    private String trainDateEquals;
    private String trainDateGte;
    private String trainDateLte;
    private String trainDateGt;
    private String trainDateLt;

    /** 招聘渠道：0社招，1校招 */
    private String recruitChannel;
    private String recruitChannelIn;

    /** 招聘方式：招聘网站0、官方邮箱1、内推2、同业推荐3、猎头4、招聘会5、宣讲会6 */
    private String recruitType;
    private String recruitTypeIn;

    /** 内推人姓名 */
    private String pushUsername;
    private String pushUsernameLike;

    /** 与内推人关系 */
    private String pushRelation;
    private String pushRelationLike;

    /** 备注 */
    private String memo;
    private String memoLike;

    /** 省 */
    private String province;
    private String provinceIn;
    private String provinceLike;

    /** 市 */
    private String city;

    /**
     * @return the age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age
     *            要设置的 age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return the ageEquals
     */
    public String getAgeEquals() {
        return ageEquals;
    }

    /**
     * @param ageEquals
     *            要设置的 ageEquals
     */
    public void setAgeEquals(String ageEquals) {
        this.ageEquals = ageEquals;
    }

    /**
     * @return the ageGte
     */
    public String getAgeGte() {
        return ageGte;
    }

    /**
     * @param ageGte
     *            要设置的 ageGte
     */
    public void setAgeGte(String ageGte) {
        this.ageGte = ageGte;
    }

    /**
     * @return the ageLte
     */
    public String getAgeLte() {
        return ageLte;
    }

    /**
     * @param ageLte
     *            要设置的 ageLte
     */
    public void setAgeLte(String ageLte) {
        this.ageLte = ageLte;
    }

    /**
     * @return the ageGt
     */
    public String getAgeGt() {
        return ageGt;
    }

    /**
     * @param ageGt
     *            要设置的 ageGt
     */
    public void setAgeGt(String ageGt) {
        this.ageGt = ageGt;
    }

    /**
     * @return the ageLt
     */
    public String getAgeLt() {
        return ageLt;
    }

    /**
     * @param ageLt
     *            要设置的 ageLt
     */
    public void setAgeLt(String ageLt) {
        this.ageLt = ageLt;
    }

    /**
     * @return the entryAgeEquals
     */
    public String getEntryAgeEquals() {
        return entryAgeEquals;
    }

    /**
     * @param entryAgeEquals
     *            要设置的 entryAgeEquals
     */
    public void setEntryAgeEquals(String entryAgeEquals) {
        this.entryAgeEquals = entryAgeEquals;
    }

    /**
     * @return the entryAgeGte
     */
    public String getEntryAgeGte() {
        return entryAgeGte;
    }

    /**
     * @param entryAgeGte
     *            要设置的 entryAgeGte
     */
    public void setEntryAgeGte(String entryAgeGte) {
        this.entryAgeGte = entryAgeGte;
    }

    /**
     * @return the entryAgeLte
     */
    public String getEntryAgeLte() {
        return entryAgeLte;
    }

    /**
     * @param entryAgeLte
     *            要设置的 entryAgeLte
     */
    public void setEntryAgeLte(String entryAgeLte) {
        this.entryAgeLte = entryAgeLte;
    }

    /**
     * @return the entryAgeGt
     */
    public String getEntryAgeGt() {
        return entryAgeGt;
    }

    /**
     * @param entryAgeGt
     *            要设置的 entryAgeGt
     */
    public void setEntryAgeGt(String entryAgeGt) {
        this.entryAgeGt = entryAgeGt;
    }

    /**
     * @return the entryAgeLt
     */
    public String getEntryAgeLt() {
        return entryAgeLt;
    }

    /**
     * @param entryAgeLt
     *            要设置的 entryAgeLt
     */
    public void setEntryAgeLt(String entryAgeLt) {
        this.entryAgeLt = entryAgeLt;
    }

    /**
     * @return the startworkDate
     */
    public String getStartworkDate() {
        return startworkDate;
    }

    /**
     * @param startworkDate
     *            要设置的 startworkDate
     */
    public void setStartworkDate(String startworkDate) {
        this.startworkDate = startworkDate;
    }

    /**
     * @return the startworkDateEquals
     */
    public String getStartworkDateEquals() {
        return startworkDateEquals;
    }

    /**
     * @param startworkDateEquals
     *            要设置的 startworkDateEquals
     */
    public void setStartworkDateEquals(String startworkDateEquals) {
        this.startworkDateEquals = startworkDateEquals;
    }

    /**
     * @return the startworkDateGte
     */
    public String getStartworkDateGte() {
        return startworkDateGte;
    }

    /**
     * @param startworkDateGte
     *            要设置的 startworkDateGte
     */
    public void setStartworkDateGte(String startworkDateGte) {
        this.startworkDateGte = startworkDateGte;
    }

    /**
     * @return the startworkDateLte
     */
    public String getStartworkDateLte() {
        return startworkDateLte;
    }

    /**
     * @param startworkDateLte
     *            要设置的 startworkDateLte
     */
    public void setStartworkDateLte(String startworkDateLte) {
        this.startworkDateLte = startworkDateLte;
    }

    /**
     * @return the startworkDateGt
     */
    public String getStartworkDateGt() {
        return startworkDateGt;
    }

    /**
     * @param startworkDateGt
     *            要设置的 startworkDateGt
     */
    public void setStartworkDateGt(String startworkDateGt) {
        this.startworkDateGt = startworkDateGt;
    }

    /**
     * @return the startworkDateLt
     */
    public String getStartworkDateLt() {
        return startworkDateLt;
    }

    /**
     * @param startworkDateLt
     *            要设置的 startworkDateLt
     */
    public void setStartworkDateLt(String startworkDateLt) {
        this.startworkDateLt = startworkDateLt;
    }

    /**
     * @return the socialAgeEquals
     */
    public String getSocialAgeEquals() {
        return socialAgeEquals;
    }

    /**
     * @param socialAgeEquals
     *            要设置的 socialAgeEquals
     */
    public void setSocialAgeEquals(String socialAgeEquals) {
        this.socialAgeEquals = socialAgeEquals;
    }

    /**
     * @return the socialAgeGte
     */
    public String getSocialAgeGte() {
        return socialAgeGte;
    }

    /**
     * @param socialAgeGte
     *            要设置的 socialAgeGte
     */
    public void setSocialAgeGte(String socialAgeGte) {
        this.socialAgeGte = socialAgeGte;
    }

    /**
     * @return the socialAgeLte
     */
    public String getSocialAgeLte() {
        return socialAgeLte;
    }

    /**
     * @param socialAgeLte
     *            要设置的 socialAgeLte
     */
    public void setSocialAgeLte(String socialAgeLte) {
        this.socialAgeLte = socialAgeLte;
    }

    /**
     * @return the socialAgeGt
     */
    public String getSocialAgeGt() {
        return socialAgeGt;
    }

    /**
     * @param socialAgeGt
     *            要设置的 socialAgeGt
     */
    public void setSocialAgeGt(String socialAgeGt) {
        this.socialAgeGt = socialAgeGt;
    }

    /**
     * @return the socialAgeLt
     */
    public String getSocialAgeLt() {
        return socialAgeLt;
    }

    /**
     * @param socialAgeLt
     *            要设置的 socialAgeLt
     */
    public void setSocialAgeLt(String socialAgeLt) {
        this.socialAgeLt = socialAgeLt;
    }

    /**
     * @return the maritalStatus
     */
    public String getMaritalStatus() {
        return maritalStatus;
    }

    /**
     * @param maritalStatus
     *            要设置的 maritalStatus
     */
    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    /**
     * @return the maritalStatusIn
     */
    public String getMaritalStatusIn() {
        return maritalStatusIn;
    }

    /**
     * @param maritalStatusIn
     *            要设置的 maritalStatusIn
     */
    public void setMaritalStatusIn(String maritalStatusIn) {
        this.maritalStatusIn = maritalStatusIn;
    }

    /**
     * @return the pregnantStatus
     */
    public String getPregnantStatus() {
        return pregnantStatus;
    }

    /**
     * @param pregnantStatus
     *            要设置的 pregnantStatus
     */
    public void setPregnantStatus(String pregnantStatus) {
        this.pregnantStatus = pregnantStatus;
    }

    /**
     * @return the pregnantStatusIn
     */
    public String getPregnantStatusIn() {
        return pregnantStatusIn;
    }

    /**
     * @param pregnantStatusIn
     *            要设置的 pregnantStatusIn
     */
    public void setPregnantStatusIn(String pregnantStatusIn) {
        this.pregnantStatusIn = pregnantStatusIn;
    }

    /**
     * @return the accountCategory
     */
    public String getAccountCategory() {
        return accountCategory;
    }

    /**
     * @param accountCategory
     *            要设置的 accountCategory
     */
    public void setAccountCategory(String accountCategory) {
        this.accountCategory = accountCategory;
    }

    /**
     * @return the accountCategoryIn
     */
    public String getAccountCategoryIn() {
        return accountCategoryIn;
    }

    /**
     * @param accountCategoryIn
     *            要设置的 accountCategoryIn
     */
    public void setAccountCategoryIn(String accountCategoryIn) {
        this.accountCategoryIn = accountCategoryIn;
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
     * @return the nationLike
     */
    public String getNationLike() {
        return nationLike;
    }

    /**
     * @param nationLike
     *            要设置的 nationLike
     */
    public void setNationLike(String nationLike) {
        this.nationLike = nationLike;
    }

    /**
     * @return the politicsStatus
     */
    public String getPoliticsStatus() {
        return politicsStatus;
    }

    /**
     * @param politicsStatus
     *            要设置的 politicsStatus
     */
    public void setPoliticsStatus(String politicsStatus) {
        this.politicsStatus = politicsStatus;
    }

    /**
     * @return the politicsStatusIn
     */
    public String getPoliticsStatusIn() {
        return politicsStatusIn;
    }

    /**
     * @param politicsStatusIn
     *            要设置的 politicsStatusIn
     */
    public void setPoliticsStatusIn(String politicsStatusIn) {
        this.politicsStatusIn = politicsStatusIn;
    }

    /**
     * @return the joinPartyDate
     */
    public String getJoinPartyDate() {
        return joinPartyDate;
    }

    /**
     * @param joinPartyDate
     *            要设置的 joinPartyDate
     */
    public void setJoinPartyDate(String joinPartyDate) {
        this.joinPartyDate = joinPartyDate;
    }

    /**
     * @return the joinPartyDateEquals
     */
    public String getJoinPartyDateEquals() {
        return joinPartyDateEquals;
    }

    /**
     * @param joinPartyDateEquals
     *            要设置的 joinPartyDateEquals
     */
    public void setJoinPartyDateEquals(String joinPartyDateEquals) {
        this.joinPartyDateEquals = joinPartyDateEquals;
    }

    /**
     * @return the joinPartyDateGte
     */
    public String getJoinPartyDateGte() {
        return joinPartyDateGte;
    }

    /**
     * @param joinPartyDateGte
     *            要设置的 joinPartyDateGte
     */
    public void setJoinPartyDateGte(String joinPartyDateGte) {
        this.joinPartyDateGte = joinPartyDateGte;
    }

    /**
     * @return the joinPartyDateLte
     */
    public String getJoinPartyDateLte() {
        return joinPartyDateLte;
    }

    /**
     * @param joinPartyDateLte
     *            要设置的 joinPartyDateLte
     */
    public void setJoinPartyDateLte(String joinPartyDateLte) {
        this.joinPartyDateLte = joinPartyDateLte;
    }

    /**
     * @return the joinPartyDateGt
     */
    public String getJoinPartyDateGt() {
        return joinPartyDateGt;
    }

    /**
     * @param joinPartyDateGt
     *            要设置的 joinPartyDateGt
     */
    public void setJoinPartyDateGt(String joinPartyDateGt) {
        this.joinPartyDateGt = joinPartyDateGt;
    }

    /**
     * @return the joinPartyDateLt
     */
    public String getJoinPartyDateLt() {
        return joinPartyDateLt;
    }

    /**
     * @param joinPartyDateLt
     *            要设置的 joinPartyDateLt
     */
    public void setJoinPartyDateLt(String joinPartyDateLt) {
        this.joinPartyDateLt = joinPartyDateLt;
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
     * @return the hobbyLike
     */
    public String getHobbyLike() {
        return hobbyLike;
    }

    /**
     * @param hobbyLike
     *            要设置的 hobbyLike
     */
    public void setHobbyLike(String hobbyLike) {
        this.hobbyLike = hobbyLike;
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
     * @return the addressLike
     */
    public String getAddressLike() {
        return addressLike;
    }

    /**
     * @param addressLike
     *            要设置的 addressLike
     */
    public void setAddressLike(String addressLike) {
        this.addressLike = addressLike;
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
     * @return the homeAddressLike
     */
    public String getHomeAddressLike() {
        return homeAddressLike;
    }

    /**
     * @param homeAddressLike
     *            要设置的 homeAddressLike
     */
    public void setHomeAddressLike(String homeAddressLike) {
        this.homeAddressLike = homeAddressLike;
    }

    /**
     * @return the physicalDate
     */
    public String getPhysicalDate() {
        return physicalDate;
    }

    /**
     * @param physicalDate
     *            要设置的 physicalDate
     */
    public void setPhysicalDate(String physicalDate) {
        this.physicalDate = physicalDate;
    }

    /**
     * @return the physicalDateEquals
     */
    public String getPhysicalDateEquals() {
        return physicalDateEquals;
    }

    /**
     * @param physicalDateEquals
     *            要设置的 physicalDateEquals
     */
    public void setPhysicalDateEquals(String physicalDateEquals) {
        this.physicalDateEquals = physicalDateEquals;
    }

    /**
     * @return the physicalDateGte
     */
    public String getPhysicalDateGte() {
        return physicalDateGte;
    }

    /**
     * @param physicalDateGte
     *            要设置的 physicalDateGte
     */
    public void setPhysicalDateGte(String physicalDateGte) {
        this.physicalDateGte = physicalDateGte;
    }

    /**
     * @return the physicalDateLte
     */
    public String getPhysicalDateLte() {
        return physicalDateLte;
    }

    /**
     * @param physicalDateLte
     *            要设置的 physicalDateLte
     */
    public void setPhysicalDateLte(String physicalDateLte) {
        this.physicalDateLte = physicalDateLte;
    }

    /**
     * @return the physicalDateGt
     */
    public String getPhysicalDateGt() {
        return physicalDateGt;
    }

    /**
     * @param physicalDateGt
     *            要设置的 physicalDateGt
     */
    public void setPhysicalDateGt(String physicalDateGt) {
        this.physicalDateGt = physicalDateGt;
    }

    /**
     * @return the physicalDateLt
     */
    public String getPhysicalDateLt() {
        return physicalDateLt;
    }

    /**
     * @param physicalDateLt
     *            要设置的 physicalDateLt
     */
    public void setPhysicalDateLt(String physicalDateLt) {
        this.physicalDateLt = physicalDateLt;
    }

    /**
     * @return the trainDate
     */
    public String getTrainDate() {
        return trainDate;
    }

    /**
     * @param trainDate
     *            要设置的 trainDate
     */
    public void setTrainDate(String trainDate) {
        this.trainDate = trainDate;
    }

    /**
     * @return the trainDateEquals
     */
    public String getTrainDateEquals() {
        return trainDateEquals;
    }

    /**
     * @param trainDateEquals
     *            要设置的 trainDateEquals
     */
    public void setTrainDateEquals(String trainDateEquals) {
        this.trainDateEquals = trainDateEquals;
    }

    /**
     * @return the trainDateGte
     */
    public String getTrainDateGte() {
        return trainDateGte;
    }

    /**
     * @param trainDateGte
     *            要设置的 trainDateGte
     */
    public void setTrainDateGte(String trainDateGte) {
        this.trainDateGte = trainDateGte;
    }

    /**
     * @return the trainDateLte
     */
    public String getTrainDateLte() {
        return trainDateLte;
    }

    /**
     * @param trainDateLte
     *            要设置的 trainDateLte
     */
    public void setTrainDateLte(String trainDateLte) {
        this.trainDateLte = trainDateLte;
    }

    /**
     * @return the trainDateGt
     */
    public String getTrainDateGt() {
        return trainDateGt;
    }

    /**
     * @param trainDateGt
     *            要设置的 trainDateGt
     */
    public void setTrainDateGt(String trainDateGt) {
        this.trainDateGt = trainDateGt;
    }

    /**
     * @return the trainDateLt
     */
    public String getTrainDateLt() {
        return trainDateLt;
    }

    /**
     * @param trainDateLt
     *            要设置的 trainDateLt
     */
    public void setTrainDateLt(String trainDateLt) {
        this.trainDateLt = trainDateLt;
    }

    /**
     * @return the recruitType
     */
    public String getRecruitType() {
        return recruitType;
    }

    /**
     * @param recruitType
     *            要设置的 recruitType
     */
    public void setRecruitType(String recruitType) {
        this.recruitType = recruitType;
    }

    /**
     * @return the recruitTypeIn
     */
    public String getRecruitTypeIn() {
        return recruitTypeIn;
    }

    /**
     * @param recruitTypeIn
     *            要设置的 recruitTypeIn
     */
    public void setRecruitTypeIn(String recruitTypeIn) {
        this.recruitTypeIn = recruitTypeIn;
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
     * @return the pushUsernameLike
     */
    public String getPushUsernameLike() {
        return pushUsernameLike;
    }

    /**
     * @param pushUsernameLike
     *            要设置的 pushUsernameLike
     */
    public void setPushUsernameLike(String pushUsernameLike) {
        this.pushUsernameLike = pushUsernameLike;
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
     * @return the pushRelationLike
     */
    public String getPushRelationLike() {
        return pushRelationLike;
    }

    /**
     * @param pushRelationLike
     *            要设置的 pushRelationLike
     */
    public void setPushRelationLike(String pushRelationLike) {
        this.pushRelationLike = pushRelationLike;
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
     * @return the memoLike
     */
    public String getMemoLike() {
        return memoLike;
    }

    /**
     * @param memoLike
     *            要设置的 memoLike
     */
    public void setMemoLike(String memoLike) {
        this.memoLike = memoLike;
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
     * @return the companyIdLeft
     */
    public Long getCompanyIdLeft() {
        return companyIdLeft;
    }

    /**
     * @param companyIdLeft
     *            要设置的 companyIdLeft
     */
    public void setCompanyIdLeft(Long companyIdLeft) {
        this.companyIdLeft = companyIdLeft;
    }

    /**
     * @return the departIdLeft
     */
    public Long getDepartIdLeft() {
        return departIdLeft;
    }

    /**
     * @param departIdLeft
     *            要设置的 departIdLeft
     */
    public void setDepartIdLeft(Long departIdLeft) {
        this.departIdLeft = departIdLeft;
    }

    /**
     * @return the classIdLeft
     */
    public Long getClassIdLeft() {
        return classIdLeft;
    }

    /**
     * @param classIdLeft
     *            要设置的 classIdLeft
     */
    public void setClassIdLeft(Long classIdLeft) {
        this.classIdLeft = classIdLeft;
    }

    /**
     * @return the jobCategoryLeft
     */
    public Integer getJobCategoryLeft() {
        return jobCategoryLeft;
    }

    /**
     * @param jobCategoryLeft
     *            要设置的 jobCategoryLeft
     */
    public void setJobCategoryLeft(Integer jobCategoryLeft) {
        this.jobCategoryLeft = jobCategoryLeft;
    }

    /**
     * @return the userCategoryLeft
     */
    public Integer getUserCategoryLeft() {
        return userCategoryLeft;
    }

    /**
     * @param userCategoryLeft
     *            要设置的 userCategoryLeft
     */
    public void setUserCategoryLeft(Integer userCategoryLeft) {
        this.userCategoryLeft = userCategoryLeft;
    }

    /**
     * @return the userStatusLeft
     */
    public Integer getUserStatusLeft() {
        return userStatusLeft;
    }

    /**
     * @param userStatusLeft
     *            要设置的 userStatusLeft
     */
    public void setUserStatusLeft(Integer userStatusLeft) {
        this.userStatusLeft = userStatusLeft;
    }

    /**
     * @return the isOrganisedLeft
     */
    public Integer getIsOrganisedLeft() {
        return isOrganisedLeft;
    }

    /**
     * @param isOrganisedLeft
     *            要设置的 isOrganisedLeft
     */
    public void setIsOrganisedLeft(Integer isOrganisedLeft) {
        this.isOrganisedLeft = isOrganisedLeft;
    }

    /**
     * @return the isLeaderLeft
     */
    public Integer getIsLeaderLeft() {
        return isLeaderLeft;
    }

    /**
     * @param isLeaderLeft
     *            要设置的 isLeaderLeft
     */
    public void setIsLeaderLeft(Integer isLeaderLeft) {
        this.isLeaderLeft = isLeaderLeft;
    }

    /**
     * @return the isPushLeft
     */
    public Integer getIsPushLeft() {
        return isPushLeft;
    }

    /**
     * @param isPushLeft
     *            要设置的 isPushLeft
     */
    public void setIsPushLeft(Integer isPushLeft) {
        this.isPushLeft = isPushLeft;
    }

    /**
     * @return the childrenType
     */
    public Integer getChildrenType() {
        return childrenType;
    }

    /**
     * @param childrenType
     *            要设置的 childrenType
     */
    public void setChildrenType(Integer childrenType) {
        this.childrenType = childrenType;
    }

    /**
     * @return the entryAge
     */
    public String getEntryAge() {
        return entryAge;
    }

    /**
     * @param entryAge
     *            要设置的 entryAge
     */
    public void setEntryAge(String entryAge) {
        this.entryAge = entryAge;
    }

    /**
     * @return the socialAge
     */
    public String getSocialAge() {
        return socialAge;
    }

    /**
     * @param socialAge
     *            要设置的 socialAge
     */
    public void setSocialAge(String socialAge) {
        this.socialAge = socialAge;
    }

    /**
     * @return the isPushType
     */
    public Integer getIsPushType() {
        return isPushType;
    }

    /**
     * @param isPushType
     *            要设置的 isPushType
     */
    public void setIsPushType(Integer isPushType) {
        this.isPushType = isPushType;
    }

    /**
     * @return the isOrganiseds
     */
    public List<Integer> getIsOrganiseds() {
        return isOrganiseds;
    }

    /**
     * @param isOrganiseds
     *            要设置的 isOrganiseds
     */
    public void setIsOrganiseds(List<Integer> isOrganiseds) {
        this.isOrganiseds = isOrganiseds;
    }

    /**
     * @return the companyIds
     */
    public List<Long> getCompanyIds() {
        return companyIds;
    }

    /**
     * @param companyIds
     *            要设置的 companyIds
     */
    public void setCompanyIds(List<Long> companyIds) {
        this.companyIds = companyIds;
    }

    /**
     * @return the departIds
     */
    public List<Long> getDepartIds() {
        return departIds;
    }

    /**
     * @param departIds
     *            要设置的 departIds
     */
    public void setDepartIds(List<Long> departIds) {
        this.departIds = departIds;
    }

    /**
     * @return the classIds
     */
    public List<Long> getClassIds() {
        return classIds;
    }

    /**
     * @param classIds
     *            要设置的 classIds
     */
    public void setClassIds(List<Long> classIds) {
        this.classIds = classIds;
    }

    /**
     * @return the leaders
     */
    public List<Long> getLeaders() {
        return leaders;
    }

    /**
     * @param leaders
     *            要设置的 leaders
     */
    public void setLeaders(List<Long> leaders) {
        this.leaders = leaders;
    }

    /**
     * @return the jobCategorys
     */
    public List<Integer> getJobCategorys() {
        return jobCategorys;
    }

    /**
     * @param jobCategorys
     *            要设置的 jobCategorys
     */
    public void setJobCategorys(List<Integer> jobCategorys) {
        this.jobCategorys = jobCategorys;
    }

    /**
     * @return the userCategorys
     */
    public List<Integer> getUserCategorys() {
        return userCategorys;
    }

    /**
     * @param userCategorys
     *            要设置的 userCategorys
     */
    public void setUserCategorys(List<Integer> userCategorys) {
        this.userCategorys = userCategorys;
    }

    /**
     * @return the userStatusList
     */
    public List<Integer> getUserStatusList() {
        return userStatusList;
    }

    /**
     * @param userStatusList
     *            要设置的 userStatusList
     */
    public void setUserStatusList(List<Integer> userStatusList) {
        this.userStatusList = userStatusList;
    }

    /**
     * @return the provinces
     */
    public List<String> getProvinces() {
        return provinces;
    }

    /**
     * @param provinces
     *            要设置的 provinces
     */
    public void setProvinces(List<String> provinces) {
        this.provinces = provinces;
    }

    /**
     * @return the specialIds
     */
    public List<Long> getSpecialIds() {
        return specialIds;
    }

    /**
     * @param specialIds
     *            要设置的 specialIds
     */
    public void setSpecialIds(List<Long> specialIds) {
        this.specialIds = specialIds;
    }

    /**
     * @return the recruitTypes
     */
    public List<Integer> getRecruitTypes() {
        return recruitTypes;
    }

    /**
     * @param recruitTypes
     *            要设置的 recruitTypes
     */
    public void setRecruitTypes(List<Integer> recruitTypes) {
        this.recruitTypes = recruitTypes;
    }

    /**
     * @return the educationLevels
     */
    public List<Integer> getEducationLevels() {
        return educationLevels;
    }

    /**
     * @param educationLevels
     *            要设置的 educationLevels
     */
    public void setEducationLevels(List<Integer> educationLevels) {
        this.educationLevels = educationLevels;
    }

    /**
     * @return the labourContractTypes
     */
    public List<String> getLabourContractTypes() {
        return labourContractTypes;
    }

    /**
     * @param labourContractTypes
     *            要设置的 labourContractTypes
     */
    public void setLabourContractTypes(List<String> labourContractTypes) {
        this.labourContractTypes = labourContractTypes;
    }

    /**
     * @return the startEntryDate
     */
    public String getStartEntryDate() {
        return startEntryDate;
    }

    /**
     * @param startEntryDate
     *            要设置的 startEntryDate
     */
    public void setStartEntryDate(String startEntryDate) {
        this.startEntryDate = startEntryDate;
    }

    /**
     * @return the endEntryDate
     */
    public String getEndEntryDate() {
        return endEntryDate;
    }

    /**
     * @param endEntryDate
     *            要设置的 endEntryDate
     */
    public void setEndEntryDate(String endEntryDate) {
        this.endEntryDate = endEntryDate;
    }

    /**
     * @return the startLabourContractDate
     */
    public String getStartLabourContractDate() {
        return startLabourContractDate;
    }

    /**
     * @param startLabourContractDate
     *            要设置的 startLabourContractDate
     */
    public void setStartLabourContractDate(String startLabourContractDate) {
        this.startLabourContractDate = startLabourContractDate;
    }

    /**
     * @return the endLabourContractDate
     */
    public String getEndLabourContractDate() {
        return endLabourContractDate;
    }

    /**
     * @param endLabourContractDate
     *            要设置的 endLabourContractDate
     */
    public void setEndLabourContractDate(String endLabourContractDate) {
        this.endLabourContractDate = endLabourContractDate;
    }

    /**
     * @return the startLeaveDate
     */
    public String getStartLeaveDate() {
        return startLeaveDate;
    }

    /**
     * @param startLeaveDate
     *            要设置的 startLeaveDate
     */
    public void setStartLeaveDate(String startLeaveDate) {
        this.startLeaveDate = startLeaveDate;
    }

    /**
     * @return the endLeaveDate
     */
    public String getEndLeaveDate() {
        return endLeaveDate;
    }

    /**
     * @param endLeaveDate
     *            要设置的 endLeaveDate
     */
    public void setEndLeaveDate(String endLeaveDate) {
        this.endLeaveDate = endLeaveDate;
    }

    /**
     * @return the provinceIn
     */
    public String getProvinceIn() {
        return provinceIn;
    }

    /**
     * @param provinceIn
     *            要设置的 provinceIn
     */
    public void setProvinceIn(String provinceIn) {
        this.provinceIn = provinceIn;
    }

    /**
     * @return the erpPositionIdList
     */
    public List<Long> getErpPositionIdList() {
        return erpPositionIdList;
    }

    /**
     * @param erpPositionIdList
     *            要设置的 erpPositionIdList
     */
    public void setErpPositionIdList(List<Long> erpPositionIdList) {
        this.erpPositionIdList = erpPositionIdList;
    }

    /**
     * @return the positionIdList
     */
    public List<Long> getPositionIdList() {
        return positionIdList;
    }

    /**
     * @param positionIdList
     *            要设置的 positionIdList
     */
    public void setPositionIdList(List<Long> positionIdList) {
        this.positionIdList = positionIdList;
    }

    /**
     * @return the recruitChannel
     */
    public String getRecruitChannel() {
        return recruitChannel;
    }

    /**
     * @param recruitChannel
     *            要设置的 recruitChannel
     */
    public void setRecruitChannel(String recruitChannel) {
        this.recruitChannel = recruitChannel;
    }

    /**
     * @return the recruitChannelIn
     */
    public String getRecruitChannelIn() {
        return recruitChannelIn;
    }

    /**
     * @param recruitChannelIn
     *            要设置的 recruitChannelIn
     */
    public void setRecruitChannelIn(String recruitChannelIn) {
        this.recruitChannelIn = recruitChannelIn;
    }

    /**
     * @return the recruitChannels
     */
    public List<Integer> getRecruitChannels() {
        return recruitChannels;
    }

    /**
     * @param recruitChannels
     *            要设置的 recruitChannels
     */
    public void setRecruitChannels(List<Integer> recruitChannels) {
        this.recruitChannels = recruitChannels;
    }

    /**
     * @return the skillNameLike
     */
    public String getSkillNameLike() {
        return skillNameLike;
    }

    /**
     * @param skillNameLike
     *            要设置的 skillNameLike
     */
    public void setSkillNameLike(String skillNameLike) {
        this.skillNameLike = skillNameLike;
    }

    /**
     * @return the workUnitLike
     */
    public String getWorkUnitLike() {
        return workUnitLike;
    }

    /**
     * @param workUnitLike
     *            要设置的 workUnitLike
     */
    public void setWorkUnitLike(String workUnitLike) {
        this.workUnitLike = workUnitLike;
    }

    /**
     * @return the provinceLike
     */
    public String getProvinceLike() {
        return provinceLike;
    }

    /**
     * @param provinceLike
     *            要设置的 provinceLike
     */
    public void setProvinceLike(String provinceLike) {
        this.provinceLike = provinceLike;
    }
}