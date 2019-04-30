package com.cq.model.agendum;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * <p>
 * 类描述: 日程管理
 * </p>
 *
 * @since 2019年4月17日
 * @author chengq
 */
public class Agendum implements Serializable {
    /** serialVersionUID */
    private static final long serialVersionUID = 3467747040627832583L;

    /** */
    private Integer id;

    /** 日程ID */
    private Long agendumId;

    /** 日程标题 */
    private String title;

    /** 开始时间 */
    private Date startTime;

    /** 结束时间 */
    private Date endTime;

    /** 地点 */
    private String locationName;

    /** 参与人员Id */
    private Long participantUserId;

    /** 参与人员姓名 */
    private String participantUserName;

    /** 创建人员Id */
    private Long createUserId;

    /** 创建人员姓名 */
    private String createUserName;

    /** 日程内容 */
    private String content;

    /** 默认0 1正常(上级可见) 2自己可见 3公开 */
    private Integer roleType;

    /** 是否全天 0默认 1是 */
    private Integer isWholeDay;

    /** 是否重要日程 0默认 1是 */
    private Integer isImportant;

    /** 是否共享 0默认 1是 */
    private Integer isShare;

    /** 共享组Id */
    private Long shareGroupId;

    /** 共享组名称 */
    private String shareGroupName;

    /** */
    private Date gmtCreate;

    /** */
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
     * @return the agendumId
     */
    public Long getAgendumId() {
        return agendumId;
    }

    /**
     * @param agendumId
     *            要设置的 agendumId
     */
    public void setAgendumId(Long agendumId) {
        this.agendumId = agendumId;
    }

    /**
     * @return the title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title
     *            要设置的 title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return the startTime
     */
    public Date getStartTime() {
        return startTime;
    }

    /**
     * @param startTime
     *            要设置的 startTime
     */
    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    /**
     * @return the endTime
     */
    public Date getEndTime() {
        return endTime;
    }

    /**
     * @param endTime
     *            要设置的 endTime
     */
    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    /**
     * @return the locationName
     */
    public String getLocationName() {
        return locationName;
    }

    /**
     * @param locationName
     *            要设置的 locationName
     */
    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }

    /**
     * @return the participantUserId
     */
    public Long getParticipantUserId() {
        return participantUserId;
    }

    /**
     * @param participantUserId
     *            要设置的 participantUserId
     */
    public void setParticipantUserId(Long participantUserId) {
        this.participantUserId = participantUserId;
    }

    /**
     * @return the participantUserName
     */
    public String getParticipantUserName() {
        return participantUserName;
    }

    /**
     * @param participantUserName
     *            要设置的 participantUserName
     */
    public void setParticipantUserName(String participantUserName) {
        this.participantUserName = participantUserName;
    }

    /**
     * @return the createUserId
     */
    public Long getCreateUserId() {
        return createUserId;
    }

    /**
     * @param createUserId
     *            要设置的 createUserId
     */
    public void setCreateUserId(Long createUserId) {
        this.createUserId = createUserId;
    }

    /**
     * @return the createUserName
     */
    public String getCreateUserName() {
        return createUserName;
    }

    /**
     * @param createUserName
     *            要设置的 createUserName
     */
    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName;
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content
     *            要设置的 content
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * @return the roleType
     */
    public Integer getRoleType() {
        return roleType;
    }

    /**
     * @param roleType
     *            要设置的 roleType
     */
    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    /**
     * @return the isWholeDay
     */
    public Integer getIsWholeDay() {
        return isWholeDay;
    }

    /**
     * @param isWholeDay
     *            要设置的 isWholeDay
     */
    public void setIsWholeDay(Integer isWholeDay) {
        this.isWholeDay = isWholeDay;
    }

    /**
     * @return the isImportant
     */
    public Integer getIsImportant() {
        return isImportant;
    }

    /**
     * @param isImportant
     *            要设置的 isImportant
     */
    public void setIsImportant(Integer isImportant) {
        this.isImportant = isImportant;
    }

    /**
     * @return the isShare
     */
    public Integer getIsShare() {
        return isShare;
    }

    /**
     * @param isShare
     *            要设置的 isShare
     */
    public void setIsShare(Integer isShare) {
        this.isShare = isShare;
    }

    /**
     * @return the shareGroupId
     */
    public Long getShareGroupId() {
        return shareGroupId;
    }

    /**
     * @param shareGroupId
     *            要设置的 shareGroupId
     */
    public void setShareGroupId(Long shareGroupId) {
        this.shareGroupId = shareGroupId;
    }

    /**
     * @return the shareGroupName
     */
    public String getShareGroupName() {
        return shareGroupName;
    }

    /**
     * @param shareGroupName
     *            要设置的 shareGroupName
     */
    public void setShareGroupName(String shareGroupName) {
        this.shareGroupName = shareGroupName;
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

    @Override
    public String toString() {
        return "Agendum [id=" + id + ", agendumId=" + agendumId + ", title=" + title + ", startTime=" + startTime + ", endTime=" + endTime + ", locationName="
                + locationName + ", participantUserId=" + participantUserId + ", participantUserName=" + participantUserName + ", createUserId=" + createUserId
                + ", createUserName=" + createUserName + ", content=" + content + ", roleType=" + roleType + ", isWholeDay=" + isWholeDay + ", isImportant="
                + isImportant + ", isShare=" + isShare + ", shareGroupId=" + shareGroupId + ", shareGroupName=" + shareGroupName + ", gmtCreate=" + gmtCreate
                + ", gmtModified=" + gmtModified + "]";
    }

}