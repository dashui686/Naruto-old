package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.domain.User;
import com.dashui.naruto.domain.vo.WxUserVo;
import com.dashui.naruto.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * (User)表控制层
 *
 * @author makejava
 * @since 2023-06-29 23:24:41
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("user")
public class UserController extends BaseController {
    /**
     * 服务对象
     */
    private final UserService userService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param user 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<User> page, User user) {
        return success(this.userService.page(page, new QueryWrapper<>(user)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.userService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param user 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody User user) {
        return toAjax(this.userService.save(user));
    }

    /**
     * 微信修改数据
     *
     * @param wxUserVo 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody WxUserVo wxUserVo) {
        return toAjax(this.userService.updateUser(wxUserVo));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.userService.removeByIds(idList));
    }
}

