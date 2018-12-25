package com.cq.model.user;

import java.io.Serializable;

public class UserLogin implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 5840313694209601486L;

    /** */
    private Integer id;

    /** 登录人ID */
    private String userId;

    /** 登录人帐号 */
    private Long userLoginId;

    /** 帐号密码 */
    private String password;

    /** 是否删除，0不删除，1删除 */
    private Byte isDeleted;

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
     * @return the userLoginId
     */
    public Long getUserLoginId() {
        return userLoginId;
    }

    /**
     * @param userLoginId
     *            要设置的 userLoginId
     */
    public void setUserLoginId(Long userLoginId) {
        this.userLoginId = userLoginId;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password
     *            要设置的 password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the isDeleted
     */
    public Byte getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     *            要设置的 isDeleted
     */
    public void setIsDeleted(Byte isDeleted) {
        this.isDeleted = isDeleted;
    }

}