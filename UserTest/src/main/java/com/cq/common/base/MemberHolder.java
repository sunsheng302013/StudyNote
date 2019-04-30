/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.base;

import com.cq.model.user.MemberInfo;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
public class MemberHolder {

    /** 初始化方法 **/
    protected MemberHolder() {
    }

    /** 会员信息线程变量 **/
    private static final ThreadLocal<MemberInfo> MEMBER_INFO = new ThreadLocal<>();

    /**
     * 设置会员信息
     *
     * @param memberInfo
     *            会员信息
     */
    public static void bindMember(MemberInfo memberInfo) {
        MEMBER_INFO.set(memberInfo);
    }

    /**
     * 解绑会员信息
     *
     * @return 会员信息
     */
    public static MemberInfo unbindMember() {

        MemberInfo memberInfo = MEMBER_INFO.get();

        MEMBER_INFO.remove();

        return memberInfo;
    }

    /**
     * 获取会员信息
     *
     * @return 会员信息
     */
    public static MemberInfo getMemberInfo() {
        return MEMBER_INFO.get();
    }

    /**
     *
     * 获取会员ID
     *
     * @return 会员ID
     */
    public static Long getMemberId() {
        MemberInfo memberInfo = getMemberInfo();
        if (null != memberInfo) {
            memberInfo.getMemberId();
        }
        return null;
    }

    /**
     *
     * 获取会员名
     *
     * @return 会员名
     */
    public static String getMemberName() {
        MemberInfo memberInfo = getMemberInfo();
        if (null != memberInfo) {
            return memberInfo.getMemberName();
        }
        return "";
    }

    /**
     * 获取用户ID
     *
     * @return 获取用户ID
     */
    public static Long getUserId() {
        MemberInfo memberInfo = getMemberInfo();
        if (null != memberInfo) {
            return memberInfo.getUserId();
        }
        return null;
    }

    /**
     * 获取用户名称
     *
     * @return 用户名称
     */
    public static String getUserName() {
        MemberInfo memberInfo = getMemberInfo();
        if (null != memberInfo) {
            return memberInfo.getUserName();
        }
        return "";
    }
}
