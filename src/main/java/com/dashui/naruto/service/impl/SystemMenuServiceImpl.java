package com.dashui.naruto.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.service.SystemMenuService;
import com.dashui.naruto.mapper.SystemMenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【system_menu(菜单和权限规则表)】的数据库操作Service实现
* @createDate 2023-04-24 17:20:32
*/
@Service
@RequiredArgsConstructor
public class SystemMenuServiceImpl extends ServiceImpl<SystemMenuMapper, SystemMenu>
    implements SystemMenuService{

    private final SystemMenuMapper systemMenuMapper;

    @Override
    public List<SystemMenu> getMenuByAdminId(Integer adminId){
        return systemMenuMapper.queryMenuByAdminId(adminId);
    }

    @Override
    public List<String> getCurrentMenuPerms(Integer adminId) {
        return getMenuByAdminId(adminId).stream().map(SystemMenu::getPerms).collect(Collectors.toList());
    }

    @Override
    public List<SystemMenu> getCurrentTreeMenu(Integer id) {

        return generatorMenu(getMenuByAdminId(id),0);
    }


    @Override
    public List<SystemMenu> generatorMenu(List<SystemMenu> menus, Integer parentId){
        ArrayList<SystemMenu> menuArrayList = CollUtil.newArrayList();
        // 判断是否为null或者空数组
        if (!ObjectUtil.isNull(menus) && CollectionUtil.isNotEmpty(menus)){
            // 循环节点
            for (SystemMenu menu : menus) {
                // 判断是否是否等于需要查找的子节点
                if(Objects.equals(menu.getPid(), parentId)){
                    if (hasChildren(menu, menus)) {
                        generatorMenu(menus,menu.getId());
                        menu.setChildren(menus.stream().filter(e -> e.getPid().equals(menu.getId())).collect(Collectors.toList()));

                    }
                    menuArrayList.add(menu);
                }
            }
        }
        return menuArrayList;
    }


    public void test(){}

    public boolean hasChildren(SystemMenu menu,List<SystemMenu> menus){
        return CollectionUtil.isNotEmpty(menus.stream().filter(e -> e.getPid().equals(menu.getId())).collect(Collectors.toList()));
    }

}




