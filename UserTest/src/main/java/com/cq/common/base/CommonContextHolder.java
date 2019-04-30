/**
 * Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.
 *
 */
package com.cq.common.base;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.math.NumberUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;

import com.alibaba.fastjson.JSON;
import com.cq.common.utils.MapUtils;

/**
 * 获取当前时间
 *
 * @since 2018年9月5日 上午10:19:03
 * @author chengq
 *
 */
public class CommonContextHolder {

    private static final Logger LOG = LoggerFactory.getLogger(CommonContextHolder.class);

    /** 语种 **/
    private static final ThreadLocal<String> LANGUAGE = new InheritableThreadLocal<>();

    /** 请求客户端信息 **/
    private static final ThreadLocal<ClientInfo> REQUEST_CLIENT_INFO = new InheritableThreadLocal<>();

    /** 自定义上下文参数 **/
    private static final ThreadLocal<Map<String, String>> EXTRA_CONTEXT = new InheritableThreadLocal<>();

    private CommonContextHolder() {
    }

    /**
     * 请求流水号
     *
     * @return 流水号
     */
    public static Long getLoggerSn() {
        return NumberUtils.toLong(MDC.get("loggerSN"));
    }

    /**
     * 设置流水号
     *
     * @param loggerSn
     *            流水号
     */
    public static void setLoggerSn(Long loggerSn) {
        MDC.put("loggerSN", loggerSn.toString());
    }

    /**
     * 去除流水号
     *
     * @return 被去除的流水号
     */
    public static String removeLoggerSn() {
        String loggerSn = MDC.get("loggerSN");
        MDC.clear();
        return loggerSn;
    }

    /**
     * 设置语言
     *
     * @param language
     *            语言类型
     */
    public static void bindLanguage(String language) {
        LANGUAGE.set(language);
    }

    /**
     * 去除语言
     *
     * @return language 语言类型
     */
    public static String unbindLanguage() {
        String language = LANGUAGE.get();
        LANGUAGE.remove();
        return language;
    }

    /**
     * 查询语言
     *
     * @return language 语言类型
     */
    public static String getLanguage() {
        return LANGUAGE.get();
    }

    /**
     * 设置请求客户端信息线程变量
     *
     * @param clientInfo
     *            客户端信息
     */
    public static void setClientInfo(ClientInfo clientInfo) {
        REQUEST_CLIENT_INFO.set(clientInfo);
    }

    /**
     * 获取请求客户端信息
     *
     * @return 客户端信息
     */
    public static ClientInfo getClientInfo() {
        return REQUEST_CLIENT_INFO.get();
    }

    /**
     * 清除请求客户端信息
     *
     * @return 客户端信息
     */
    public static ClientInfo clearClientInfo() {

        ClientInfo clientInfo = getClientInfo();

        REQUEST_CLIENT_INFO.remove();

        return clientInfo;

    }

    /**
     * 设置其它上下文参数
     *
     * @param name
     *            参数名
     * @param value
     *            参数值
     */
    public static void addExtraContext(String name, String value) {
        Map<String, String> extraContext = EXTRA_CONTEXT.get();
        if (extraContext == null) {
            extraContext = new HashMap<>();
        }

        extraContext.put(name, value);

        EXTRA_CONTEXT.set(extraContext);

        LOG.debug("其它上下文参数 = " + JSON.toJSONString(extraContext, true));

    }

    /**
     * 获取其它上下文参数
     *
     * @param name
     *            参数名
     * @return 上下文参数
     */
    public static String getExtraContextValue(String name) {
        Map<String, String> extraContext = EXTRA_CONTEXT.get();

        if (!MapUtils.isEmpty(extraContext)) {

            LOG.debug("其它上下文参数 = " + JSON.toJSONString(extraContext, true));

            return MapUtils.getString(extraContext, name);
        }

        LOG.debug("其它上下文参数为空");

        return null;
    }
}
