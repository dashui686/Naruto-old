package com.dashui.naruto.exception;

import com.dashui.naruto.exception.base.BaseException;
import com.dashui.naruto.exception.domain.Context;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/23 12:47
 * @PackageName: com.dashui.naruto.exception
 * @ClassName: EmailsException
 * @Description: TODO
 * @Version 1.0
 */
public class EmailException extends BaseException {

    public EmailException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public EmailException(String errorCode, String errorMessage, Context context) {
        super(errorCode, errorMessage, context);
    }
}
