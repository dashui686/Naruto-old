package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.AdminGroup;
import com.dashui.naruto.service.AdminGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 管理分组表(AdminGroup)表控制层
 *
 * @author 132767
 * @since 2023-03-20 16:21:56
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("adminGroup")
public class AdminGroupController extends BasicController {
    /**
     * 服务对象
     */
    private final AdminGroupService adminGroupService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param adminGroup 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<AdminGroup> page, AdminGroup adminGroup) {
        return success(this.adminGroupService.page(page, new QueryWrapper<>(adminGroup)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.adminGroupService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param adminGroup 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody AdminGroup adminGroup) {
        return toAjax(this.adminGroupService.save(adminGroup));
    }

    /**
     * 修改数据
     *
     * @param adminGroup 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody AdminGroup adminGroup) {
        return toAjax(this.adminGroupService.updateById(adminGroup));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.adminGroupService.removeByIds(idList));
    }
}

