package com.dashui.naruto.service;

import com.dashui.naruto.domain.SystemMenu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【system_menu(菜单和权限规则表)】的数据库操作Service
* @createDate 2023-04-24 17:20:32
*/
public interface SystemMenuService extends IService<SystemMenu> {

    List<SystemMenu> getMenuByAdminId(Integer adminId);

    List<String> getCurrentMenuPerms(Integer adminId);

    List<SystemMenu> getCurrentTreeMenu(Integer adminId);

    List<SystemMenu> generatorMenu(List<SystemMenu> menus, Integer parentId);
}
