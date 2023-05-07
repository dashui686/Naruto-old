package com.dashui.naruto.satoken.impl;

import cn.hutool.core.bean.BeanUtil;
import cn.hutool.core.util.ObjectUtil;
import cn.hutool.crypto.digest.DigestUtil;
import cn.hutool.http.useragent.UserAgentUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dashui.naruto.domain.Admin;
import com.dashui.naruto.domain.SystemAdmin;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.mapper.SystemAdminMapper;
import com.dashui.naruto.mapper.SystemMenuMapper;
import com.dashui.naruto.mapper.SystemRoleMapper;
import com.dashui.naruto.satoken.domain.LoginAdmin;
import com.dashui.naruto.satoken.domain.LoginAdminVo;
import com.dashui.naruto.satoken.enums.AccountNotFoundException;
import com.dashui.naruto.satoken.enums.PasswordErrorException;
import com.dashui.naruto.exception.enums.ExceptionEnum;
import com.dashui.naruto.satoken.AdminDetailService;
import com.dashui.naruto.satoken.domain.LoginBody;
import com.dashui.naruto.satoken.util.LoginHelper;
import com.dashui.naruto.service.SystemAdminService;
import com.dashui.naruto.service.SystemMenuService;
import com.dashui.naruto.service.SystemRoleService;
import com.dashui.naruto.utils.ServletUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 16:03
 * @PackageName: com.dashui.naruto.security
 * @ClassName: UsernameService
 * @Description: TODO
 * @Version 1.0
 */
@Service
@Slf4j
@RequiredArgsConstructor
public class AdminDetailServiceImpl implements AdminDetailService {

    private final SystemAdminService adminService;
    private final SystemMenuService systemMenuService;
    private final SystemRoleService systemRoleService;


    @Override
    public LoginAdminVo login(LoginBody loginBody) {

        SystemAdmin one = adminService.getOne(new QueryWrapper<SystemAdmin>().lambda().eq(SystemAdmin::getUserName, loginBody.getUsername()));

        if(ObjectUtil.isNull(one)){
            log.error("登录失败，原因：{}，用户名：{}",ExceptionEnum.ACCOUNT_NOT_FOUND.getMsg(),loginBody.getUsername());
            throw new AccountNotFoundException(ExceptionEnum.ACCOUNT_NOT_FOUND.getCode(),ExceptionEnum.ACCOUNT_NOT_FOUND.getMsg());
        }

        if(!DigestUtil.bcryptCheck(loginBody.getPassword(), one.getPassword())){
            log.error("登录失败，原因：{}，用户名：{}",ExceptionEnum.PASSWORD_ERROR.getMsg(),loginBody.getUsername());
            throw new PasswordErrorException(ExceptionEnum.PASSWORD_ERROR.getCode(),ExceptionEnum.PASSWORD_ERROR.getMsg());
        }
        LoginAdmin loginAdmin = buildLoginUser(one);
        LoginHelper.login(loginAdmin);
        LoginAdminVo loginAdminVo = new LoginAdminVo();
        BeanUtil.copyProperties(one,loginAdminVo);
        return loginAdminVo;
    }


    private LoginAdmin buildLoginUser(SystemAdmin systemAdmin){
        LoginAdmin loginAdmin = new LoginAdmin();
        loginAdmin.setUserName(systemAdmin.getUserName());
        loginAdmin.setId(systemAdmin.getId());
        loginAdmin.setAuths(new HashSet<>(systemMenuService.getCurrentMenuPerms(systemAdmin.getId())));
        loginAdmin.setRoles(new HashSet<>(systemRoleService.getCurrentRoles(systemAdmin.getId())));
        return loginAdmin;
    };
}
