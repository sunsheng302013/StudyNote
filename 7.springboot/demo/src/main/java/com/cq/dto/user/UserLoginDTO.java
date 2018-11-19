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
public class UserLoginDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1561175330024957558L;

    private Long userId;

    private String userName;

    private String password;

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

}
