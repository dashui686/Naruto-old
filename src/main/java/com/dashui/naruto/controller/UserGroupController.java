package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.UserGroup;
import com.dashui.naruto.service.UserGroupService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 会员组表(UserGroup)表控制层
 *
 * @author 132767
 * @since 2023-03-20 16:21:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("userGroup")
public class UserGroupController extends BasicController {
    /**
     * 服务对象
     */
    private final UserGroupService userGroupService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param userGroup 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<UserGroup> page, UserGroup userGroup) {
        return success(this.userGroupService.page(page, new QueryWrapper<>(userGroup)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.userGroupService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userGroup 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody UserGroup userGroup) {
        return toAjax(this.userGroupService.save(userGroup));
    }

    /**
     * 修改数据
     *
     * @param userGroup 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody UserGroup userGroup) {
        return toAjax(this.userGroupService.updateById(userGroup));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.userGroupService.removeByIds(idList));
    }
}

