/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.controller.agendum;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.dto.agendum.AgendumQueryDTO;
import com.cq.dto.agendum.AgendumResultDTO;
import com.cq.service.agendum.AgendumService;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年1月28日
 * @author chengq
 */
@RestController
@RequestMapping("/agendum")
public class AgendumController extends BaseController {

    @Autowired
    private AgendumService agendumService;

    /**
     * 查询日程列表
     *
     * @param query
     *            查询DTO
     * @return 日程list
     */
    @GetMapping("/list")
    public JackYunResponse<Object> listAgendum(AgendumQueryDTO query) {
        List<AgendumResultDTO> agendumResult = agendumService.listAgendumResult(query);
        return sendSuccessData(agendumResult);
    }
}
