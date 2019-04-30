/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.base;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
public class ClientInfo {

    private String clientIp;

    private String clientAti;

    /**
     * 构造方法
     */
    public ClientInfo() {
        super();
    }

    /**
     * 构造函数
     *
     * @param clientIp
     *            请求客户端IP
     * @param clientAti
     *            请求客户端ati
     */
    public ClientInfo(String clientIp, String clientAti) {
        super();
        this.clientIp = clientIp;
        this.clientAti = clientAti;
    }

    /**
     * @return the clientIp
     */
    public String getClientIp() {
        return clientIp;
    }

    /**
     * @param clientIp
     *            要设置的 clientIp
     */
    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    /**
     * @return the clientAti
     */
    public String getClientAti() {
        return clientAti;
    }

    /**
     * @param clientAti
     *            要设置的 clientAti
     */
    public void setClientAti(String clientAti) {
        this.clientAti = clientAti;
    }

}
