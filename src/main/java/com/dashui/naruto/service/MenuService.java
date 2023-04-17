package com.dashui.naruto.service;

import com.dashui.naruto.domain.Menu;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
* @author Administrator
* @description 针对表【menu(菜单和权限规则表)】的数据库操作Service
* @createDate 2023-04-05 20:42:25
*/
public interface MenuService extends IService<Menu> {

    public List<Menu> getCurrentMenu();

    List<Menu> generatorMenu(List<Menu> menus, Integer parentId);
}
