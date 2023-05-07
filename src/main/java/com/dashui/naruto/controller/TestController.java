package com.dashui.naruto.controller;

import cn.hutool.extra.mail.MailUtil;
import com.alibaba.fastjson2.util.DateUtils;
import com.dashui.naruto.common.AjaxResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import java.util.Date;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/27 14:19
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: TestController
 * @Description: TODO
 * @Version 1.0
 */
@RestController
@RequestMapping("/test")
public class TestController extends BaseController {


    @Autowired
    TemplateEngine templateEngine;



    @GetMapping
    public AjaxResult test(){

        Context context = new Context();
        //设置模板所需的参数
        context.setVariable("title","验证码");
        context.setVariable("email","1327674904@qq.com");
        context.setVariable("code","1231231");
        context.setVariable("date", DateUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
        //通过模板类将动态参数传入HTML模板,并返回模板内容 参数一:模板名字，参数二：动态参数Web文本
        String content = templateEngine.process("emailContact",context);

        MailUtil.send("1327674904@qq.com", "测试", content, true);
        return null;
    }
}
