/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

import com.cq.common.enums.user.UserSexEnum;

/**
 * <p>
 * 类描述:人员档案基本资料
 * </p>
 *
 * @since 2018年11月19日
 * @author chengq
 */
public class UserBaseResultTestDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 8644237671586512538L;

    /** 用户头像地址 */
    private String imgUrl;

    /** 用户头像key */
    private String imgKey;

    /** 人员姓名 */
    private String userName;

    /** 性别默认0 男0、女1 */
    private Integer sex;
    private String sexName;

    /** 所属公司名称 */
    private String companyName;

    /** 所属部门名称 **/
    private String mainDepartName;

    /** 职位Name **/
    private List<String> positionNameList;

    /**
     * @return the imgUrl
     */
    public String getImgUrl() {
        return imgUrl;
    }

    /**
     * @param imgUrl
     *            要设置的 imgUrl
     */
    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    /**
     * @return the imgKey
     */
    public String getImgKey() {
        return imgKey;
    }

    /**
     * @param imgKey
     *            要设置的 imgKey
     */
    public void setImgKey(String imgKey) {
        this.imgKey = imgKey;
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
     * @return the sex
     */
    public String getSex() {
        return UserSexEnum.getMsgByCode(sex);
    }

    /**
     * @param sex
     *            要设置的 sex
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * @return the sexName
     */
    public String getSexName() {
        return sexName;
    }

    /**
     * @param sexName
     *            要设置的 sexName
     */
    public void setSexName(String sexName) {
        this.sexName = sexName;
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
     * @return the mainDepartName
     */
    public String getMainDepartName() {
        return mainDepartName;
    }

    /**
     * @param mainDepartName
     *            要设置的 mainDepartName
     */
    public void setMainDepartName(String mainDepartName) {
        this.mainDepartName = mainDepartName;
    }

    /**
     * @return the positionNameList
     */
    public List<String> getPositionNameList() {
        return positionNameList;
    }

    /**
     * @param positionNameList
     *            要设置的 positionNameList
     */
    public void setPositionNameList(List<String> positionNameList) {
        this.positionNameList = positionNameList;
    }

}
