package com.dashui.naruto.controller;

import cn.dev33.satoken.stp.StpUtil;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.config.SiteConfig;
import com.dashui.naruto.domain.Admin;
import com.dashui.naruto.domain.Menu;
import com.dashui.naruto.security.domain.LoginAdmin;
import com.dashui.naruto.service.AdminService;
import com.dashui.naruto.service.MenuService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/9 19:23
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: SystemController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/admin")
public class SystemController extends BasicController {

    private final SiteConfig siteConfig;
    private final AdminService adminService;
    private final MenuService menuService;
    @GetMapping("index")
    public AjaxResult index(){
        Admin byId = adminService.getById(1);
        List<Menu> list = menuService.getCurrentMenu();
        return success()
                .data("siteConfig",siteConfig)
                .data("adminInfo",byId)
                .data("menus",list);
    }

    @GetMapping("Dashboard/dashboard")
    public AjaxResult dashboard(){
        return success().data("remark","开源等于互助；开源需要大家一起来支持，支持的方式有很多种，比如使用、推荐、写教程、保护生态、贡献代码、回答问题、分享经验、打赏赞助等；欢迎您加入我们！");
    }


    @GetMapping("login")
    public AjaxResult loginCheck(){

        return success().data("siteConfig",siteConfig);
    }



    @PostMapping("login")
    public AjaxResult doLogin(@RequestBody LoginAdmin login){
        // 此处仅作模拟示例，真实项目需要从数据库中查询数据进行比对
        if("123".equals(login.getUsername()) && "123".equals(login.getPassword())) {
            StpUtil.login(10001);
            return success();
        }
        return error();
    }

}
