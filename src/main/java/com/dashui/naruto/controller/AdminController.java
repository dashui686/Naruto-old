package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.Admin;
import com.dashui.naruto.service.AdminService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 管理员(Admin)表控制层
 *
 * @author makejava
 * @since 2023-03-19 18:20:40
 */
@RestController
@RequestMapping("admin")
public class AdminController extends BasicController {


    /**
     * 服务对象
     */
    @Resource
    private AdminService adminService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param admin 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<Admin> page, Admin admin) {
        Page<Admin> page1 = this.adminService.page(page, new QueryWrapper<>(admin));
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
        return AjaxResult.success(this.adminService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Admin admin) {
        return toAjax(this.adminService.save(admin));
    }

    /**
     * 修改数据
     *
     * @param admin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Admin admin) {
        return toAjax(this.adminService.updateById(admin));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.adminService.removeByIds(idList));
    }
}

