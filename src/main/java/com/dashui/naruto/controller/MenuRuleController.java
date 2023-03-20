package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.MenuRule;
import com.dashui.naruto.service.MenuRuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 菜单和权限规则表(MenuRule)表控制层
 *
 * @author 132767
 * @since 2023-03-20 16:21:57
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("menuRule")
public class MenuRuleController extends BasicController {
    /**
     * 服务对象
     */
    private final MenuRuleService menuRuleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menuRule 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<MenuRule> page, MenuRule menuRule) {
        return success(this.menuRuleService.page(page, new QueryWrapper<>(menuRule)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.menuRuleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param menuRule 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody MenuRule menuRule) {
        return toAjax(this.menuRuleService.save(menuRule));
    }

    /**
     * 修改数据
     *
     * @param menuRule 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody MenuRule menuRule) {
        return toAjax(this.menuRuleService.updateById(menuRule));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.menuRuleService.removeByIds(idList));
    }
}

