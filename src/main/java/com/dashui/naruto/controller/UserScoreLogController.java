package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.UserScoreLog;
import com.dashui.naruto.service.UserScoreLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 会员积分变动表(UserScoreLog)表控制层
 *
 * @author 132767
 * @since 2023-03-20 16:21:52
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("userScoreLog")
public class UserScoreLogController extends BasicController {
    /**
     * 服务对象
     */
    private final UserScoreLogService userScoreLogService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param userScoreLog 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<UserScoreLog> page, UserScoreLog userScoreLog) {
        return success(this.userScoreLogService.page(page, new QueryWrapper<>(userScoreLog)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.userScoreLogService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param userScoreLog 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody UserScoreLog userScoreLog) {
        return toAjax(this.userScoreLogService.save(userScoreLog));
    }

    /**
     * 修改数据
     *
     * @param userScoreLog 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody UserScoreLog userScoreLog) {
        return toAjax(this.userScoreLogService.updateById(userScoreLog));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.userScoreLogService.removeByIds(idList));
    }
}

