package com.dashui.naruto.satoken.impl;

import cn.dev33.satoken.stp.StpInterface;
import com.dashui.naruto.domain.SystemAdmin;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.domain.SystemRole;
import com.dashui.naruto.mapper.SystemAdminMapper;
import com.dashui.naruto.mapper.SystemMenuMapper;
import com.dashui.naruto.mapper.SystemRoleMapper;
import com.dashui.naruto.service.SystemMenuService;
import com.dashui.naruto.service.SystemRoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 自定义权限验证接口扩展
 */
@Component    // 保证此类被SpringBoot扫描，完成Sa-Token的自定义权限验证扩展
@RequiredArgsConstructor
public class StpInterfaceImpl implements StpInterface {


    private final SystemMenuService systemMenuService;
    private final SystemRoleService systemRoleService;


    /**
     * 返回一个账号所拥有的权限码集合 
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        System.out.println("获取权限码");
        return  systemMenuService.getCurrentMenuPerms((Integer) loginId);
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权 限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        System.out.println("获取角色");
        return  systemRoleService.getCurrentRoles((Integer) loginId);
    }

}
