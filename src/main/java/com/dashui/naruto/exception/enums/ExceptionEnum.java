package com.dashui.naruto.exception.enums;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 21:38
 * @PackageName: com.dashui.naruto.exception.enums
 * @ClassName: ExceptionEnum
 * @Description: TODO
 * @Version 1.0
 */
public enum ExceptionEnum {
    PASSWORD_ERROR("PASSWORD_ERROR","密码输入错误"),
    ACCOUNT_NOT_FOUND("ACCOUNT_NOT_FOUND","用户未找到/用户不存在")
    ;

    private final String code;
    private final String msg;


    ExceptionEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
