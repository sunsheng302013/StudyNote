/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dao.agendum;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.cq.dto.agendum.AgendumQueryDTO;
import com.cq.dto.agendum.AgendumResultDTO;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
@Mapper
public interface AgendumDao {

    /**
     * 查询日程
     *
     * @author chengq
     * @param query
     *            查询条件
     * @return 日程列表
     */
    List<AgendumResultDTO> listAgendumResult(@Param(value = "query") AgendumQueryDTO query);

}
