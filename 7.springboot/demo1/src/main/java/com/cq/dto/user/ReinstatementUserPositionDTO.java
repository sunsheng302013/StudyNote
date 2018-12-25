/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;

/**
 * <p>
 * 类描述:人员档案 复职查询时 职位，职务，职级
 * </p>
 *
 * @since 2018年11月15日
 * @author chengq
 */
public class ReinstatementUserPositionDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8010838925573707751L;

    /** 职位ID **/
    private Long positionId;

    /** 职位名称 **/
    private String positionName;

    /** 职务ID **/
    private Long erpPositionId;

    /** 职务名称 **/
    private String erpPositionName;

    /** 职级ID **/
    private Long rankId;

    /** 职级名称 **/
    private String rankName;

    /**
     * @return the positionName
     */
    public String getPositionName() {
        return positionName;
    }

    /**
     * @param positionName
     *            要设置的 positionName
     */
    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    /**
     * @return the erpPositionId
     */
    public Long getErpPositionId() {
        return erpPositionId;
    }

    /**
     * @param erpPositionId
     *            要设置的 erpPositionId
     */
    public void setErpPositionId(Long erpPositionId) {
        this.erpPositionId = erpPositionId;
    }

    /**
     * @return the erpPositionName
     */
    public String getErpPositionName() {
        return erpPositionName;
    }

    /**
     * @param erpPositionName
     *            要设置的 erpPositionName
     */
    public void setErpPositionName(String erpPositionName) {
        this.erpPositionName = erpPositionName;
    }

    /**
     * @return the rankId
     */
    public Long getRankId() {
        return rankId;
    }

    /**
     * @param rankId
     *            要设置的 rankId
     */
    public void setRankId(Long rankId) {
        this.rankId = rankId;
    }

    /**
     * @return the rankName
     */
    public String getRankName() {
        return rankName;
    }

    /**
     * @param rankName
     *            要设置的 rankName
     */
    public void setRankName(String rankName) {
        this.rankName = rankName;
    }

    /**
     * @return the positionId
     */
    public Long getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     *            要设置的 positionId
     */
    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

}
