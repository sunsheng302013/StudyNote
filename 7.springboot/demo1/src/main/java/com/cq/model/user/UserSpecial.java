package com.cq.model.user;

import java.io.Serializable;
import java.util.Date;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>
 * 类描述: 人员档案人员和特长关联表
 * </p>
 *
 * @since 2018年10月30日
 * @author chengq
 */
public class UserSpecial implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4142713784203227077L;

    /** */
    private Integer id;

    /** 人员ID */
    private Long userId;

    /** 特长ID */
    private Long specialId;

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
     * @return the specialId
     */
    public Long getSpecialId() {
        return specialId;
    }

    /**
     * @param specialId
     *            要设置的 specialId
     */
    public void setSpecialId(Long specialId) {
        this.specialId = specialId;
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