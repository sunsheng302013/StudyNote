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
 * @since 2018年11月26日
 * @author chengq
 */
public class UserLeaderInfoDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1160256666508953002L;

    /** OA人员ID **/
    private Long userRealId;

    /** erp人员id */
    private Long userId;
    private Long erpUserId;

    /** 姓名 */
    private String realName;
    private String erpUserName;

    /** 0 leader上级，1 subordinate下级 **/
    private Integer type;
    private String relation;

    /**
     * @return the type
     */
    public Integer getType() {
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
     * @return the userRealId
     */
    public Long getUserRealId() {
        return userRealId;
    }

    /**
     * @param userRealId
     *            要设置的 userRealId
     */
    public void setUserRealId(Long userRealId) {
        this.userRealId = userRealId;
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
     * @return the relation
     */
    public String getRelation() {
        return relation;
    }

    /**
     * @param relation
     *            要设置的 relation
     */
    public void setRelation(String relation) {
        this.relation = relation;
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
     * @return the erpUserName
     */
    public String getErpUserName() {
        return erpUserName;
    }

    /**
     * @param erpUserName
     *            要设置的 erpUserName
     */
    public void setErpUserName(String erpUserName) {
        this.erpUserName = erpUserName;
    }

}
