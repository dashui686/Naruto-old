package com.dashui.naruto;


import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.alibaba.fastjson2.JSON;
import com.dashui.naruto.domain.Menu;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.service.SystemMenuService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class NarutoApplicationTests {

    @Autowired
    SystemMenuService menuService;

    @Test
    void contextLoads() {
        List<SystemMenu> list = menuService.list();

        // 根据parentId构建树形结构
        List<Tree<Integer>> build = TreeUtil.build(list, 0, new TreeNodeConfig().setIdKey("value").setNameKey("label"), (menu, treeItem) -> {
            treeItem.setId(menu.getId());
            treeItem.setName(menu.getTitle());
            treeItem.setParentId(menu.getPid());
        });

        System.out.println(JSON.toJSONString(build));
    }

}
