/**
 * <p>Copyright(C) 2018 Hangzhou Differsoft Co., Ltd. All rights reserved.</p>
 */
package com.cq.common.config;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

import javax.validation.constraints.NotNull;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.cloud.openfeign.support.SpringEncoder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

import com.cq.common.base.CommonContextHolder;
import com.cq.common.base.MemberHolder;
import com.cq.common.interceptor.ClientInfo;
import com.cq.model.user.MemberInfo;

import feign.Feign;
import feign.Request;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import feign.codec.Encoder;
import feign.form.spring.SpringFormEncoder;

/**
 * <p>
 * 类描述:
 * </p>
 *
 * @since 2018年11月20日
 * @author chengq
 */
public class FeignClientConfiguration {

    private final static Logger LOG = LoggerFactory.getLogger(FeignClientConfiguration.class);

    @Value(value = "${spring.application.type}")
    @NotNull(message = "系统服务名[spring.application.type]没有配置，请检查您的配置")
    private String serviceName;

    @Autowired
    private ObjectFactory<HttpMessageConverters> messageConverters;

    /** feign连接超时，默认5s */
    @Value("${feign.client.connectTimeout:5000}")
    private int connectTimeout;

    /** feign读取超时，默认60s */
    @Value("${feign.client.readTimeout:60000}")
    private int readTimeout;

    /**
     *
     * @desc 设置Feign调用连接超时和读取超时 连接超时5秒，读取超时60s
     *
     * @return
     */
    @Bean
    @Primary
    public Request.Options buildRequestOptions() {
        return new Request.Options(connectTimeout, readTimeout);
    }

    /**
     * Feign接口支持文件流
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @Primary
    public Encoder multipartFormEncoder() {
        return new SpringFormEncoder(new SpringEncoder(messageConverters));
    }

    /**
     * Feign请求头会员信息填充
     *
     * @return
     */
    @Bean
    @ConditionalOnMissingBean
    @Primary
    @Scope("prototype")
    public Feign.Builder feignBuilder() {
        return Feign.builder().requestInterceptor(new RequestInterceptor() {
            @Override
            public void apply(RequestTemplate request) {
                // 会员信息
                MemberInfo member = MemberHolder.getMemberInfo();
                if (null != member) {

                    String userName = member.getUserName();

                    String userRoles = member.getUserRoles();

                    try {
                        userName = StringUtils.isEmpty(userName) ? "" : URLEncoder.encode(userName, "UTF-8");

                        userRoles = StringUtils.isEmpty(userRoles) ? "" : URLEncoder.encode(userRoles, "UTF-8");

                    } catch (UnsupportedEncodingException e) {
                        LOG.error("Feign过滤器URLEncoder用户名称异常", e);
                    }

                    // 会员ID
                    request.header("mem_id", member.getMemberId());

                    // 吉客号
                    request.header("mem_name", member.getMemberName());

                    // 会员灰度服务列表，多个以英文逗号隔开
                    request.header("grey_service_list", member.getGreyServiceList());

                    // 用户ID
                    request.header("user_id", member.getUserId());

                    // 用户名
                    request.header("user_name", userName);

                    // 集群号
                    request.header("group_id", member.getGroupId());

                    // 用户角色
                    request.header("user_roles", userRoles);
                }
                // 日志流水号
                Long loggerSn = CommonContextHolder.getLoggerSn();
                if (null != loggerSn) {
                    request.header("loggerSN", loggerSn.toString());
                }
                // 语言
                String language = CommonContextHolder.getLanguage();
                if (null != language) {
                    request.header("language", language);
                }
                // 服务名
                request.header("origin_name", serviceName);

                // 请求客户端信息
                ClientInfo clientInfo = CommonContextHolder.getClientInfo();

                if (null != clientInfo) {
                    String clientIp = clientInfo.getClientIp();

                    if (null != clientIp) {
                        request.header("client_ip", clientIp);
                    }

                    String clientAti = clientInfo.getClientAti();

                    if (null != clientAti) {
                        request.header("client_ati", clientAti);
                    }
                }

            }
        });
    }
}
