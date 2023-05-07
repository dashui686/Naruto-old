package com.dashui.naruto.satoken.enums;

import com.dashui.naruto.exception.base.BaseException;
import com.dashui.naruto.exception.domain.Context;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 21:46
 * @PackageName: com.dashui.naruto.security.exception
 * @ClassName: AccountNotFoundException
 * @Description: TODO
 * @Version 1.0
 */
public class AccountNotFoundException extends BaseException {

    public AccountNotFoundException() {
    }

    public AccountNotFoundException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public AccountNotFoundException(String errorCode, String errorMessage, Context context) {
        super(errorCode, errorMessage, context);
    }
}
