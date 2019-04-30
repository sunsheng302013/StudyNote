/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.agendum;

import java.io.Serializable;

import com.cq.model.agendum.Agendum;

/**
 * <p>
 * 类描述:日程返回结果
 * </p>
 *
 * @since 2019年4月15日
 * @author chengq
 */
public class AgendumResultDTO extends Agendum implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -1743307161381568780L;

    /** 是否有操作权限0否，1是 **/
    private Integer isUpdate;

    /** 是否可查看 **/
    private Integer isScan;

    /** 日程显示标题 **/
    private String agendumTitle;

    /**
     * @return the isUpdate
     */
    public Integer getIsUpdate() {
        return isUpdate;
    }

    /**
     * @param isUpdate
     *            要设置的 isUpdate
     */
    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    /**
     * @return the isScan
     */
    public Integer getIsScan() {
        return isScan;
    }

    /**
     * @param isScan
     *            要设置的 isScan
     */
    public void setIsScan(Integer isScan) {
        this.isScan = isScan;
    }

    /**
     * @return the agendumTitle
     */
    public String getAgendumTitle() {
        return agendumTitle;
    }

    /**
     * @param agendumTitle
     *            要设置的 agendumTitle
     */
    public void setAgendumTitle(String agendumTitle) {
        this.agendumTitle = agendumTitle;
    }

    @Override
    public String toString() {
        return "AgendumResultDTO [isUpdate=" + isUpdate + ", isScan=" + isScan + "]";
    }

}
