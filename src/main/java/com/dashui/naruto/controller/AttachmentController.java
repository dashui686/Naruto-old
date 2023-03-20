package com.dashui.naruto.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import com.dashui.naruto.domain.Attachment;
import com.dashui.naruto.service.AttachmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

/**
 * 附件表(Attachment)表控制层
 *
 * @author 132767
 * @since 2023-03-20 16:21:56
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("attachment")
public class AttachmentController extends BasicController {
    /**
     * 服务对象
     */
    private final AttachmentService attachmentService;

    /**
     * 分页查询所有数据
     *
     * @param page 分页对象
     * @param attachment 查询实体
     * @return 所有数据
     */
    @GetMapping
    public AjaxResult selectAll(Page<Attachment> page, Attachment attachment) {
        return success(this.attachmentService.page(page, new QueryWrapper<>(attachment)));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public AjaxResult selectOne(@PathVariable Serializable id) {
        return success(this.attachmentService.getById(id));
    }

    /**
     * 新增数据
     *
     * @param attachment 实体对象
     * @return 新增结果
     */
    @PostMapping
    public AjaxResult insert(@RequestBody Attachment attachment) {
        return toAjax(this.attachmentService.save(attachment));
    }

    /**
     * 修改数据
     *
     * @param attachment 实体对象
     * @return 修改结果
     */
    @PutMapping
    public AjaxResult update(@RequestBody Attachment attachment) {
        return toAjax(this.attachmentService.updateById(attachment));
    }

    /**
     * 删除数据
     *
     * @param idList 主键结合
     * @return 删除结果
     */
    @DeleteMapping
    public AjaxResult delete(@RequestParam("idList") List<Long> idList) {
        return toAjax(this.attachmentService.removeByIds(idList));
    }
}

