package com.cq.model.file;

import java.io.Serializable;
import java.util.Date;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 *
 * <p>
 * 类描述: 附件信息
 * </p>
 *
 * @since 2018年11月5日
 * @author chengq
 */
public class File implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 2517360244500039207L;

    /** */
    private Integer id;

    /** 外键id */
    private Long foreignId;

    /** 附件地址 */
    private String fileUrl;

    /** 附件key */
    private String fileKey;

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
     * @return the foreignId
     */
    public Long getForeignId() {
        return foreignId;
    }

    /**
     * @param foreignId
     *            要设置的 foreignId
     */
    public void setForeignId(Long foreignId) {
        this.foreignId = foreignId;
    }

    /**
     * @return the fileUrl
     */
    public String getFileUrl() {
        return fileUrl;
    }

    /**
     * @param fileUrl
     *            要设置的 fileUrl
     */
    public void setFileUrl(String fileUrl) {
        this.fileUrl = fileUrl;
    }

    /**
     * @return the fileKey
     */
    public String getFileKey() {
        return fileKey;
    }

    /**
     * @param fileKey
     *            要设置的 fileKey
     */
    public void setFileKey(String fileKey) {
        this.fileKey = fileKey;
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