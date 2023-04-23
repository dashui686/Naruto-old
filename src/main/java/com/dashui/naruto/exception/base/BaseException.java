package com.dashui.naruto.exception.base;

import com.dashui.naruto.exception.domain.Context;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/22 21:10
 * @PackageName: com.dashui.naruto.exception
 * @ClassName: BaseException
 * @Description: TODO
 * @Version 1.0
 */
@Data
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
public class BaseException extends RuntimeException {

    private String errorCode;
    private String errorMessage;
    private Context context;

    public BaseException(String errorCode, String errorMessage) {
        this(errorCode, errorMessage, Context.getCurrentContext());
    }

    public BaseException(String errorCode, String errorMessage, Context context) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
        this.context = context;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public Context getContext() {
        return context;
    }
}