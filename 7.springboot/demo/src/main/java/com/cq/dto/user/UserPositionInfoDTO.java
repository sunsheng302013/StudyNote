/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.cq.common.convert.DateConverterPlus;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * <p>
 * 类描述: 人员档案任职情况
 * </p>
 *
 * @since 2018年10月15日
 * @author chengq
 */
public class UserPositionInfoDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 4104156089886839639L;

    /** 任职情况主键ID **/
    private Integer id;

    /** 人员ID **/
    private Long userId;

    /** 人员姓名 **/
    private String userName;

    /** 人员对象列表 **/
    private List<Long> userIdList;

    /** 职位ID **/
    private Long positionId;

    /** 职位Name **/
    private String positionName;

    /** 目标职位ID **/
    private Long newPositionId;

    /** 任职单位ID **/
    private Long companyId;

    /** 任职单位Name **/
    private String companyName;

    /** 任职部门ID **/
    private Long departId;

    /** 任职部门Name **/
    private String departName;

    /** 是否主职位 0默认 1主职位 **/
    private Integer isMain;

    /** 岗位ID **/
    private Long erpPositionId;

    /** 岗位Name **/
    private String erpPositionName;

    /** 职级ID **/
    private Long rankId;

    /** 职级Name **/
    private String rankName;

    /** 直接上级职位 **/
    private List<ShowPositionDTO> parentPosition;

    /** 直接管理职位 **/
    private List<ShowPositionDTO> subPosition;

    /** 起始日期 **/
    @JsonSerialize(using = DateConverterPlus.class)
    private Date startDate;

    /** 终止日期 **/
    @JsonSerialize(using = DateConverterPlus.class)
    private Date endDate;

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
     * @return the userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * @param userName
     *            要设置的 userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return the newPositionId
     */
    public Long getNewPositionId() {
        return newPositionId;
    }

    /**
     * @param newPositionId
     *            要设置的 newPositionId
     */
    public void setNewPositionId(Long newPositionId) {
        this.newPositionId = newPositionId;
    }

    /**
     * @return the companyId
     */
    public Long getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     *            要设置的 companyId
     */
    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the companyName
     */
    public String getCompanyName() {
        return companyName;
    }

    /**
     * @param companyName
     *            要设置的 companyName
     */
    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    /**
     * @return the departId
     */
    public Long getDepartId() {
        return departId;
    }

    /**
     * @param departId
     *            要设置的 departId
     */
    public void setDepartId(Long departId) {
        this.departId = departId;
    }

    /**
     * @return the departName
     */
    public String getDepartName() {
        return departName;
    }

    /**
     * @param departName
     *            要设置的 departName
     */
    public void setDepartName(String departName) {
        this.departName = departName;
    }

    /**
     * @return the isMain
     */
    public Integer getIsMain() {
        return isMain;
    }

    /**
     * @param isMain
     *            要设置的 isMain
     */
    public void setIsMain(Integer isMain) {
        this.isMain = isMain;
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
     * @return the parentPosition
     */
    public List<ShowPositionDTO> getParentPosition() {
        return parentPosition;
    }

    /**
     * @param parentPosition
     *            要设置的 parentPosition
     */
    public void setParentPosition(List<ShowPositionDTO> parentPosition) {
        this.parentPosition = parentPosition;
    }

    /**
     * @return the subPosition
     */
    public List<ShowPositionDTO> getSubPosition() {
        return subPosition;
    }

    /**
     * @param subPosition
     *            要设置的 subPosition
     */
    public void setSubPosition(List<ShowPositionDTO> subPosition) {
        this.subPosition = subPosition;
    }

    /**
     * @return the startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            要设置的 startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            要设置的 endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
