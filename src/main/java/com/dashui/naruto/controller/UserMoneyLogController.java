package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.UserMoneyLog;
import com.dashui.naruto.service.UserMoneyLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 会员余额变动表(UserMoneyLog)表控制层
 *
 * @author 132767
 * @since 2023-03-20 16:21:55
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("userMoneyLog")
public class UserMoneyLogController extends BasicController {
    /**
     * 服务对象
     */
    private final UserMoneyLogService userMoneyLogService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param userMoneyLog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<UserMoneyLog> page, UserMoneyLog userMoneyLog) {
        return success(this.userMoneyLogService.page(page, new QueryWrapper<>(userMoneyLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.userMoneyLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userMoneyLog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody UserMoneyLog userMoneyLog) {
        return toAjax(this.userMoneyLogService.save(userMoneyLog));
    }

    /**
     * 修改数据
     *
     * @param userMoneyLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody UserMoneyLog userMoneyLog) {
        return toAjax(this.userMoneyLogService.updateById(userMoneyLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.userMoneyLogService.removeByIds(idList));
    }
}

