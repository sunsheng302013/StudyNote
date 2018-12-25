/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

import com.cq.model.user.UserLeaderInfo;

/**
 * <p>
 * 类描述:批量修改人员档案入参DTO
 * </p>
 *
 * @since 2018年11月12日
 * @author chengq
 */
public class UserUpdateBatchDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -2325595070061145894L;

    /** 人员ID **/
    private List<Long> userIds;

    /** 直接上级 **/
    private List<UserLeaderInfo> parentPosition;

    /** 任职类型 默认0 全职0、兼职1、实习2 */
    private Integer jobCategory;

    /** 人员状态 0在职 1不在职 2停职 3离职 4退休 5借调 */
    private Integer userStatus;

    /** 人员类别 默认0 正式工0、合同工1、临时工2、退休返聘3、劳务派遣4 */
    private Integer userCategory;

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
     * @return the parentPosition
     */
    public List<UserLeaderInfo> getParentPosition() {
        return parentPosition;
    }

    /**
     * @param parentPosition
     *            要设置的 parentPosition
     */
    public void setParentPosition(List<UserLeaderInfo> parentPosition) {
        this.parentPosition = parentPosition;
    }

    /**
     * @return the jobCategory
     */
    public Integer getJobCategory() {
        return jobCategory;
    }

    /**
     * @param jobCategory
     *            要设置的 jobCategory
     */
    public void setJobCategory(Integer jobCategory) {
        this.jobCategory = jobCategory;
    }

    /**
     * @return the userStatus
     */
    public Integer getUserStatus() {
        return userStatus;
    }

    /**
     * @param userStatus
     *            要设置的 userStatus
     */
    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    /**
     * @return the userCategory
     */
    public Integer getUserCategory() {
        return userCategory;
    }

    /**
     * @param userCategory
     *            要设置的 userCategory
     */
    public void setUserCategory(Integer userCategory) {
        this.userCategory = userCategory;
    }

}
