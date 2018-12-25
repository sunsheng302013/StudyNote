/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.Assert;

/**
 * <p>
 * 类描述: 全局唯一ID生成器
 * </p>
 *
 * @since 2018年11月19日
 * @author chengq
 */
public class IdWorkerUtil {

    private final static Logger LOG = LoggerFactory.getLogger(IdWorkerUtil.class);

    private static IdWorker idWorker = null;

    /**
     *
     * @desc 根据dockerId（范围0~16383）生成Id
     *
     * @param dockerId:容器ID
     * @return
     */
    private static Long getId(Long dockerId) {
        if (idWorker == null) {
            syncInit(dockerId);
        }
        return idWorker.nextId();
    }

    /**
     * 全局唯一ID
     *
     * @return
     */
    public static Long getId() {
        // dockerId从配置中读取修改为从主机IP中获取 2018-05-21
        String ipAddr = null;
        try {
            ipAddr = InetAddress.getLocalHost().getHostAddress();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }

        Assert.isTrue(StringUtils.isNotEmpty(ipAddr), "ID生成器未读取到本机IP地址");

        Long dockerId = getDockerId(ipAddr);

        if (LOG.isDebugEnabled()) {
            LOG.debug("主机IP生成的dockerId = " + dockerId);
        }
        return getId(dockerId);

    }

    /**
     * 获取容器ID
     *
     * @param ipaddr
     *            : docker IP地址
     * @return ： ip地址解析生成的容器ID
     */
    private static Long getDockerId(String ipaddr) {

        if (StringUtils.isEmpty(ipaddr)) {
            return null;
        }

        String[] ipSegments = ipaddr.split("\\.");

        String s1 = Integer.toHexString(Integer.valueOf(ipSegments[2]));

        String s2 = Integer.toHexString(Integer.valueOf(ipSegments[3]));

        s2 = s2.length() == 1 ? ("0" + s2) : s2;

        String hex = s1 + s2;

        Long dockerId = Long.parseLong(hex, 16);

        return dockerId;
    }

    /**
     *
     * @desc 单例同步方法
     *
     * @param dockerId
     */
    private synchronized static void syncInit(Long dockerId) {
        if (idWorker == null) {
            idWorker = new IdWorker(dockerId);
        }
    }
}
