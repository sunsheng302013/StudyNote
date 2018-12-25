/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月19日
 * @author chengq
 */
public class UserLoginImportExcelDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -5536333929408179148L;

    /** */
    private Integer id;

    /** 登录人ID */
    private Long userId;

    /** 登录人帐号 */
    private Long userLoginId;

    /** 帐号密码 */
    private String password;

    /** 是否删除，0不删除，1删除 */
    private Integer isDeleted;

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
    public Integer getIsDeleted() {
        return isDeleted;
    }

    /**
     * @param isDeleted
     *            要设置的 isDeleted
     */
    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }

}