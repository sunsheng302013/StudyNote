/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.util.Date;
import java.util.List;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * <p>
 * 类描述:人员档案操作日志
 * </p>
 *
 * @since 2018年11月14日
 * @author chengq
 */
public class UserLogDTO {

    /** */
    private Integer id;

    /** 人员ID */
    private Long userId;

    /** 人员ID列表 **/
    private List<Long> userIdList;

    /** 操作人ID */
    private Long operatorId;

    /** 操作人名称 */
    private String operatorName;

    /** 操作日志 */
    private String logDetail;

    /** */
    @JsonSerialize(using = DateConverter.class)
    private Date gmtCreate;

    /**
     * 默认构造方法
     */
    public UserLogDTO() {
    }

    /**
     * 人员档案日志构造方法
     *
     * @param userIdList
     *            人员ID列表
     * @param operatorId
     *            操作人ID
     * @param operatorName
     *            操作人姓名
     * @param logDetail
     *            日志详情
     */
    public UserLogDTO(List<Long> userIdList, Long operatorId, String operatorName, String logDetail) {
        this.userIdList = userIdList;
        this.operatorId = operatorId;
        this.operatorName = operatorName;
        this.logDetail = logDetail;
    }

    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     *            要设置的 id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return the userId
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            要设置的 userId
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * @return the userIdList
     */
    public List<Long> getUserIdList() {
        return userIdList;
    }

    /**
     * @param userIdList
     *            要设置的 userIdList
     */
    public void setUserIdList(List<Long> userIdList) {
        this.userIdList = userIdList;
    }

    /**
     * @return the operatorId
     */
    public Long getOperatorId() {
        return operatorId;
    }

    /**
     * @param operatorId
     *            要设置的 operatorId
     */
    public void setOperatorId(Long operatorId) {
        this.operatorId = operatorId;
    }

    /**
     * @return the operatorName
     */
    public String getOperatorName() {
        return operatorName;
    }

    /**
     * @param operatorName
     *            要设置的 operatorName
     */
    public void setOperatorName(String operatorName) {
        this.operatorName = operatorName;
    }

    /**
     * @return the logDetail
     */
    public String getLogDetail() {
        return logDetail;
    }

    /**
     * @param logDetail
     *            要设置的 logDetail
     */
    public void setLogDetail(String logDetail) {
        this.logDetail = logDetail;
    }

    /**
     * @return the gmtCreate
     */
    public Date getGmtCreate() {
        return gmtCreate;
    }

    /**
     * @param gmtCreate
     *            要设置的 gmtCreate
     */
    public void setGmtCreate(Date gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

}
