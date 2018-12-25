package com.cq.model.user;

import java.io.Serializable;
import java.util.Date;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>
 * 类描述: 人员档案操作日志
 * </p>
 *
 * @since 2018年11月6日
 * @author chengq
 */
public class UserLog implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 4897990429492328857L;

    /** */
    private Integer id;

    /** 人员ID */
    private Long userId;

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
    public UserLog() {
    }

    /**
     * 人员档案日志构造方法
     *
     * @param userId
     *            人员ID
     * @param operatorId
     *            操作人ID
     * @param operatorName
     *            操作人姓名
     * @param logDetail
     *            日志详情
     */
    public UserLog(Long userId, Long operatorId, String operatorName, String logDetail) {
        this.userId = userId;
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