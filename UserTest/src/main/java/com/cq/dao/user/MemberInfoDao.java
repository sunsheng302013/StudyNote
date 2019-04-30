/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.user;

import org.apache.ibatis.annotations.Mapper;

import com.cq.model.user.MemberInfo;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
@Mapper
public interface MemberInfoDao {

    /**
     * 根据memberName获取会员信息
     * 
     * @param memberName
     *            会员名称
     * @return 会员信息
     */
    MemberInfo getByMemberName(String memberName);
}
