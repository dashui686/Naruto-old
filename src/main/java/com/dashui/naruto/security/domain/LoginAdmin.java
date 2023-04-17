package com.dashui.naruto.security.domain;

import lombok.Data;
import lombok.ToString;

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
    private String username;
    private String password;

}
