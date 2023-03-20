package com.dashui.naruto.controller;



import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.MenuRule;
import com.dashui.naruto.service.MenuRuleService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (MenuRule)表控制层
 *
 * @author makejava
 * @since 2023-03-19 18:20:40
 */
@RestController
@RequestMapping("admin/auth.menu")
public class MenuRuleController extends BasicController {
    /**
     * 服务对象
     */
    @Resource
    private MenuRuleService menuRuleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param menuRule 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<MenuRule> page, MenuRule menuRule) {
        Page<MenuRule> page1 = this.menuRuleService.page(page, new QueryWrapper<>(menuRule));
        return success();
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        MenuRule byId = this.menuRuleService.getById(id);
        return success(byId);
    }

    /**
     * 新增数据
     *
     * @param menuRule 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody MenuRule menuRule) {
        return success(this.menuRuleService.save(menuRule));
    }

    /**
     * 修改数据
     *
     * @param menuRule 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody MenuRule menuRule) {
        return success(this.menuRuleService.updateById(menuRule));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return success(this.menuRuleService.removeByIds(idList));
    }
}

