/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.dto;

import java.io.Serializable;

/**
 * 流转审批DTO
 * 
 * @since 2018年8月29日 上午10:07:56
 * @author huangyi
 *
 */
public class CirculationDTO implements Serializable {

    private static final long serialVersionUID = 6281886550740359136L;

    /** 岗位 **/
    private Integer positionId;

    /** 请假天数 **/
    private Float days;

    /** 代理人 **/
    private String user;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public Float getDays() {
        return days;
    }

    public void setDays(Float days) {
        this.days = days;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    @Override
    public String toString() {
        return "CirculationDTO [positionId=" + positionId + ", days=" + days + ", user=" + user + "]";
    }

}
