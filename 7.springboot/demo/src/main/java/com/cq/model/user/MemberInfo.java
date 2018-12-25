/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.model.user;

import java.io.Serializable;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月19日
 * @author chengq
 */
public class MemberInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 1146038678822932856L;

    /** 用户ID **/
    private String userId;

    /** 用户名 **/
    private String userName;

    /** 集群ID **/
    private String groupId;

    /** 会员ID **/
    private String memberId;

    /** 会员名 **/
    private String memberName;

    /** 用户所拥有的权限 **/
    private String userRoles;

    /** 字段读取权限等级（默认0：无权限） **/
    private int fieldReadRank = 1;

    /** 会员需要灰度的服务列表，多个以英文逗号隔开 */
    private String greyServiceList;

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
     * @return the groupId
     */
    public String getGroupId() {
        return groupId;
    }

    /**
     * @param groupId
     *            要设置的 groupId
     */
    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    /**
     * @return the memberId
     */
    public String getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     *            要设置的 memberId
     */
    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    /**
     * @return the memberName
     */
    public String getMemberName() {
        return memberName;
    }

    /**
     * @param memberName
     *            要设置的 memberName
     */
    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    /**
     * @return the userRoles
     */
    public String getUserRoles() {
        return userRoles;
    }

    /**
     * @param userRoles
     *            要设置的 userRoles
     */
    public void setUserRoles(String userRoles) {
        this.userRoles = userRoles;
    }

    /**
     * @return the fieldReadRank
     */
    public int getFieldReadRank() {
        return fieldReadRank;
    }

    /**
     * @param fieldReadRank
     *            要设置的 fieldReadRank
     */
    public void setFieldReadRank(int fieldReadRank) {
        this.fieldReadRank = fieldReadRank;
    }

    /**
     * @return the greyServiceList
     */
    public String getGreyServiceList() {
        return greyServiceList;
    }

    /**
     * @param greyServiceList
     *            要设置的 greyServiceList
     */
    public void setGreyServiceList(String greyServiceList) {
        this.greyServiceList = greyServiceList;
    }

}
