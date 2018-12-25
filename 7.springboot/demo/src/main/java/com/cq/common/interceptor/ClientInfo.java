/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.interceptor;

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

    public String getClientIp() {
        return clientIp;
    }

    public void setClientIp(String clientIp) {
        this.clientIp = clientIp;
    }

    public String getClientAti() {
        return clientAti;
    }

    public void setClientAti(String clientAti) {
        this.clientAti = clientAti;
    }
}
