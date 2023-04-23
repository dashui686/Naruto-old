package com.dashui.naruto.controller;

import com.alibaba.fastjson2.JSONArray;
import com.alibaba.fastjson2.JSONObject;
import com.dashui.naruto.common.AjaxResult;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

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
public class DashboardController extends BaseController {

    @RequestMapping("/admin/Dashboard/dashboard")
    public AjaxResult adminDashboard(){
        return success().put("remark","开源等于互助；开源需要大家一起来支持，支持的方式有很多种，比如使用、推荐、写教程、保护生态、贡献代码、回答问题、分享经验、打赏赞助等；欢迎您加入我们！");
    }

    /*
     *//**
     * 主页面
     * @return
     */
    @RequestMapping("/index/index")
    public AjaxResult userDashboard(){
        // IndexVo indexVo = new IndexVo();
        // Site site = new Site();
        // site.setSiteName("我叼你妈的程序");
        // site.setRecordNumber("213123213");
        // site.setVersionNumber("1.1");
        // indexVo.setSite(site);
        // indexVo.setOpenMemberCenter(true);
        // return success(indexVo);
        return success();
    }

    @RequestMapping("/admin/index/login")
    public AjaxResult loginIndex(){
        // 是否开启验证码
        return success().put("captcha",false);
    }

    @PostMapping("/admin/index/login")
    public AjaxResult loginIndex(@RequestBody Map<String,Object> map){

 /*         if(StrUtil.isEmpty(map.get("captcha").toString())){
            return error();
        } */

        if("123456".equals(map.get("password"))){

            HashMap<String, Object> stringObjectHashMap = new HashMap<>();
            stringObjectHashMap.put("routePath","/admin");
            HashMap<String, Object> admin = new HashMap<>();
            admin.put("username","admin");
            admin.put("id","1");
            admin.put("nickname","Admin");
            admin.put("token","20c5ebeb-12c4-479c-b9d2-16183de955d6");
            admin.put("refreshToken","");
            admin.put("avatar","http://localhost:8000/static/images/avatar.png");
            stringObjectHashMap.put("userInfo",admin);
            return success(stringObjectHashMap);
        }
        return error("请输入正确的验证码！");
    }



    @GetMapping("/admin/index/index")
    public AjaxResult adminIndex(){
        String menu = " [\n" +
                "        {\n" +
                "            \"id\": 1,\n" +
                "            \"pid\": 0,\n" +
                "            \"type\": \"menu\",\n" +
                "            \"title\": \"控制台\",\n" +
                "            \"name\": \"dashboard/dashboard\",\n" +
                "            \"path\": \"dashboard\",\n" +
                "            \"icon\": \"fa fa-dashboard\",\n" +
                "            \"menu_type\": \"tab\",\n" +
                "            \"url\": \"\",\n" +
                "            \"component\": \"/src/views/backend/dashboard.vue\",\n" +
                "            \"keepalive\": \"dashboard/dashboard\",\n" +
                "            \"extend\": \"none\"\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 2,\n" +
                "            \"pid\": 0,\n" +
                "            \"type\": \"menu_dir\",\n" +
                "            \"title\": \"权限管理\",\n" +
                "            \"name\": \"auth\",\n" +
                "            \"path\": \"auth\",\n" +
                "            \"icon\": \"fa fa-group\",\n" +
                "            \"menu_type\": null,\n" +
                "            \"url\": \"\",\n" +
                "            \"component\": \"\",\n" +
                "            \"keepalive\": 0,\n" +
                "            \"extend\": \"none\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": 3,\n" +
                "                    \"pid\": 2,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"角色组管理\",\n" +
                "                    \"name\": \"auth/group\",\n" +
                "                    \"path\": \"auth/group\",\n" +
                "                    \"icon\": \"fa fa-group\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/auth/group/index.vue\",\n" +
                "                    \"keepalive\": \"auth/group\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 4,\n" +
                "                            \"pid\": 3,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"auth/group/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 5,\n" +
                "                            \"pid\": 3,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"auth/group/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 6,\n" +
                "                            \"pid\": 3,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"auth/group/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 7,\n" +
                "                            \"pid\": 3,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"auth/group/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 8,\n" +
                "                    \"pid\": 2,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"管理员管理\",\n" +
                "                    \"name\": \"auth/admin\",\n" +
                "                    \"path\": \"auth/admin\",\n" +
                "                    \"icon\": \"el-icon-UserFilled\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/auth/admin/index.vue\",\n" +
                "                    \"keepalive\": \"auth/admin\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 9,\n" +
                "                            \"pid\": 8,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"auth/admin/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 10,\n" +
                "                            \"pid\": 8,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"auth/admin/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 11,\n" +
                "                            \"pid\": 8,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"auth/admin/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 12,\n" +
                "                            \"pid\": 8,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"auth/admin/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 13,\n" +
                "                    \"pid\": 2,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"菜单规则管理\",\n" +
                "                    \"name\": \"auth/menu\",\n" +
                "                    \"path\": \"auth/menu\",\n" +
                "                    \"icon\": \"el-icon-Grid\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/auth/menu/index.vue\",\n" +
                "                    \"keepalive\": \"auth/menu\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 14,\n" +
                "                            \"pid\": 13,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"auth/menu/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 15,\n" +
                "                            \"pid\": 13,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"auth/menu/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 16,\n" +
                "                            \"pid\": 13,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"auth/menu/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 17,\n" +
                "                            \"pid\": 13,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"auth/menu/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 18,\n" +
                "                            \"pid\": 13,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"快速排序\",\n" +
                "                            \"name\": \"auth/menu/sortable\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 19,\n" +
                "                    \"pid\": 2,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"管理员日志管理\",\n" +
                "                    \"name\": \"auth/adminLog\",\n" +
                "                    \"path\": \"auth/adminLog\",\n" +
                "                    \"icon\": \"el-icon-List\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/auth/adminLog/index.vue\",\n" +
                "                    \"keepalive\": \"auth/adminLog\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 20,\n" +
                "                            \"pid\": 19,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"auth/adminLog/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 21,\n" +
                "            \"pid\": 0,\n" +
                "            \"type\": \"menu_dir\",\n" +
                "            \"title\": \"会员管理\",\n" +
                "            \"name\": \"user\",\n" +
                "            \"path\": \"user\",\n" +
                "            \"icon\": \"fa fa-drivers-license\",\n" +
                "            \"menu_type\": null,\n" +
                "            \"url\": \"\",\n" +
                "            \"component\": \"\",\n" +
                "            \"keepalive\": 0,\n" +
                "            \"extend\": \"none\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": 22,\n" +
                "                    \"pid\": 21,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"会员管理\",\n" +
                "                    \"name\": \"user/user\",\n" +
                "                    \"path\": \"user/user\",\n" +
                "                    \"icon\": \"fa fa-user\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/user/user/index.vue\",\n" +
                "                    \"keepalive\": \"user/user\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 23,\n" +
                "                            \"pid\": 22,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"user/user/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 24,\n" +
                "                            \"pid\": 22,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"user/user/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 25,\n" +
                "                            \"pid\": 22,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"user/user/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 26,\n" +
                "                            \"pid\": 22,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"user/user/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 27,\n" +
                "                    \"pid\": 21,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"会员分组管理\",\n" +
                "                    \"name\": \"user/group\",\n" +
                "                    \"path\": \"user/group\",\n" +
                "                    \"icon\": \"fa fa-group\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/user/group/index.vue\",\n" +
                "                    \"keepalive\": \"user/group\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 28,\n" +
                "                            \"pid\": 27,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"user/group/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 29,\n" +
                "                            \"pid\": 27,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"user/group/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 30,\n" +
                "                            \"pid\": 27,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"user/group/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 31,\n" +
                "                            \"pid\": 27,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"user/group/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 32,\n" +
                "                    \"pid\": 21,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"会员规则管理\",\n" +
                "                    \"name\": \"user/rule\",\n" +
                "                    \"path\": \"user/rule\",\n" +
                "                    \"icon\": \"fa fa-th-list\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/user/rule/index.vue\",\n" +
                "                    \"keepalive\": \"user/rule\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 33,\n" +
                "                            \"pid\": 32,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"user/rule/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 34,\n" +
                "                            \"pid\": 32,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"user/rule/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 35,\n" +
                "                            \"pid\": 32,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"user/rule/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 36,\n" +
                "                            \"pid\": 32,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"user/rule/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 37,\n" +
                "                            \"pid\": 32,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"快速排序\",\n" +
                "                            \"name\": \"user/rule/sortable\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 38,\n" +
                "                    \"pid\": 21,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"会员余额管理\",\n" +
                "                    \"name\": \"user/moneyLog\",\n" +
                "                    \"path\": \"user/moneyLog\",\n" +
                "                    \"icon\": \"el-icon-Money\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/user/moneyLog/index.vue\",\n" +
                "                    \"keepalive\": 0,\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 39,\n" +
                "                            \"pid\": 38,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"user/moneyLog/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 40,\n" +
                "                            \"pid\": 38,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"user/moneyLog/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 41,\n" +
                "                    \"pid\": 21,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"会员积分管理\",\n" +
                "                    \"name\": \"user/scoreLog\",\n" +
                "                    \"path\": \"user/scoreLog\",\n" +
                "                    \"icon\": \"el-icon-Discount\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/user/scoreLog/index.vue\",\n" +
                "                    \"keepalive\": \"user/scoreLog\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 42,\n" +
                "                            \"pid\": 41,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"user/scoreLog/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 43,\n" +
                "                            \"pid\": 41,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"user/scoreLog/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        },\n" +
                "        {\n" +
                "            \"id\": 44,\n" +
                "            \"pid\": 0,\n" +
                "            \"type\": \"menu_dir\",\n" +
                "            \"title\": \"常规管理\",\n" +
                "            \"name\": \"routine\",\n" +
                "            \"path\": \"routine\",\n" +
                "            \"icon\": \"fa fa-cogs\",\n" +
                "            \"menu_type\": null,\n" +
                "            \"url\": \"\",\n" +
                "            \"component\": \"\",\n" +
                "            \"keepalive\": 0,\n" +
                "            \"extend\": \"none\",\n" +
                "            \"children\": [\n" +
                "                {\n" +
                "                    \"id\": 45,\n" +
                "                    \"pid\": 44,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"系统配置\",\n" +
                "                    \"name\": \"routine/config\",\n" +
                "                    \"path\": \"routine/config\",\n" +
                "                    \"icon\": \"el-icon-Tools\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/routine/config/index.vue\",\n" +
                "                    \"keepalive\": \"routine/config\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 46,\n" +
                "                            \"pid\": 45,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"routine/config/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 47,\n" +
                "                            \"pid\": 45,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"routine/config/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 77,\n" +
                "                            \"pid\": 45,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"添加\",\n" +
                "                            \"name\": \"routine/config/add\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 48,\n" +
                "                    \"pid\": 44,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"附件管理\",\n" +
                "                    \"name\": \"routine/attachment\",\n" +
                "                    \"path\": \"routine/attachment\",\n" +
                "                    \"icon\": \"fa fa-folder\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/routine/attachment/index.vue\",\n" +
                "                    \"keepalive\": \"routine/attachment\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 49,\n" +
                "                            \"pid\": 48,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"routine/attachment/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 50,\n" +
                "                            \"pid\": 48,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"routine/attachment/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 51,\n" +
                "                            \"pid\": 48,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"删除\",\n" +
                "                            \"name\": \"routine/attachment/del\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                },\n" +
                "                {\n" +
                "                    \"id\": 52,\n" +
                "                    \"pid\": 44,\n" +
                "                    \"type\": \"menu\",\n" +
                "                    \"title\": \"个人资料\",\n" +
                "                    \"name\": \"routine/adminInfo\",\n" +
                "                    \"path\": \"routine/adminInfo\",\n" +
                "                    \"icon\": \"fa fa-user\",\n" +
                "                    \"menu_type\": \"tab\",\n" +
                "                    \"url\": \"\",\n" +
                "                    \"component\": \"/src/views/backend/routine/adminInfo.vue\",\n" +
                "                    \"keepalive\": \"routine/adminInfo\",\n" +
                "                    \"extend\": \"none\",\n" +
                "                    \"children\": [\n" +
                "                        {\n" +
                "                            \"id\": 53,\n" +
                "                            \"pid\": 52,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"查看\",\n" +
                "                            \"name\": \"routine/adminInfo/index\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        },\n" +
                "                        {\n" +
                "                            \"id\": 54,\n" +
                "                            \"pid\": 52,\n" +
                "                            \"type\": \"button\",\n" +
                "                            \"title\": \"编辑\",\n" +
                "                            \"name\": \"routine/adminInfo/edit\",\n" +
                "                            \"path\": \"\",\n" +
                "                            \"icon\": \"\",\n" +
                "                            \"menu_type\": null,\n" +
                "                            \"url\": \"\",\n" +
                "                            \"component\": \"\",\n" +
                "                            \"keepalive\": 0,\n" +
                "                            \"extend\": \"none\"\n" +
                "                        }\n" +
                "                    ]\n" +
                "                }\n" +
                "            ]\n" +
                "        }\n" +
                "    ]\n";
        String siteConfig = "{\n" +

                "        \"siteName\": \"BuildAdmin\",\n" +
                "        \"version\": \"v1.0.0\",\n" +
                "        \"cdnUrl\": \"http://192.168.42.45:8000\",\n" +
                "        \"apiUrl\": \"https://buildadmin.com\",\n" +
                "        \"upload\": {\n" +
                "            \"maxsize\": 10485760,\n" +
                "            \"savename\": \"/storage/{topic}/{year}{mon}{day}/{filesha1}{.suffix}\",\n" +
                "            \"mimetype\": \"jpg,png,bmp,jpeg,gif,webp,zip,rar,xls,xlsx,doc,docx,wav,mp4,mp3,txt\",\n" +
                "            \"mode\": \"local\"\n" +
                "        }\n" +
                "}";
        String adminInfo = "{\n" +
                "        \"id\": 1,\n" +
                "        \"username\": \"admin\",\n" +
                "        \"nickname\": \"Admin\",\n" +
                "        \"avatar\": \"http://192.168.42.45:8000/static/images/avatar.png\",\n" +
                "        \"lastlogintime\": \"2024-03-20 21:28:28\",\n" +
                "        \"super\": true\n" +
                "}";


        JSONObject site = JSONObject.parseObject(siteConfig);
        JSONObject info = JSONObject.parseObject(adminInfo);
        JSONArray m = JSONArray.parse(menu);

        // 是否开启验证码
        return success().data("siteConfig",site).data("adminInfo",info).data("menus",m);
    }
}
