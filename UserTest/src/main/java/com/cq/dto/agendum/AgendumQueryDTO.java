/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.agendum;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述:日程查询条件
 * </p>
 *
 * @since 2019年4月15日
 * @author chengq
 */
public class AgendumQueryDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1793985882928333109L;

    /** 查询类型 0自己，1下属，2名称筛选 **/
    private Integer type;

    /** 人员ID **/
    private Long userId;

    /** 人员列表 **/
    private List<Long> userIdList;

    /** 人员姓名 按照名称查询 **/
    private String userName;

    /** 开始时间 **/
    private String startTime;

    /** 开始时间 **/
    private String endTime;

    /**
     * @return the type
     */
    public Integer getType() {
        if (type == null) {
            type = 0;
        }
        return type;
    }

    /**
     * @param type
     *            要设置的 type
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return the userIdList
     */
    public List<Long> getUserIdList() {
        return userIdList;
    }

    /**
     * @param userIdList
     *            要设置的 userIdList
     */
    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
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
     * @return the startTime
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            要设置的 startTime
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            要设置的 endTime
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "AgendumQueryDTO [type=" + type + ", userId=" + userId + ", userIdList=" + userIdList + ", userName=" + userName + ", startTime=" + startTime
                + ", endTime=" + endTime + "]";
    }

}
