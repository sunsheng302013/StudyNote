/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.enums;

/**
 * @since 2018年9月5日 上午10:28:19
 * @author chengq
 *
 */
public enum ResultCode {

    /**
     * 第1位：预留字段，默认0
     *
     * 2,3位：系统大类（仓储作业系统WMS：05）
     *
     * 4,5位：模块 (系统级公共错误为00,设置-库区目录01，设置-货位目录02，设置-周转策略03，设置-分配策略04，设置-波次策略05，设置-补货策略06，设置-上架策略07,
     * 出库验货12)
     *
     * 6位：错误等级0~9，从低到高
     *
     * 7到10位：错误码
     *
     * 接口返回信息枚举类型
     */
    // common
    // common
    SUCCESS("200", "操作成功"),

    /** 500 **/
    ERROR("500", "操作失败"),

    /** 内部错误 **/
    INTERNAL_ERROR("0140090001", "内部错误，请稍后重试"),

    /** 参数错误 **/
    PARAMETER_ERROR("0140090002", "参数错误"),

    /** 流程名已存在 **/
    FLOW_NAME_EXIST("0140110001", "流程名称已存在，请重新填写！"),

    /** 流程分类已存在 **/
    CATEGORY_NAME_EXIST("0140110002", "分类名称已存在，请重新填写！"),

    /** 分合流名称已存在 **/
    GATEWAY_EXIST("0140110003", "此分合流名称已存在，请重新填写！"),

    /** 流程配置错误 **/
    FLOW_DEPLOY_ERROR("0140110004", "流程配置错误，请修改，详见：检查项目的内容！"),

    /** 流程步骤不存在 **/
    FLOW_STEP_NOT_EXIST("0140110005", "流程步骤不存在，请重新配置！"),

    /** 开始事件不存在 **/
    START_NODE_NOT_EXIST("0140110006", "开始事件不存在，请重新配置！"),

    /** 开始事件只能唯一 **/
    START_NODE_EXIST_MORE("0140110007", "开始事件只能唯一，请重新配置！"),

    /** 结束事件不存在 **/
    END_NODE_NOT_EXIST("0140110008", "结束事件不存在，请重新配置！"),

    /** 结束事件只能唯一 **/
    END_NODE_EXIST_MORE("0140110009", "结束事件只能唯一，请重新配置！"),

    /** 用户任务不存在 **/
    USER_TASK_NOT_EXIST("0140110010", "用户任务不存在，请重新配置！"),

    /** 流程审批错误模块02 **/
    DOWNLOAD_FAIL("0140210001", "文件获取失败！"),

    /** 职级名称已存在03 **/
    RANK_NAME_EXIST("0140310001", "职级名称已存在，请重新填写！"),

    /** 职位名称已存在 **/
    POSITION_NAME_EXIST("0140310002", "此职位名称已存在，请重新填写！"),

    /** 职位已撤销 **/
    POSITION_IS_CANCEL("0140310003", "此职位已撤销，不能合并！"),

    /** 职位与目标职位相同 **/
    POSITION_IS_SAME("0140310004", "职位与目标职位相同，不能合并！"),

    /** 身份校验模块 04-身份证格式不正确 **/
    IDCARD_IS_FAIL("0140410004", "身份证格式不正确，不能录入！"),

    /** 身份校验模块 -身份信息已存在 **/
    IDCARD_EXIST("0140410005", "身份证已经存在，不能录入！"),

    /** 停职 固定表单05 **/
    SUSPENSION_EXIST("0140510001", " 正在审批，不能重复发起！"),

    /** 复职 **/
    REINSTATEMENT_EXIST("0140510002", "正在审批，不能重复发起！"),

    /** 转正流程已存在 **/
    REGULAR_EXIST("0140510003", " 正在审批，不能重复发起！"),

    /** 离职流程已存在 **/
    LEAVE_EXIST("0140510004", " 正在审批，不能重复发起！"),

    /** 用户登录失败 **/
    REPEAT_PRINT_LOGIN_FAIL("0140510005", " 用户登录失败，请重新登录！");

    private String code;
    private String msg;

    /**
     *
     * @param code
     *            要设置的code
     * @param msg
     *            要设置的msg
     */
    ResultCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code
     *            要设置的 code
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg
     *            要设置的 msg
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

}
