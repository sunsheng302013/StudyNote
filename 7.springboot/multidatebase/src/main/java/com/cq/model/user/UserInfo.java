package com.cq.model.user;

import java.util.Date;

/**
 *
 * <p>
 * 类描述:员工档案
 * </p>
 *
 * @since 2018年10月16日
 * @author chengq
 */
public class UserInfo {

    /** 主键ID **/
    private Integer id;

    /** 人员ID **/
    private Long userId;

    /** 中文姓名 **/
    private String userName;

    /** 别名/英文名 **/
    private String userAlias;

    /** 序号 **/
    private Integer orderPos;

    /** 性别 **/
    private Integer sex;

    /** 年龄 **/
    private Integer age;

    /** 生日 **/
    private Date birthday;

    /****/
    private Date gmtCreate;

    /****/
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
     * @return the orderPos
     */
    public Integer getOrderPos() {
        return orderPos;
    }

    /**
     * @param orderPos
     *            要设置的 orderPos
     */
    public void setOrderPos(Integer orderPos) {
        this.orderPos = orderPos;
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
     * @return the birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * @param birthday
     *            要设置的 birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
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

}