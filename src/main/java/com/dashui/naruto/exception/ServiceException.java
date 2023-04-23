package com.dashui.naruto.exception;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/22 21:10
 * @PackageName: com.dashui.naruto.exception
 * @ClassName: ServiceException
 * @Description: TODO
 * @Version 1.0
 */
public class ServiceException extends RuntimeException{

    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
