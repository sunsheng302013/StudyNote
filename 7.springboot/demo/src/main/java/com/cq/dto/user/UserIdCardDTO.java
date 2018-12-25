/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.Date;

import com.cq.common.convert.DateConverter;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * <p>
 * 类描述: 身份证解析信息
 * </p>
 *
 * @since 2018年11月23日
 * @author chengq
 */
public class UserIdCardDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7384711438555106628L;

    /** 出生日期 */
    @JsonSerialize(using = DateConverter.class)
    private Date birthdate;

    /** 年龄 */
    private Integer age;

    /** 性别默认0 男0、女1 */
    private Integer sex;

    /** 籍贯 **/
    private String birthPlace;

    /** 省 */
    private String province;

    /** 市 */
    private String city;

    /**
     * @return the birthdate
     */
    public Date getBirthdate() {
        return birthdate;
    }

    /**
     * @param birthdate
     *            要设置的 birthdate
     */
    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    /**
     * @return the age
     */
    public Integer getAge() {
        return age;
    }

    /**
     * @param age
     *            要设置的 age
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * @return the sex
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * @param sex
     *            要设置的 sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the birthPlace
     */
    public String getBirthPlace() {
        return birthPlace;
    }

    /**
     * @param birthPlace
     *            要设置的 birthPlace
     */
    public void setBirthPlace(String birthPlace) {
        this.birthPlace = birthPlace;
    }

    /**
     * @return the province
     */
    public String getProvince() {
        return province;
    }

    /**
     * @param province
     *            要设置的 province
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * @return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city
     *            要设置的 city
     */
    public void setCity(String city) {
        this.city = city;
    }

}
