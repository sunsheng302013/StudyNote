/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;
import java.util.List;

/**
 * 导出参数DTO
 *
 * @since 2018年3月20日 下午3:38:47
 * @author chengq
 *
 */
public class ExportExcelDTO implements Serializable {

    private static final long serialVersionUID = -7682870631610567685L;

    private List<String> enName;

    private List<String> showName;

    /**
     * @return the enName
     */
    public List<String> getEnName() {
        return enName;
    }

    /**
     * @param enName
     *            要设置的 enName
     */
    public void setEnName(List<String> enName) {
        this.enName = enName;
    }

    /**
     * @return the showName
     */
    public List<String> getShowName() {
        return showName;
    }

    /**
     * @param showName
     *            要设置的 showName
     */
    public void setShowName(List<String> showName) {
        this.showName = showName;
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ExportExcelDTO [enName=");
        builder.append(enName);
        builder.append(", showName=");
        builder.append(showName);
        builder.append("]");
        return builder.toString();
    }

}
