/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.test.lambda;

import java.io.Serializable;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2019年3月7日
 * @author chengq
 */
public class Test implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -2179283055153390234L;

    /** */
    private Integer id;

    /** 考勤地点id */
    private Long locationId;

    /** 考勤地点 */
    private String locationName;

    public Test() {
    }

    public Test(Long locationId) {
        this.locationId = locationId;
        this.locationName = "";
    }

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
     * @return the locationId
     */
    public Long getLocationId() {
        return locationId;
    }

    /**
     * @param locationId
     *            要设置的 locationId
     */
    public void setLocationId(Long locationId) {
        this.locationId = locationId;
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

    @Override
    public String toString() {
        return "Test [id=" + id + ", locationId=" + locationId + ", locationName=" + locationName + "]";
    }

}
