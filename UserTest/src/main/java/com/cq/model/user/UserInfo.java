package com.cq.model.user;

import java.io.Serializable;
import java.util.Date;

public class UserInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4562820022041330465L;

    /** */
    private Integer id;

    /** 用户id */
    private Long userId;

    /** 工号 */
    private String userCode;

    /** 用户名 */
    private String userName;

    /** 邮箱 */
    private String email;

    /** 手机 */
    private String mobile;

    /** 姓名 */
    private String realName;

    /** 用户头像地址 */
    private String imgUrl;

    /** 用户头像key */
    private String imgKey;

    /** 主部门id */
    private Long mainDepartId;

    /** 主部门名称 */
    private String mainDepartName;

    /** 是否删除 */
    private Integer isDelete;

    /** 是否停用 */
    private Integer isBlockup;

    /** 备注 */
    private String memo;

    /** 是否修改过密码 */
    private Integer isUpdatePassword;

    /** 上级领导ID */
    private Long leaderId;

    /** 上级领导名称 */
    private String leaderName;

    /** 创建时间 */
    private Date gmtCreate;

    /** 修改时间 */
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email
     *            要设置的 email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the mobile
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * @param mobile
     *            要设置的 mobile
     */
    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    /**
     * @return the realName
     */
    public String getRealName() {
        return realName;
    }

    /**
     * @param realName
     *            要设置的 realName
     */
    public void setRealName(String realName) {
        this.realName = realName;
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
     * @return the isDelete
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * @param isDelete
     *            要设置的 isDelete
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * @return the isBlockup
     */
    public Integer getIsBlockup() {
        return isBlockup;
    }

    /**
     * @param isBlockup
     *            要设置的 isBlockup
     */
    public void setIsBlockup(Integer isBlockup) {
        this.isBlockup = isBlockup;
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
     * @return the isUpdatePassword
     */
    public Integer getIsUpdatePassword() {
        return isUpdatePassword;
    }

    /**
     * @param isUpdatePassword
     *            要设置的 isUpdatePassword
     */
    public void setIsUpdatePassword(Integer isUpdatePassword) {
        this.isUpdatePassword = isUpdatePassword;
    }

    /**
     * @return the leaderId
     */
    public Long getLeaderId() {
        return leaderId;
    }

    /**
     * @param leaderId
     *            要设置的 leaderId
     */
    public void setLeaderId(Long leaderId) {
        this.leaderId = leaderId;
    }

    /**
     * @return the leaderName
     */
    public String getLeaderName() {
        return leaderName;
    }

    /**
     * @param leaderName
     *            要设置的 leaderName
     */
    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
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
        return "UserInfo [id=" + id + ", userId=" + userId + ", userCode=" + userCode + ", userName=" + userName + ", email=" + email + ", mobile=" + mobile
                + ", realName=" + realName + ", imgUrl=" + imgUrl + ", imgKey=" + imgKey + ", mainDepartId=" + mainDepartId + ", mainDepartName="
                + mainDepartName + ", isDelete=" + isDelete + ", isBlockup=" + isBlockup + ", memo=" + memo + ", isUpdatePassword=" + isUpdatePassword
                + ", leaderId=" + leaderId + ", leaderName=" + leaderName + ", gmtCreate=" + gmtCreate + ", gmtModified=" + gmtModified + "]";
    }

}