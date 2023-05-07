package com.dashui.naruto.satoken.enums;


import com.dashui.naruto.exception.base.BaseException;
import com.dashui.naruto.exception.domain.Context;

public class CaptchaException extends BaseException {

    public CaptchaException() {
    }

    public CaptchaException(String errorCode, String errorMessage) {
        super(errorCode, errorMessage);
    }

    public CaptchaException(String errorCode, String errorMessage, Context context) {
        super(errorCode, errorMessage, context);
    }
}
