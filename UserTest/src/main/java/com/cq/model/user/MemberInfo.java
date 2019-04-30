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
 * @since 2019年4月17日
 * @author chengq
 */
public class MemberInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 6997482585720280111L;

    private Integer Id;

    private Long memberId;

    private String memberName;

    private Long userId;

    private String userName;

    public MemberInfo() {
    }

    public MemberInfo(Long memberId, String memberName, Long userId, String userName) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.userId = userId;
        this.userName = userName;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return Id;
    }

    /**
     * @param id
     *            要设置的 id
     */
    public void setId(Integer id) {
        Id = id;
    }

    /**
     * @return the memberId
     */
    public Long getMemberId() {
        return memberId;
    }

    /**
     * @param memberId
     *            要设置的 memberId
     */
    public void setMemberId(Long memberId) {
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
        return "MemberInfo [Id=" + Id + ", memberId=" + memberId + ", memberName=" + memberName + ", userId=" + userId + ", userName=" + userName + "]";
    }

}
