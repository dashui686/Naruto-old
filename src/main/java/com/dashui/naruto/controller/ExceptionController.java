package com.dashui.naruto.controller;

import cn.dev33.satoken.exception.NotLoginException;
import com.dashui.naruto.common.AjaxResult;
import com.dashui.naruto.satoken.enums.AccountNotFoundException;
import com.dashui.naruto.satoken.enums.PasswordErrorException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.thymeleaf.exceptions.TemplateInputException;

import static com.dashui.naruto.constant.HttpStatus.NO_LOGIN;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/26 9:45
 * @PackageName: com.dashui.naruto.controller
 * @ClassName: ExceptionController
 * @Description: TODO
 * @Version 1.0
 */
@RestControllerAdvice
public class ExceptionController {

    @ExceptionHandler(NotLoginException.class)
    public AjaxResult noLogin(){
        return new AjaxResult(NO_LOGIN,"请登录");
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public AjaxResult accountNotFound(AccountNotFoundException e){ return AjaxResult.error(e.getMessage()).data("code",e.getErrorCode()); }

    @ExceptionHandler(PasswordErrorException.class)
    public AjaxResult passwordError(PasswordErrorException e){
        return AjaxResult.error(e.getMessage()).data("code",e.getErrorCode());
    }


    @ExceptionHandler(TemplateInputException.class)
    public AjaxResult templateInputException(PasswordErrorException e){
        return AjaxResult.error("模板不存在，修复中");
    }
}
