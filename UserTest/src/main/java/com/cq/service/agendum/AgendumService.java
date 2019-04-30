/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.service.agendum;

import java.util.List;

import com.cq.dto.ExportExcelDTO;
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
public interface AgendumService {

    /**
     * 查询日程
     *
     * @author chengq
     * @param query
     *            查询条件
     * @return 日程列表
     */
    List<AgendumResultDTO> listAgendumResult(AgendumQueryDTO query);

    /**
     * 导出
     *
     * @param query
     *            查询参数
     * @param exportExcelDTO
     *            导出条件
     * @return 导出数据
     */
    List<List<Object>> export(AgendumQueryDTO query, ExportExcelDTO exportExcelDTO);
}
