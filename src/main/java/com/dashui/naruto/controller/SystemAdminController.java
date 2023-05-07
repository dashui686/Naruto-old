package com.dashui.naruto.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.common.TableDataInfo;
import com.dashui.naruto.domain.SystemAdmin;
import com.dashui.naruto.service.SystemAdminService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/2 17:10
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: LoginController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/system/admin")
public class SystemAdminController extends BaseController {

    /**
     * 服务对象
     */
    private final SystemAdminService systemAdminService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param admin 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Page<SystemAdmin> page, SystemAdmin admin) {
        return TableDataInfo.build(this.systemAdminService.page(page, new QueryWrapper<>(admin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {

        return success(this.systemAdminService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody SystemAdmin admin) {
        System.out.println(123);
        return toAjax(this.systemAdminService.save(admin));
    }

    /**
     * 修改数据
     *
     * @param admin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody SystemAdmin admin) {
        return toAjax(this.systemAdminService.updateById(admin));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("id") Integer id) {
        return toAjax(this.systemAdminService.removeById(id));
    }

}
