package com.dashui.naruto.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/3 16:45
 * @PackageName: com.dashui.naruto.domain
 * @ClassName: SiteConfig
 * @Description: TODO
 * @Version 1.0
 */
@Data
@Component
@ConfigurationProperties(prefix = "site")
public class SiteConfig {

    /**
     * 站点名称
     */
    private String siteName;

    /**
     * 备案号
     */
    private String  recordNumber;

    /**
     * 版本
     */
    private String version;

    /**
     * 站点名称
     */
    private String cdnUrl;

    /**
     * 请求地址
     */
    private String apiUrl;

    /**
     * 上传大小
     */
    private Upload upload;
}
