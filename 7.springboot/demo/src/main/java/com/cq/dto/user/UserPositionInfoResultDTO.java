/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述: 人员档案任职情况子表返回结果集
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public class UserPositionInfoResultDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 3086301720687480634L;

    /** 子表人员基本资料 **/
    private UserBaseResultDTO userBaseResultDto;

    /** 人员任职情况 **/
    private List<UserPositionInfoDTO> userPositionInfoList;

    /**
     * @return the userBaseResultDto
     */
    public UserBaseResultDTO getuserBaseResultDto() {
        return userBaseResultDto;
    }

    /**
     * @param userBaseResultDto
     *            要设置的 userBaseResultDto
     */
    public void setuserBaseResultDto(UserBaseResultDTO userBaseResultDto) {
        this.userBaseResultDto = userBaseResultDto;
    }

    /**
     * @return the userPositionInfoList
     */
    public List<UserPositionInfoDTO> getUserPositionInfoList() {
        return userPositionInfoList;
    }

    /**
     * @param userPositionInfoList
     *            要设置的 userPositionInfoList
     */
    public void setUserPositionInfoList(List<UserPositionInfoDTO> userPositionInfoList) {
        this.userPositionInfoList = userPositionInfoList;
    }

}
