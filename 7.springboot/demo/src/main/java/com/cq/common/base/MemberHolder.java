/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.base;

import com.cq.model.user.MemberInfo;

/**
 * <p>
 * 类描述: 会员信息上下文
 * </p>
 *
 * @since 2018年11月19日
 * @author chengq
 */
public class MemberHolder {

    /** 会员信息线程变量 **/
    private final static ThreadLocal<MemberInfo> MEMBER_INFO = new ThreadLocal<>();

    /**
     * 设置会员信息
     *
     * @param memberInfo：会员信息
     */
    public static void bindMember(MemberInfo memberInfo) {
        MEMBER_INFO.set(memberInfo);
    }

    /**
     * 解绑会员信息
     *
     * @return
     */
    public static MemberInfo unbindMember() {

        MemberInfo memberInfo = MEMBER_INFO.get();

        MEMBER_INFO.remove();

        return memberInfo;
    }

    /**
     * 获取会员信息
     *
     * @return
     */
    public static MemberInfo getMemberInfo() {
        return MEMBER_INFO.get();
    }

    /**
     *
     * @desc 获取会员ID
     *
     * @return
     */
    public static String getMemberId() {
        MemberInfo memberInfo = getMemberInfo();
        return memberInfo == null ? null : memberInfo.getMemberId();
    }

    /**
     *
     * @desc 获取会员名
     *
     * @return
     */
    public static String getMemberName() {
        MemberInfo memberInfo = getMemberInfo();
        return memberInfo == null ? null : memberInfo.getMemberName();
    }

    /**
     * 获取用户ID
     *
     * @return
     */
    public static String getUserId() {
        MemberInfo member = getMemberInfo();
        return member == null ? null : member.getUserId();
    }

    /**
     * 获取用户名称
     *
     * @return
     */
    public static String getUserName() {
        MemberInfo member = getMemberInfo();
        return member == null ? null : member.getUserName();
    }
}
