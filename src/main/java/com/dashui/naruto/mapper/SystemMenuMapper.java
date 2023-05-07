package com.dashui.naruto.mapper;

import com.dashui.naruto.domain.SystemMenu;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import java.util.Set;

/**
* @author Administrator
* @description 针对表【system_menu(菜单和权限规则表)】的数据库操作Mapper
* @createDate 2023-04-24 17:20:32
* @Entity com.dashui.naruto.domain.SystemMenu
*/
public interface SystemMenuMapper extends BaseMapper<SystemMenu> {

    List<SystemMenu> queryMenuByAdminId(Integer adminID);
}




