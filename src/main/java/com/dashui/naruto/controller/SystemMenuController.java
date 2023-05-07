package com.dashui.naruto.controller;


import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.common.TableDataInfo;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.service.SystemMenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单和权限规则表(Menu)表控制层
 *
 * @author makejava
 * @since 2023-04-08 01:09:28
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/system/menu")
public class SystemMenuController extends BaseController {
    /**
     * 服务对象
     */
    private final SystemMenuService menuService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menu 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Page<SystemMenu> page, SystemMenu menu) {
        return TableDataInfo.build(this.menuService.generatorMenu( this.menuService.page(page, new QueryWrapper<>(menu)).getRecords(),0));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {

        return success(this.menuService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param menu 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody SystemMenu menu) {
        System.out.println(123);
        return toAjax(this.menuService.save(menu));
    }

    /**
     * 修改数据
     *
     * @param menu 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody SystemMenu menu) {
        return toAjax(this.menuService.updateById(menu));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("id") Integer id) {
        return toAjax(this.menuService.removeById(id));
    }


    /**
     * 拿到树形数据
     *
     * @return 删除结果
     */
    @GetMapping("treeList")
    public AjaxResult treeList() {

        List<SystemMenu> list = menuService.list();
        // 根据parentId构建树形结构
        List<Tree<Integer>> build = TreeUtil.build(list, 0, new TreeNodeConfig().setIdKey("value").setNameKey("label"), (menu, treeItem) -> {
            treeItem.setId(menu.getId());
            treeItem.setName(menu.getTitle());
            treeItem.setParentId(menu.getPid());
        });
        return success(build);
    }
}

