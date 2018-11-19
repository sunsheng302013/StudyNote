package com.cq.model.user;

import java.io.Serializable;
import java.util.Date;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>
 * 类描述: 人员档案上下级关系
 * </p>
 *
 * @since 2018年10月29日
 * @author chengq
 */
public class UserLeaderInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1242587324617188534L;

    /** */
    private Integer id;

    /** 0上级 1下级 */
    private Integer type;

    /** 人员id */
    private Long userId;

    /** 姓名id */
    private Long erpUserId;

    /** 姓名 */
    private String erpUserName;

    /** */
    @JsonSerialize(using = DateConverter.class)
    private Date gmtCreate;

    /** */
    @JsonSerialize(using = DateConverter.class)
    private Date gmtModified;

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
     * @return the type
     */
    public Integer getType() {
        return type;
    }

    /**
     * @param type
     *            要设置的 type
     */
    public void setType(Integer type) {
        this.type = type;
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
     * @return the erpUserId
     */
    public Long getErpUserId() {
        return erpUserId;
    }

    /**
     * @param erpUserId
     *            要设置的 erpUserId
     */
    public void setErpUserId(Long erpUserId) {
        this.erpUserId = erpUserId;
    }

    /**
     * @return the erpUserName
     */
    public String getErpUserName() {
        return erpUserName;
    }

    /**
     * @param erpUserName
     *            要设置的 erpUserName
     */
    public void setErpUserName(String erpUserName) {
        this.erpUserName = erpUserName;
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

    /**
     * @return the gmtModified
     */
    public Date getGmtModified() {
        return gmtModified;
    }

    /**
     * @param gmtModified
     *            要设置的 gmtModified
     */
    public void setGmtModified(Date gmtModified) {
        this.gmtModified = gmtModified;
    }

}