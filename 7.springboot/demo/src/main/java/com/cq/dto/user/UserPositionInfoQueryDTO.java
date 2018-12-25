/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述:人员档案-任职情况查询
 * </p>
 *
 * @since 2018年11月12日
 * @author endDateq
 */
public class UserPositionInfoQueryDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 6554547848166682821L;

    /** 任职情况主键ID 导出时使用 **/
    private List<Integer> ids;

    /** 人员ID **/
    private Long userId;

    /** 人员姓名 **/
    private String userName;
    private String userNameLike;

    /** 起始日期 **/
    private String startDate;
    private String startDateEquals;
    private String startDateGte;
    private String startDateLte;
    private String startDateGt;
    private String startDateLt;

    /** 终止日期 **/
    private String endDate;
    private String endDateEquals;
    private String endDateGte;
    private String endDateLte;
    private String endDateGt;
    private String endDateLt;

    /** 职位ID **/
    private String positionId;
    private String positionIdIn;

    /** 职位名称 **/
    private String positionName;
    private String positionNameLike;

    /** 任职单位ID **/
    private String companyId;
    private String companyIdIn;
    private List<Long> companyIds;

    /** 任职单位Name **/
    private String companyName;
    private String companyNameLike;

    /** 任职部门ID **/
    private String departId;
    private String departIdIn;
    private List<Long> departIds;

    /** 任职部门Name **/
    private String departName;
    private String departNameLike;

    /** 是否主职位 0默认 1主职位 **/
    private String isMain;
    private String isMainIn;

    /** 岗位ID **/
    private String erpPositionId;
    private String erpPositionIdIn;
    private List<Long> erpPositionIds;

    /** 职级ID **/
    private String rankId;
    private String rankIdIn;

    /** 直接上级职位ID **/
    private String parentPosition;
    private String parentPositionIn;
    private String parentPositionLike;

    /** 直接管理职位ID **/
    private String subPosition;
    private String subPositionIn;
    private String subPositionLike;

    /**
     * @return the ids
     */
    public List<Integer> getIds() {
        return ids;
    }

    /**
     * @param ids
     *            要设置的 ids
     */
    public void setIds(List<Integer> ids) {
        this.ids = ids;
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
     * @return the userNameLike
     */
    public String getUserNameLike() {
        return userNameLike;
    }

    /**
     * @param userNameLike
     *            要设置的 userNameLike
     */
    public void setUserNameLike(String userNameLike) {
        this.userNameLike = userNameLike;
    }

    /**
     * @return the startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     * @param startDate
     *            要设置的 startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    /**
     * @return the startDateEquals
     */
    public String getStartDateEquals() {
        return startDateEquals;
    }

    /**
     * @param startDateEquals
     *            要设置的 startDateEquals
     */
    public void setStartDateEquals(String startDateEquals) {
        this.startDateEquals = startDateEquals;
    }

    /**
     * @return the startDateGte
     */
    public String getStartDateGte() {
        return startDateGte;
    }

    /**
     * @param startDateGte
     *            要设置的 startDateGte
     */
    public void setStartDateGte(String startDateGte) {
        this.startDateGte = startDateGte;
    }

    /**
     * @return the startDateLte
     */
    public String getStartDateLte() {
        return startDateLte;
    }

    /**
     * @param startDateLte
     *            要设置的 startDateLte
     */
    public void setStartDateLte(String startDateLte) {
        this.startDateLte = startDateLte;
    }

    /**
     * @return the startDateGt
     */
    public String getStartDateGt() {
        return startDateGt;
    }

    /**
     * @param startDateGt
     *            要设置的 startDateGt
     */
    public void setStartDateGt(String startDateGt) {
        this.startDateGt = startDateGt;
    }

    /**
     * @return the startDateLt
     */
    public String getStartDateLt() {
        return startDateLt;
    }

    /**
     * @param startDateLt
     *            要设置的 startDateLt
     */
    public void setStartDateLt(String startDateLt) {
        this.startDateLt = startDateLt;
    }

    /**
     * @return the endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     * @param endDate
     *            要设置的 endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * @return the endDateEquals
     */
    public String getEndDateEquals() {
        return endDateEquals;
    }

    /**
     * @param endDateEquals
     *            要设置的 endDateEquals
     */
    public void setEndDateEquals(String endDateEquals) {
        this.endDateEquals = endDateEquals;
    }

    /**
     * @return the endDateGte
     */
    public String getEndDateGte() {
        return endDateGte;
    }

    /**
     * @param endDateGte
     *            要设置的 endDateGte
     */
    public void setEndDateGte(String endDateGte) {
        this.endDateGte = endDateGte;
    }

    /**
     * @return the endDateLte
     */
    public String getEndDateLte() {
        return endDateLte;
    }

    /**
     * @param endDateLte
     *            要设置的 endDateLte
     */
    public void setEndDateLte(String endDateLte) {
        this.endDateLte = endDateLte;
    }

    /**
     * @return the endDateGt
     */
    public String getEndDateGt() {
        return endDateGt;
    }

    /**
     * @param endDateGt
     *            要设置的 endDateGt
     */
    public void setEndDateGt(String endDateGt) {
        this.endDateGt = endDateGt;
    }

    /**
     * @return the endDateLt
     */
    public String getEndDateLt() {
        return endDateLt;
    }

    /**
     * @param endDateLt
     *            要设置的 endDateLt
     */
    public void setEndDateLt(String endDateLt) {
        this.endDateLt = endDateLt;
    }

    /**
     * @return the positionId
     */
    public String getPositionId() {
        return positionId;
    }

    /**
     * @param positionId
     *            要设置的 positionId
     */
    public void setPositionId(String positionId) {
        this.positionId = positionId;
    }

    /**
     * @return the positionIdIn
     */
    public String getPositionIdIn() {
        return positionIdIn;
    }

    /**
     * @param positionIdIn
     *            要设置的 positionIdIn
     */
    public void setPositionIdIn(String positionIdIn) {
        this.positionIdIn = positionIdIn;
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
     * @return the positionNameLike
     */
    public String getPositionNameLike() {
        return positionNameLike;
    }

    /**
     * @param positionNameLike
     *            要设置的 positionNameLike
     */
    public void setPositionNameLike(String positionNameLike) {
        this.positionNameLike = positionNameLike;
    }

    /**
     * @return the companyId
     */
    public String getCompanyId() {
        return companyId;
    }

    /**
     * @param companyId
     *            要设置的 companyId
     */
    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    /**
     * @return the companyIdIn
     */
    public String getCompanyIdIn() {
        return companyIdIn;
    }

    /**
     * @param companyIdIn
     *            要设置的 companyIdIn
     */
    public void setCompanyIdIn(String companyIdIn) {
        this.companyIdIn = companyIdIn;
    }

    /**
     * @return the departId
     */
    public String getDepartId() {
        return departId;
    }

    /**
     * @param departId
     *            要设置的 departId
     */
    public void setDepartId(String departId) {
        this.departId = departId;
    }

    /**
     * @return the departIdIn
     */
    public String getDepartIdIn() {
        return departIdIn;
    }

    /**
     * @param departIdIn
     *            要设置的 departIdIn
     */
    public void setDepartIdIn(String departIdIn) {
        this.departIdIn = departIdIn;
    }

    /**
     * @return the isMain
     */
    public String getIsMain() {
        return isMain;
    }

    /**
     * @param isMain
     *            要设置的 isMain
     */
    public void setIsMain(String isMain) {
        this.isMain = isMain;
    }

    /**
     * @return the isMainIn
     */
    public String getIsMainIn() {
        return isMainIn;
    }

    /**
     * @param isMainIn
     *            要设置的 isMainIn
     */
    public void setIsMainIn(String isMainIn) {
        this.isMainIn = isMainIn;
    }

    /**
     * @return the erpPositionId
     */
    public String getErpPositionId() {
        return erpPositionId;
    }

    /**
     * @param erpPositionId
     *            要设置的 erpPositionId
     */
    public void setErpPositionId(String erpPositionId) {
        this.erpPositionId = erpPositionId;
    }

    /**
     * @return the erpPositionIdIn
     */
    public String getErpPositionIdIn() {
        return erpPositionIdIn;
    }

    /**
     * @param erpPositionIdIn
     *            要设置的 erpPositionIdIn
     */
    public void setErpPositionIdIn(String erpPositionIdIn) {
        this.erpPositionIdIn = erpPositionIdIn;
    }

    /**
     * @return the rankId
     */
    public String getRankId() {
        return rankId;
    }

    /**
     * @param rankId
     *            要设置的 rankId
     */
    public void setRankId(String rankId) {
        this.rankId = rankId;
    }

    /**
     * @return the rankIdIn
     */
    public String getRankIdIn() {
        return rankIdIn;
    }

    /**
     * @param rankIdIn
     *            要设置的 rankIdIn
     */
    public void setRankIdIn(String rankIdIn) {
        this.rankIdIn = rankIdIn;
    }

    /**
     * @return the parentPosition
     */
    public String getParentPosition() {
        return parentPosition;
    }

    /**
     * @param parentPosition
     *            要设置的 parentPosition
     */
    public void setParentPosition(String parentPosition) {
        this.parentPosition = parentPosition;
    }

    /**
     * @return the subPosition
     */
    public String getSubPosition() {
        return subPosition;
    }

    /**
     * @param subPosition
     *            要设置的 subPosition
     */
    public void setSubPosition(String subPosition) {
        this.subPosition = subPosition;
    }

    /**
     * @return the companyIds
     */
    public List<Long> getCompanyIds() {
        return companyIds;
    }

    /**
     * @param companyIds
     *            要设置的 companyIds
     */
    public void setCompanyIds(List<Long> companyIds) {
        this.companyIds = companyIds;
    }

    /**
     * @return the departIds
     */
    public List<Long> getDepartIds() {
        return departIds;
    }

    /**
     * @param departIds
     *            要设置的 departIds
     */
    public void setDepartIds(List<Long> departIds) {
        this.departIds = departIds;
    }

    /**
     * @return the erpPositionIds
     */
    public List<Long> getErpPositionIds() {
        return erpPositionIds;
    }

    /**
     * @param erpPositionIds
     *            要设置的 erpPositionIds
     */
    public void setErpPositionIds(List<Long> erpPositionIds) {
        this.erpPositionIds = erpPositionIds;
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
     * @return the companyNameLike
     */
    public String getCompanyNameLike() {
        return companyNameLike;
    }

    /**
     * @param companyNameLike
     *            要设置的 companyNameLike
     */
    public void setCompanyNameLike(String companyNameLike) {
        this.companyNameLike = companyNameLike;
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
     * @return the departNameLike
     */
    public String getDepartNameLike() {
        return departNameLike;
    }

    /**
     * @param departNameLike
     *            要设置的 departNameLike
     */
    public void setDepartNameLike(String departNameLike) {
        this.departNameLike = departNameLike;
    }

    /**
     * @return the parentPositionLike
     */
    public String getParentPositionLike() {
        return parentPositionLike;
    }

    /**
     * @param parentPositionLike
     *            要设置的 parentPositionLike
     */
    public void setParentPositionLike(String parentPositionLike) {
        this.parentPositionLike = parentPositionLike;
    }

    /**
     * @return the subPositionLike
     */
    public String getSubPositionLike() {
        return subPositionLike;
    }

    /**
     * @param subPositionLike
     *            要设置的 subPositionLike
     */
    public void setSubPositionLike(String subPositionLike) {
        this.subPositionLike = subPositionLike;
    }

    /**
     * @return the parentPositionIn
     */
    public String getParentPositionIn() {
        return parentPositionIn;
    }

    /**
     * @param parentPositionIn
     *            要设置的 parentPositionIn
     */
    public void setParentPositionIn(String parentPositionIn) {
        this.parentPositionIn = parentPositionIn;
    }

    /**
     * @return the subPositionIn
     */
    public String getSubPositionIn() {
        return subPositionIn;
    }

    /**
     * @param subPositionIn
     *            要设置的 subPositionIn
     */
    public void setSubPositionIn(String subPositionIn) {
        this.subPositionIn = subPositionIn;
    }

}
