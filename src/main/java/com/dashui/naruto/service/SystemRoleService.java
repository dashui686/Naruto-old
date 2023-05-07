package com.dashui.naruto.service;

import com.dashui.naruto.domain.SystemRole;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【system_role(角色表)】的数据库操作Service
* @createDate 2023-04-25 17:52:39
*/
public interface SystemRoleService extends IService<SystemRole> {


    List<SystemRole> queryRoleByAdminId(Integer adminId);

    List<String> getCurrentRoles(Integer adminId);
}
