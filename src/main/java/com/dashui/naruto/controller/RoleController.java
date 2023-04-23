package com.dashui.naruto.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.common.TableDataInfo;
import com.dashui.naruto.domain.Role;
import com.dashui.naruto.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/9 22:11
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: RoleController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/system/role")
public class RoleController extends BaseController {


    /**
     * 服务对象
     */
    private final RoleService roleService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param admin 查询实体
     * @return 所有数据
     */
    @GetMapping("list")
    public TableDataInfo selectAll(Page<Role> page, Role admin) {
        return TableDataInfo.build(this.roleService.page(page, new QueryWrapper<>(admin)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {

        return success(this.roleService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param admin 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Role admin) {
        System.out.println(123);
        return toAjax(this.roleService.save(admin));
    }

    /**
     * 修改数据
     *
     * @param admin 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Role admin) {
        return toAjax(this.roleService.updateById(admin));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("id") Integer id) {
        return toAjax(this.roleService.removeById(id));
    }
}
