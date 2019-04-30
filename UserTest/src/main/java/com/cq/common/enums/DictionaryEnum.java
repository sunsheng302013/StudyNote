/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.enums;

/**
 * <p>
 * 类描述: 数据字典
 * </p>
 *
 * @since 2018年10月15日
 * @author wengjiaxin
 */
public enum DictionaryEnum {

    /** 职级序列 **/
    RANK_SEQUENCE("rankSequence"),

    /** 职级分类 **/
    RANK_CATEGORY("rankCategory"),

    /** 职级序列 **/
    POSITIONCATEGORY("positionCategory"),

    /** 合同签订情况 **/
    LABOURCONTRACTTYPE("labourContractType"),

    /** 合同类型 **/
    LABOURCONTRACTINFOTYPE("labourContractInfoType");

    /** 数据字典值 **/
    private String value;

    /**
     * @param value
     *            字典值
     */
    DictionaryEnum(String value) {
        this.value = value;
    }

    /**
     * @return the msg
     */
    public String getValue() {
        return value;
    }

}