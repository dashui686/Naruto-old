package com.dashui.naruto.satoken.domain;

import com.dashui.naruto.constant.UserConstants;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;


/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 16:30
 * @PackageName: com.dashui.naruto.security.domain
 * @ClassName: LoginBody
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class LoginBody {

    /**
     * 登录名
     */
    @NotBlank(message = "管理员名称不能为空")
    @Length(min = UserConstants.USERNAME_MIN_LENGTH, max = UserConstants.USERNAME_MAX_LENGTH, message = "管理员名称长度有问题")
    private String username;

    /**
     * 密码
     */
    @NotBlank(message = "管理员密码不能为空")
    @Length(min = UserConstants.PASSWORD_MIN_LENGTH, max = UserConstants.PASSWORD_MAX_LENGTH, message = "管理员密码长度有问题")
    private String password;

    /**
     * 验证码
     */
    private String code;

    /**
     * 验证码ID
     */
    private String uuid;
}
