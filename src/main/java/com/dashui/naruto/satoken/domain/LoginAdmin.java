package com.dashui.naruto.satoken.domain;

import cn.hutool.core.date.DateTime;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/5 14:41
 * @PackageName: com.dashui.naruto.security.domain
 * @ClassName: LoginEntity
 * @Description: TODO
 * @Version 1.0
 */
@Data
@ToString
public class LoginAdmin {

    /**
     * 管理员名称
     */
    private String userName;

    /**
     * 管理员ID
     */
    private Integer id;

    /**
     * 登录时间
     */
    private LocalDateTime loginTime;

    /**
     * 登录IP地址
     */
    private String ipaddr;

    /**
     * 登录地点
     */
    private String loginLocation;

    /**
     * 浏览器类型
     */
    private String browser;

    /**
     * 操作系统
     */
    private String os;

    /**
     * 权限
     */
    private Set<String> auths;

    /**
     * 角色
     */
    private Set<String> roles;


}
