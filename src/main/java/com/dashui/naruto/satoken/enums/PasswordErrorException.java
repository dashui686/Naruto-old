package com.dashui.naruto.satoken.enums;

import com.dashui.naruto.exception.base.BaseException;
import com.dashui.naruto.exception.domain.Context;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 21:32
 * @PackageName: com.dashui.naruto.exception
 * @ClassName: PasswordErrorException
 * @Description: TODO
 * @Version 1.0
 */
public class PasswordErrorException extends BaseException {

    public PasswordErrorException() {
    }

    public PasswordErrorException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public PasswordErrorException(String errorCode, String errorMessage, Context context) {
        super(errorCode, errorMessage, context);
    }
}
