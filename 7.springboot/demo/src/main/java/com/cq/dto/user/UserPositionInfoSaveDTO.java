/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月27日
 * @author chengq
 */
public class UserPositionInfoSaveDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -8103651927849979264L;

    /****/
    private Long userId;

    /****/
    private List<UserPositionInfoDTO> userPositionInfo;

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
     * @return the userPositionInfo
     */
    public List<UserPositionInfoDTO> getUserPositionInfo() {
        return userPositionInfo;
    }

    /**
     * @param userPositionInfo
     *            要设置的 userPositionInfo
     */
    public void setUserPositionInfo(List<UserPositionInfoDTO> userPositionInfo) {
        this.userPositionInfo = userPositionInfo;
    }

}
