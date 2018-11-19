/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;

/**
 * <p>
 * 类描述:数据字典类
 * </p>
 *
 * @since 2018年10月15日
 * @author xiejy
 */
public class DictDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = -6132748638437117358L;

    private String ditText;
    private String ditValue;
    private String text;
    private String value;

    /**
     * @return the ditText
     */
    public String getDitText() {
        return ditText;
    }

    /**
     * @param ditText
     *            要设置的 ditText
     */
    public void setDitText(String ditText) {
        this.ditText = ditText;
    }

    /**
     * @return the ditValue
     */
    public String getDitValue() {
        return ditValue;
    }

    /**
     * @param ditValue
     *            要设置的 ditValue
     */
    public void setDitValue(String ditValue) {
        this.ditValue = ditValue;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text
     *            要设置的 text
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the value
     */
    public String getValue() {
        return value;
    }

    /**
     * @param value
     *            要设置的 value
     */
    public void setValue(String value) {
        this.value = value;
    }

}
