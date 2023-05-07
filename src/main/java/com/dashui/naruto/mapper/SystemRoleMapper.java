package com.dashui.naruto.mapper;

import com.dashui.naruto.domain.SystemRole;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
* @author Administrator
* @description 针对表【system_role(角色表)】的数据库操作Mapper
* @createDate 2023-04-25 17:52:39
* @Entity com.dashui.naruto.domain.SystemRole
*/
public interface SystemRoleMapper extends BaseMapper<SystemRole> {


    List<SystemRole> queryRoleByAdminId(Integer adminId);
}




