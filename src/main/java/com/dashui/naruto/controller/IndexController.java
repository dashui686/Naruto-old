package com.dashui.naruto.controller;

import cn.hutool.core.util.ObjectUtil;
import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.common.TableDataInfo;
import com.dashui.naruto.domain.Blogs;
import com.dashui.naruto.domain.BlogsComments;
import com.dashui.naruto.domain.BlogsContent;
import com.dashui.naruto.domain.SendEmailEntity;
import com.dashui.naruto.service.BlogsCommentsService;
import com.dashui.naruto.service.BlogsContentService;
import com.dashui.naruto.service.BlogsService;
import com.dashui.naruto.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
public class IndexController extends BaseController {

    private final IndexService indexService;
    private final BlogsService blogsService;
    private final BlogsCommentsService blogsCommentsService;
    private final BlogsContentService blogsContentService;


    /**
     * 主页
     * @return
     */
    @GetMapping
    public AjaxResult index(){
        // 获取博客
        Page<Blogs> page = blogsService.page(new Page<>(1, 3), new QueryWrapper<Blogs>().lambda().orderByDesc(Blogs::getCreateTime));
        // 获取图片
        // 主页信息
        // 获取联系我
        return success().data("blogs",page.getRecords());
    };

    /**
     * 博客页
     * @return
     */
    @GetMapping("blogs")
    public TableDataInfo blogs(){
        startPage();
        List<Blogs> list = blogsService.list(new QueryWrapper<Blogs>().lambda().orderByDesc(Blogs::getCreateTime));
        return getDataTable(list);
    };

    /**
     * 博客详情
     * @param id 博客ID
     * @return
     */
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


    /**
     * 联系我
     */
    @PostMapping("concat")
    public AjaxResult senEmail(String name,String message, String email){
        if(StrUtil.isBlank(name)){
            return error("请输入您的姓名");
        }

        if(StrUtil.isBlank(message)){
            return error("请输入您的信息");
        }

        if(StrUtil.isBlank(email)){
            return error("请输入您的邮箱");
        }
        SendEmailEntity build = SendEmailEntity.SendEmailEntityBuilder.aSendEmailEntity()
                .withText(message)
                .withTo("1327674904@qq.com")
                .withFrom(email)
                .withSubject("有用户联系").build();
        return toAjax(indexService.sendEmail(build));
    }

}
