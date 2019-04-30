/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.user;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
public interface MemberInfoService {

    /**
     * 根据memberName判断查询是否合法
     *
     * @param memberName
     *            会员名称
     */
    void examineMemberInfo(String memberName);

}
