/**
 * Copyright(C) 2017 Hangzhou Differsoft Co., Ltd. All rights reserved.
 */
package com.cq.service.common.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cq.common.annotation.DFDatasourceSwitcher;
import com.cq.common.enums.excel.ImportUserLoginHeaders;
import com.cq.common.utils.ExcelDataHeaderMappingUtil;
import com.cq.common.utils.ExcelStartDataUtil;
import com.cq.common.utils.ExportExcelUtils;
import com.cq.common.utils.event.ExcelDataReader;
import com.cq.dao.user.UserLoginDao;
import com.cq.dto.ImportExcelDTO;
import com.cq.dto.user.UserLoginImportExcelDTO;
import com.cq.model.user.UserLogin;
import com.cq.service.common.UserInfoService;

/**
 *
 *
 * @author xus
 * @since 2018-07-03 17:07
 *
 */
@Service
public class UserInfoServiceImpl implements UserInfoService {

    private final static Logger LOG = LoggerFactory.getLogger(UserInfoServiceImpl.class);
    private final static Integer ERROR_BEGIN = 3;

    @Autowired
    private UserLoginDao userLoginDao;

    /**
     * 存放数据名称数组
     */
    private String[] dataDbName = {};
    /**
     * 存放导入Excel映射下标
     */
    private String[] dataPosition = {};
    /**
     * 存放用户Excel表头信息
     */
    private String[] dataUserHead = {};

    @Override
    @DFDatasourceSwitcher
    public List<UserLogin> login(UserLogin user) {
        return userLoginDao.select(user.getUserLoginId(), user.getPassword());
    }

    @Override
    @DFDatasourceSwitcher
    public String getCurrentUserRealName() {
        return null;
    }

    @Override
    @DFDatasourceSwitcher
    public Long getCurrentUserId() {
        return null;
    }

    @Override
    @DFDatasourceSwitcher
    public List<UserLogin> list() {
        return userLoginDao.list();
    }

    @Override
    @DFDatasourceSwitcher
    public Map<String, String> importUserInfoCheck(ImportExcelDTO importDto) {
        // 所需要的数据的位置
        dataDbName = importDto.getHeadValues();
        dataPosition = importDto.getIndexValues();
        dataUserHead = importDto.getUserHeadValues();
        Map<String, String> result = new HashMap<>(10);
        try {
            // 插入数据库，获取错误的信息
            Map<String, String> info = getMsgs(importDto.getPath());
            int successCount = Integer.valueOf(info.get("successCount"));
            int count = Integer.valueOf(info.get("erroCount"));
            if (count == 0) {
                result.put("result", "true");
                result.put("msg", successCount + "条数据导入成功！");
            } else {
                result.put("result", "false");
                result.put("downloadpath", info.get("downloadpath"));
                result.put("msg", successCount + "条数据导入成功！" + count + "条数据有误！");
            }
        } catch (Exception e) {
            result.put("result", "erro");
            result.put("msg", e.getMessage());
            LOG.error("", e);
        }
        return result;
    }

    /**
     * 获取导入正常数据
     *
     * @param urlPath
     *            文件的路径
     * @return
     * @throws Exception
     */
    @DFDatasourceSwitcher
    public Map<String, String> getMsgs(String urlPath) throws Exception {
        Map<String, String> result = new HashMap<>(10);
        // 开始数据库操作
        DbInsert dbInsert = new DbInsert();
        ExcelStartDataUtil.startInsertToDb(urlPath, dbInsert);
        // 获取结果
        Integer successNum = dbInsert.getSuccessNum();
        // 错误数据
        List<List<String>> errorData = dbInsert.getErrorResult();
        // 错误提示
        String errorInfo = dbInsert.getErrorInfo();
        // 上传错误文件，并返回错误文件下载地址
        Map<String, String> err = getErroMsgs(errorData, errorInfo);
        errorData.clear();
        int errocount = Integer.valueOf(err.get("count"));
        if (errocount > 0) {
            result.put("downloadpath", err.get("downloadpath"));
        }
        result.put("successCount", successNum + "");
        result.put("erroCount", errocount + "");
        return result;
    }

    /**
     * 获取错误的消息
     *
     * @param os
     *            错误数据的list集合
     * @param errorInfo
     *            错误消息
     * @return 错误消息
     * @throws IOException
     *             IO错误
     */
    @DFDatasourceSwitcher
    public Map<String, String> getErroMsgs(List<List<String>> os, String errorInfo) throws IOException {
        Map<String, String> result = new HashMap<>();
        ByteArrayOutputStream out = null;
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            // 返回错误Excel第一行显示错误信息
            List<List<String>> erroList = new ArrayList<>();
            List<String> list = new ArrayList<>();
            list.add(errorInfo);
            erroList.add(list);
            // 合并错误数据
            erroList.addAll(os);
            // 文件中sheet的名字
            ExportExcelUtils.exportExcelString(workbook, 0, "导入错误信息", dataUserHead, erroList, out, true);
            // 释放内存
            out = new ByteArrayOutputStream();
            workbook.write(out);
            // InputStream in = new ByteArrayInputStream(out.toByteArray());
            // 上传错误的文件到服务器上
            // JackYunResponse<PutResult> downloadpath = ossUtil.uploadLocalByInputStream(in,
            // "导入错误信息.xlsx", null, true);
            // PutResult data = downloadpath.getResult().getData();
            // String downloadUrl = data.getDownloadUrl();
            // 指定下载地址
            // result.put("downloadpath", downloadUrl + "#导入错误信息" + ".xlsx");
            out.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 错误的条数
        result.put("count", os.size() + "");
        return result;
    }

    /**
     * 校验数据信息和导入操作
     *
     * @since 2018年3月9日 上午10:44:00
     * @author huangyi
     *
     */
    class DbInsert implements ExcelDataReader {

        /**
         * 人员信息集合
         */
        private List<UserLoginImportExcelDTO> userLoginList = new ArrayList<>();
        /**
         * 错误消息
         */
        private List<List<String>> errorResult = new ArrayList<>();

        private Integer successNum = 0;

        /**
         * 表头在第一行，信息提示在第二行，错误行开始在第3行开始
         */
        private Integer errorIndex = ERROR_BEGIN;

        private StringBuilder sb = new StringBuilder("");

        /**
         * @return the successNum
         */
        public Integer getSuccessNum() {
            return successNum;
        }

        /**
         * @return the sb.toString()
         */
        public String getErrorInfo() {
            return sb.toString();
        }

        /**
         * @return the userLoginList
         */
        public List<UserLoginImportExcelDTO> getUserList() {
            return userLoginList;
        }

        /**
         * @return the errorResult
         */
        public List<List<String>> getErrorResult() {
            return errorResult;
        }

        /**
         *
         */
        public void clear() {
            errorResult.clear();
        }

        /**
         * 获取数据操作: 示例
         *
         * @param rowList：一行数据
         */
        @Override
        public void getRows(List<String> rowlist) {
            // 读取完毕返回null
            if (rowlist != null) {
                // 0表示数据正确
                int flag = 0;
                // 数据库名称与用户选择映射关系对应
                Map<String, Integer> mapping = ExcelDataHeaderMappingUtil.getMap(dataDbName, dataPosition);
                UserLoginImportExcelDTO dto = new UserLoginImportExcelDTO();
                // 1. 人员ID
                Integer userIdIndex = mapping.get(ImportUserLoginHeaders.USERID.getCode());
                if (userIdIndex != null) {
                    String userId = rowlist.get(userIdIndex);
                    try {
                        dto.setUserId(Long.parseLong(userId));
                    } catch (Exception e) {
                        flag++;
                        sb.append("第" + (errorIndex) + "行第" + (userIdIndex + 1) + "列数据格式错误；");
                    }
                }
                // 2.登录帐号
                Integer userLoginIdIndex = mapping.get(ImportUserLoginHeaders.USERLOGINID.getCode());
                if (userLoginIdIndex != null) {
                    String userLoginId = rowlist.get(userLoginIdIndex);
                    try {
                        dto.setUserLoginId(Long.parseLong(userLoginId));
                    } catch (Exception e) {
                        flag++;
                        sb.append("第" + (errorIndex) + "行第" + (userLoginIdIndex + 1) + "列数据格式错误；");
                    }
                }
                // 3.密码
                Integer passwordIndex = mapping.get(ImportUserLoginHeaders.PASSWORD.getCode());
                if (passwordIndex != null) {
                    String password = rowlist.get(passwordIndex);
                    try {
                        dto.setPassword(password);
                    } catch (Exception e) {
                        flag++;
                        sb.append("第" + (errorIndex) + "行第" + (passwordIndex + 1) + "列数据格式错误；");
                    }
                }

                if (flag == 0) {
                    // 没有发现错误
                    userLoginList.add(dto);
                    successNum++;
                } else {
                    errorIndex++;
                    List<String> list = new ArrayList<>(rowlist);
                    errorResult.add(list);
                }
            }
            // 返回是否是null end
        }
    }
}