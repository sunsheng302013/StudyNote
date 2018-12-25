/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.controller;

import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cq.common.base.BaseController;
import com.cq.common.base.JackYunResponse;
import com.cq.common.enums.ExcelModuleEnum;
import com.cq.common.enums.ImportExcelEnumInterface;
import com.cq.dto.ExcelHeadEnumDTO;
import com.cq.dto.ImportExcelDTO;
import com.cq.service.common.UserInfoService;
import com.cq.service.user.UserLogService;

/**
 * Excel导入接口
 *
 * @since 2017年12月12日 下午2:25:12
 * @author huangyi
 *
 */
@RestController
@RequestMapping(value = "/cq/importexcel")
public class ImportExcelController extends BaseController {

    private final static Logger LOG = LoggerFactory.getLogger(ImportExcelController.class);

    @Autowired
    private UserInfoService userInfoService;

    @Autowired
    private UserLogService userLogService;

    // @RequestMapping(value = "/delete", method = RequestMethod.POST)
    // public JackYunResponse<Object> delete(String fileName) throws IOException {
    // Ssh2Util.deleteFile(fileName);
    // return sendSuccessData(null);
    // }

    /**
     * Excel导入
     *
     * @param importDto
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/import")
    public JackYunResponse<Object> importMsgCheck(ImportExcelDTO importDto) throws IOException {
        // 导入模块
        String importType = importDto.getImportType();
        Map<String, String> importMsgCheck = new HashMap<String, String>(10);
        // 人员登录信息导入
        if (ExcelModuleEnum.USERLOGIN_IMPORT.getName().equals(importType)) {
            importMsgCheck = userInfoService.importUserInfoCheck(importDto);
        }
        return sendSuccessData(importMsgCheck);
    }

    /**
     *
     *
     * Excel导入展示给前端
     *
     * @param importDto
     * @return
     * @throws IOException
     */
    @PostMapping(value = "/show/import")
    public JackYunResponse<Object> showImport(ImportExcelDTO importDto) throws IOException {
        // 导入模块
        String importType = importDto.getImportType();
        Map<String, Object> importMsgCheck = new HashMap<String, Object>(10);

        if (ExcelModuleEnum.USERLOGIN_IMPORT.getName().equals(importType)) {
            // 人员档案日志
            importMsgCheck = userLogService.importUserLogCheck(importDto);
        }
        return sendSuccessData(importMsgCheck);
    }

    /**
     * Excel导入获取数据库字段信息
     *
     * @param name
     * @return
     */
    @GetMapping(value = "/getdatasourcelist")
    public JackYunResponse<Object> getexcelHeadList(String name) {
        List<ExcelHeadEnumDTO> headList = new ArrayList<>(100);
        List<String> packageList = Arrays.asList("excel.");
        for (String pkg : packageList) {
            try {
                Class<?> onwClass = Class.forName("com.cq.common.enums." + pkg + name);
                Method method = onwClass.getMethod("values");
                ImportExcelEnumInterface[] inter = (ImportExcelEnumInterface[]) method.invoke(null);
                for (ImportExcelEnumInterface enumMessage : inter) {
                    ExcelHeadEnumDTO dto = new ExcelHeadEnumDTO();
                    dto.setCode(enumMessage.getCode());
                    dto.setMsg(enumMessage.getMsg());
                    dto.setRequired(enumMessage.getRequired());
                    headList.add(dto);
                }
                return sendSuccessData(headList);
            } catch (Exception e) {
                LOG.error("Excel导入获取数据库字段信息出错");
            }
        }
        return sendSuccessData(null);
    }

}
