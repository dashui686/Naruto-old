package com.dashui.naruto.controller;

import cn.hutool.core.util.ObjectUtil;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.common.TableDataInfo;
import com.dashui.naruto.domain.Blogs;
import com.dashui.naruto.domain.BlogsComments;
import com.dashui.naruto.domain.BlogsContent;
import com.dashui.naruto.service.BlogsCommentsService;
import com.dashui.naruto.service.BlogsContentService;
import com.dashui.naruto.service.BlogsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.function.Function;

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
@RequestMapping("index")
public class IndexController extends BasicController {


    private final BlogsService blogsService;
    private final BlogsCommentsService blogsCommentsService;
    private final BlogsContentService blogsContentService;



    @GetMapping
    public AjaxResult index(){
        // 获取博客
        Page<Blogs> page = blogsService.page(new Page<>(1, 3), new QueryWrapper<Blogs>().lambda().orderByDesc(Blogs::getCreateTime));
        // 获取图片
        // 主页信息
        // 获取联系我
        return success().data("blogs",page.getRecords());
    };

    @GetMapping("blogs")
    public TableDataInfo blogs(){
        startPage();
        List<Blogs> list = blogsService.list(new QueryWrapper<Blogs>().lambda().orderByDesc(Blogs::getCreateTime));
        return getDataTable(list);
    };

    @GetMapping("blog/{id}")
    public AjaxResult blog(@PathVariable String id){
        // startPage();
        // List<Blogs> list = blogsService.list(new QueryWrapper<Blogs>().lambda().orderByDesc(Blogs::getCreateTime));
        if (ObjectUtil.isNull(id)){
            return error("参数错误");
        }
        Blogs byId = blogsService.getById(id);

        List<BlogsComments> list = blogsCommentsService.getTreeComments(new QueryWrapper<BlogsComments>().lambda().eq(BlogsComments::getBlogsId, id));
        String content = blogsContentService.getObj(new QueryWrapper<BlogsContent>().lambda().
                eq(BlogsContent::getBlogsId, id).
                select(BlogsContent::getContent), Object::toString);
        return success()
                .data("blog",byId)
                .data("comments",list)
                .data("content",content)
                ;
    };


}
