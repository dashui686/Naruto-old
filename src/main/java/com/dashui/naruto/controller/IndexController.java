package com.dashui.naruto.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.domain.Blogs;
import com.dashui.naruto.service.BlogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/17 16:50
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: IndexController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
public class IndexController extends BasicController {


    private final BlogsService blogsService;

    @GetMapping("index")
    public AjaxResult index(){
        // 获取博客
        Page<Blogs> page = blogsService.page(new Page<>(1, 3), new QueryWrapper<Blogs>().lambda().orderByDesc(Blogs::getCreateTime));
        // 获取图片
        // 主页信息
        // 获取联系我
        return success().data("blogs",page.getRecords());
    };
}
