/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.dto.user;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 * 类描述: 显示职位DTO
 * </p>
 *
 * @since 2018年10月16日
 * @author wengjiaxin
 */
public class ShowPositionDTO implements Serializable {

    /** serialVersionUID */
    private static final long serialVersionUID = 7897222535643539466L;

    /** 显示职位ID **/
    private Long showPositionId;

    /** 显示职位名 **/
    private String showPositionName;

    /** 该职位下人员名 **/
    private List<ShowUserDTO> showUserDTO;

    /**
     * @return the showPositionId
     */
    public Long getShowPositionId() {
        return showPositionId;
    }

    /**
     * @param showPositionId
     *            要设置的 showPositionId
     */
    public void setShowPositionId(Long showPositionId) {
        this.showPositionId = showPositionId;
    }

    /**
     * @return the showPositionName
     */
    public String getShowPositionName() {
        return showPositionName;
    }

    /**
     * @param showPositionName
     *            要设置的 showPositionName
     */
    public void setShowPositionName(String showPositionName) {
        this.showPositionName = showPositionName;
    }

    /**
     * @return the showUserDTO
     */
    public List<ShowUserDTO> getShowUserDTO() {
        return showUserDTO;
    }

    /**
     * @param showUserDTO
     *            要设置的 showUserDTO
     */
    public void setShowUserDTO(List<ShowUserDTO> showUserDTO) {
        this.showUserDTO = showUserDTO;
    }

    @Override
    public String toString() {
        return "ShowPositionDTO [showPositionId=" + showPositionId + ", showPositionName=" + showPositionName + ", showUserDTO=" + showUserDTO + "]";
    }

}
