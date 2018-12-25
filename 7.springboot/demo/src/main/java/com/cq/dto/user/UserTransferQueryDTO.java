/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述: 人员职位调动查询 停职/离职/复职/转正
 * </p>
 *
 * @since 2018年11月13日
 * @author chengq
 */
public class UserTransferQueryDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -5860577648418649500L;

    /** 人事调动类型 0停职，1复职，2离职，3转正 **/
    private Integer transferType;

    /** 人员状态 0在职 1不在职 2停职 3离职 4退休 5借调 **/
    private List<Integer> userStatusList;

    /** 符合查询条件的人员ID **/
    private List<Long> userIdList;

    /** 部门ID **/
    private Long departId;

    /** erp人员ID **/
    private Long erpUserId;

    /** 人员姓名 **/
    private String userNameLike;

    /** 所属公司 **/
    private List<Long> companyIds;

    /** 所属部门 **/
    private List<Long> departIds;

    /**
     * @return the transferType
     */
    public Integer getTransferType() {
        return transferType;
    }

    /**
     * @param transferType
     *            要设置的 transferType
     */
    public void setTransferType(Integer transferType) {
        this.transferType = transferType;
    }

    /**
     * @return the userStatusList
     */
    public List<Integer> getUserStatusList() {
        return userStatusList;
    }

    /**
     * @param userStatusList
     *            要设置的 userStatusList
     */
    public void setUserStatusList(List<Integer> userStatusList) {
        this.userStatusList = userStatusList;
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
     * @return the departId
     */
    public Long getDepartId() {
        return departId;
    }

    /**
     * @param departId
     *            要设置的 departId
     */
    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    /**
     * @return the erpUserId
     */
    public Long getErpUserId() {
        return erpUserId;
    }

    /**
     * @param erpUserId
     *            要设置的 erpUserId
     */
    public void setErpUserId(Long erpUserId) {
        this.erpUserId = erpUserId;
    }

    /**
     * @return the userNameLike
     */
    public String getUserNameLike() {
        return userNameLike;
    }

    /**
     * @param userNameLike
     *            要设置的 userNameLike
     */
    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }

    /**
     * @return the companyIds
     */
    public List<Long> getCompanyIds() {
        return companyIds;
    }

    /**
     * @param companyIds
     *            要设置的 companyIds
     */
    public void setCompanyIds(List<Long> companyIds) {
        this.companyIds = companyIds;
    }

    /**
     * @return the departIds
     */
    public List<Long> getDepartIds() {
        return departIds;
    }

    /**
     * @param departIds
     *            要设置的 departIds
     */
    public void setDepartIds(List<Long> departIds) {
        this.departIds = departIds;
    }

}
