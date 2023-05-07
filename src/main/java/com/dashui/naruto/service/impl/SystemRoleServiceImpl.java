package com.dashui.naruto.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.domain.SystemRole;
import com.dashui.naruto.service.SystemRoleService;
import com.dashui.naruto.mapper.SystemRoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【system_role(角色表)】的数据库操作Service实现
* @createDate 2023-04-25 17:52:39
*/
@Service
@RequiredArgsConstructor
public class SystemRoleServiceImpl extends ServiceImpl<SystemRoleMapper, SystemRole>
    implements SystemRoleService{

    private final SystemRoleMapper systemRoleMapper;

    @Override
    public List<SystemRole> queryRoleByAdminId(Integer adminId) {
        return systemRoleMapper.queryRoleByAdminId(adminId);
    }


    @Override
    public List<String> getCurrentRoles(Integer adminId) {
        return queryRoleByAdminId(adminId).stream().map(SystemRole::getRoleCode).collect(Collectors.toList());
    }
}




