/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年10月16日
 * @author chengq
 */
public class UserInfoDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -3484308654500935784L;

    /** 主键ID **/
    private Integer id;

    /** 人员ID集合，勾选导出 **/
    private List<Long> userIds;

    /** 左侧筛选-新增类型 **/
    private Integer addType;

    /** 人员ID **/
    private String userId;
    private String userIdIn;

    /** 中文姓名 **/
    private String userName;
    private String userNameLike;

    /** 别名/英文名 **/
    private String userAlias;
    private String userAliasLike;

    /** 序号 **/
    private String orderPos;
    private String orderPosEquals;
    private String orderPosGt;
    private String orderPosLt;
    private String orderPosGte;
    private String orderPosLte;

    /** 性别 **/
    private String sex;
    private String sexIn;

    /** 生日 **/
    private String birthday;
    private String birthdayEquals;
    private String birthdayGte;
    private String birthdayLte;
    private String birthdayGt;
    private String birthdayLt;

    /** 年龄 **/
    private String age;
    private String ageEquals;
    private String ageGt;
    private String ageLt;
    private String ageGte;
    private String ageLte;

    /** 左侧筛选 新增时间 **/
    private Date dataGte;
    private Date dataLte;

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
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            要设置的 userId
     */
    public void setUserId(String userId) {
        this.userId = userId;
    }

    /**
     * @return the userIdIn
     */
    public String getUserIdIn() {
        return userIdIn;
    }

    /**
     * @param userIdIn
     *            要设置的 userIdIn
     */
    public void setUserIdIn(String userIdIn) {
        this.userIdIn = userIdIn;
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
     * @return the userAlias
     */
    public String getUserAlias() {
        return userAlias;
    }

    /**
     * @param userAlias
     *            要设置的 userAlias
     */
    public void setUserAlias(String userAlias) {
        this.userAlias = userAlias;
    }

    /**
     * @return the userAliasLike
     */
    public String getUserAliasLike() {
        return userAliasLike;
    }

    /**
     * @param userAliasLike
     *            要设置的 userAliasLike
     */
    public void setUserAliasLike(String userAliasLike) {
        this.userAliasLike = userAliasLike;
    }

    /**
     * @return the orderPos
     */
    public String getOrderPos() {
        return orderPos;
    }

    /**
     * @param orderPos
     *            要设置的 orderPos
     */
    public void setOrderPos(String orderPos) {
        this.orderPos = orderPos;
    }

    /**
     * @return the orderPosEquals
     */
    public String getOrderPosEquals() {
        return orderPosEquals;
    }

    /**
     * @param orderPosEquals
     *            要设置的 orderPosEquals
     */
    public void setOrderPosEquals(String orderPosEquals) {
        this.orderPosEquals = orderPosEquals;
    }

    /**
     * @return the orderPosGt
     */
    public String getOrderPosGt() {
        return orderPosGt;
    }

    /**
     * @param orderPosGt
     *            要设置的 orderPosGt
     */
    public void setOrderPosGt(String orderPosGt) {
        this.orderPosGt = orderPosGt;
    }

    /**
     * @return the orderPosLt
     */
    public String getOrderPosLt() {
        return orderPosLt;
    }

    /**
     * @param orderPosLt
     *            要设置的 orderPosLt
     */
    public void setOrderPosLt(String orderPosLt) {
        this.orderPosLt = orderPosLt;
    }

    /**
     * @return the orderPosGte
     */
    public String getOrderPosGte() {
        return orderPosGte;
    }

    /**
     * @param orderPosGte
     *            要设置的 orderPosGte
     */
    public void setOrderPosGte(String orderPosGte) {
        this.orderPosGte = orderPosGte;
    }

    /**
     * @return the orderPosLte
     */
    public String getOrderPosLte() {
        return orderPosLte;
    }

    /**
     * @param orderPosLte
     *            要设置的 orderPosLte
     */
    public void setOrderPosLte(String orderPosLte) {
        this.orderPosLte = orderPosLte;
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
     * @return the birthday
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            要设置的 birthday
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    /**
     * @return the birthdayEquals
     */
    public String getBirthdayEquals() {
        return birthdayEquals;
    }

    /**
     * @param birthdayEquals
     *            要设置的 birthdayEquals
     */
    public void setBirthdayEquals(String birthdayEquals) {
        this.birthdayEquals = birthdayEquals;
    }

    /**
     * @return the birthdayGte
     */
    public String getBirthdayGte() {
        return birthdayGte;
    }

    /**
     * @param birthdayGte
     *            要设置的 birthdayGte
     */
    public void setBirthdayGte(String birthdayGte) {
        this.birthdayGte = birthdayGte;
    }

    /**
     * @return the birthdayLte
     */
    public String getBirthdayLte() {
        return birthdayLte;
    }

    /**
     * @param birthdayLte
     *            要设置的 birthdayLte
     */
    public void setBirthdayLte(String birthdayLte) {
        this.birthdayLte = birthdayLte;
    }

    /**
     * @return the birthdayGt
     */
    public String getBirthdayGt() {
        return birthdayGt;
    }

    /**
     * @param birthdayGt
     *            要设置的 birthdayGt
     */
    public void setBirthdayGt(String birthdayGt) {
        this.birthdayGt = birthdayGt;
    }

    /**
     * @return the birthdayLt
     */
    public String getBirthdayLt() {
        return birthdayLt;
    }

    /**
     * @param birthdayLt
     *            要设置的 birthdayLt
     */
    public void setBirthdayLt(String birthdayLt) {
        this.birthdayLt = birthdayLt;
    }

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
     * @return the dataGte
     */
    public Date getDataGte() {
        return dataGte;
    }

    /**
     * @param dataGte
     *            要设置的 dataGte
     */
    public void setDataGte(Date dataGte) {
        this.dataGte = dataGte;
    }

    /**
     * @return the dataLte
     */
    public Date getDataLte() {
        return dataLte;
    }

    /**
     * @param dataLte
     *            要设置的 dataLte
     */
    public void setDataLte(Date dataLte) {
        this.dataLte = dataLte;
    }

}
