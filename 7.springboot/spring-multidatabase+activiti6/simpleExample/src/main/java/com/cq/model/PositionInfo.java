package com.cq.model;

public class PositionInfo {
    private Integer positionId;

    private String positionName;

    private String postitionFunctional;

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName == null ? null : positionName.trim();
    }

    public String getPostitionFunctional() {
        return postitionFunctional;
    }

    public void setPostitionFunctional(String postitionFunctional) {
        this.postitionFunctional = postitionFunctional == null ? null : postitionFunctional.trim();
    }
}