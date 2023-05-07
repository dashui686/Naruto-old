package com.dashui.naruto.config;

import cn.dev33.satoken.context.SaHolder;
import cn.dev33.satoken.filter.SaServletFilter;
import cn.dev33.satoken.router.SaRouter;
import cn.dev33.satoken.stp.StpUtil;
import cn.dev33.satoken.util.SaResult;
import cn.hutool.json.JSONObject;
import com.alibaba.fastjson2.JSON;
import com.dashui.naruto.common.AjaxResult;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.dashui.naruto.constant.HttpStatus.NO_LOGIN;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/27 9:41
 * @PackageName: com.dashui.naruto.config
 * @ClassName: SaTokenConfig
 * @Description: TODO
 * @Version 1.0
 */
@Configuration
public class SaTokenConfig {

    /**
     * 注册 [Sa-Token全局过滤器]
     */
    @Bean
    public SaServletFilter getSaServletFilter() {
        return new SaServletFilter()
                // 异常处理函数：每次认证函数发生异常时执行此函数
                .setError(e -> {
                    // System.out.println("---------- 进入Sa-Token异常处理 -----------");
                    return JSON.toJSONString(new AjaxResult(NO_LOGIN,"请登录"));
                });
    }
}
