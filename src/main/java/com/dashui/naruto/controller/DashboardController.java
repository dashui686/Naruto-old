package com.dashui.naruto.controller;

import com.dashui.naruto.core.common.AjaxResult;
import com.dashui.naruto.core.web.controller.BasicController;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/3/19 21:48
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: DashboardController
 * @Description: TODO
 * @Version 1.0
 */
@RequestMapping
@RestController
@RequiredArgsConstructor
public class DashboardController extends BasicController {
    @RequestMapping("admin/Dashboard/dashboard")
    public AjaxResult dashboard(){
        return success().put("remark","开源等于互助；开源需要大家一起来支持，支持的方式有很多种，比如使用、推荐、写教程、保护生态、贡献代码、回答问题、分享经验、打赏赞助等；欢迎您加入我们！");
    }
}
