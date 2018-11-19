package com.cq.model.user;

import java.io.Serializable;
import java.util.Date;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>
 * 类描述:人员档案-技能特长
 * </p>
 *
 * @since 2018年10月31日
 * @author chengq
 */
public class UserSpecialInfo implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2673604320507061376L;

    /** */
    private Integer id;

    /** 技能特长ID */
    private Long specialId;

    /** 技能特长名称 */
    private String specialName;

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
     * @return the specialName
     */
    public String getSpecialName() {
        return specialName;
    }

    /**
     * @param specialName
     *            要设置的 specialName
     */
    public void setSpecialName(String specialName) {
        this.specialName = specialName;
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