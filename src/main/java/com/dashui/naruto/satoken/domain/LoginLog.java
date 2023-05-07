package com.dashui.naruto.satoken.domain;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 20:26
 * @PackageName: com.dashui.naruto.security.domain
 * @ClassName: LoginLog
 * @Description: TODO
 * @Version 1.0
 */
public class LoginLog {

    /**
     * 用户ID
     */
    private Long userId;

    /**
     * 登录时间
     */
    private Long loginTime;


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
     * 登录失败次数
     */
    private String loginStatus;

    /**
     * 登录失败次数
     */
    private int loginFailure;
}
