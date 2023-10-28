package com.dashui.naruto.satoken.domain;

import java.time.LocalDateTime;
import java.util.Set;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/6/29 20:25
 * @PackageName: com.dashui.naruto.satoken.domain
 * @ClassName: LoginUser
 * @Description: TODO
 * @Version 1.0
 */
public class LoginUser {
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

}
