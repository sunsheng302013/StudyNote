/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;

/**
 * <p>
 * 类描述: 显示用户DTO
 * </p>
 *
 * @since 2018年10月16日
 * @author wengjiaxin
 */
public class ShowUserDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 9057602044472370423L;

    /** 用户ID **/
    private Long userId;

    /** 用户姓名 **/
    private String userName;

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

    @Override
    public String toString() {
        return "ShowUserDTO [userId=" + userId + ", userName=" + userName + "]";
    }

}
