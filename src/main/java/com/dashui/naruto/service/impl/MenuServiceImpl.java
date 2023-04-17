package com.dashui.naruto.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.collection.CollectionUtil;
import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.dashui.naruto.domain.Menu;
import com.dashui.naruto.service.MenuService;
import com.dashui.naruto.mapper.MenuMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author Administrator
* @description 针对表【menu(菜单和权限规则表)】的数据库操作Service实现
* @createDate 2023-04-05 20:42:25
*/
@Service
@RequiredArgsConstructor
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu>
    implements MenuService{

    private final MenuMapper menuMapper;

    @Override
    public List<Menu> getCurrentMenu() {
        List<Menu> menus = menuMapper.selectList(null);
        return generatorMenu(menus,0);
    }


    @Override
    public List<Menu> generatorMenu(List<Menu> menus, Integer parentId){
        ArrayList<Menu> menuArrayList = CollUtil.newArrayList();
        // 判断是否为null或者空数组
        if (!ObjectUtil.isNull(menus) && CollectionUtil.isNotEmpty(menus)){
            // 循环节点
            for (Menu menu : menus) {
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

    public boolean hasChildren(Menu menu,List<Menu> menus){
        return CollectionUtil.isNotEmpty(menus.stream().filter(e -> e.getPid().equals(menu.getId())).collect(Collectors.toList()));
    }


}




