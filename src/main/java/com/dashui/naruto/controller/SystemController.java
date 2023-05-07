package com.dashui.naruto.controller;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.exception.NotLoginException;
import cn.dev33.satoken.stp.StpUtil;
import cn.hutool.core.util.ObjectUtil;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.config.SiteConfig;
import com.dashui.naruto.domain.Admin;
import com.dashui.naruto.domain.Menu;
import com.dashui.naruto.domain.SystemAdmin;
import com.dashui.naruto.domain.SystemMenu;
import com.dashui.naruto.satoken.AdminDetailService;
import com.dashui.naruto.satoken.domain.LoginAdminVo;
import com.dashui.naruto.satoken.domain.LoginBody;
import com.dashui.naruto.service.SystemAdminService;
import com.dashui.naruto.service.SystemMenuService;
import com.dashui.naruto.utils.ServletUtils;
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
public class SystemController extends BaseController {

    private final SiteConfig siteConfig;

    private final SystemAdminService adminService;

    private final SystemMenuService menuService;

    private final AdminDetailService adminDetailService;

    @GetMapping("index")
    public AjaxResult index(){
        Integer loginId = Integer.parseInt(StpUtil.getLoginId().toString()) ;
        System.out.println(loginId);
        SystemAdmin byId = adminService.getById(loginId);
        List<SystemMenu> list = menuService.getCurrentTreeMenu(loginId);
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
    public AjaxResult doLogin(@RequestBody LoginBody loginBody){
        try {
            LoginAdminVo login = adminDetailService.login(loginBody);
            login.setSaToken(StpUtil.getTokenInfo().getTokenValue());
            return success().data("userInfo",login).data("routePath","/admin");
        } catch (Exception e) {
            return error(e.getMessage());
        }
    }

}
