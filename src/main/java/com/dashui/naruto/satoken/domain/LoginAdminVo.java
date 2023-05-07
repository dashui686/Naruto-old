package com.dashui.naruto.satoken.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/26 11:02
 * @PackageName: com.dashui.naruto.satoken.domain
 * @ClassName: LoginAdminVo
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class LoginAdminVo {

    /**
     * 管理员名称
     */
    private String nickName;

    /**
     * 管理员名称
     */
    private String avatar;

    /**
     * 管理员名称
     */
    private String userName;

    /**
     * 管理员ID
     */
    private Integer id;

    /**
     * token
     */
    private String saToken;

}
