package com.dashui.naruto.satoken.domain;

import com.dashui.naruto.constant.UserConstants;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.HashMap;
import java.util.Map;


/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/24 16:30
 * @PackageName: com.dashui.naruto.security.domain
 * @ClassName: LoginBody
 * @Description: TODO
 * @Version 1.0
 */
@Data
public class WxLoginBody extends HashMap<String,Object> {

    /**
     * 登录名
     */
    @NotBlank(message = "微信")
    private String code;

    /**
     * 密码
     */
    private String grantType = "authorization_code";

    private String appid;

    private String secret;


    public static final class WxLoginBodyBuilder {
        private WxLoginBody wxLoginBody;

        private WxLoginBodyBuilder() {
            wxLoginBody = new WxLoginBody();
            wxLoginBody.put("grantType","authorization_code");
            wxLoginBody.put("appid","authorization_code");
        }

        public static WxLoginBodyBuilder aWxLoginBody() {
            return new WxLoginBodyBuilder();
        }

        public WxLoginBodyBuilder withCode(String code) {
            wxLoginBody.setCode(code);
            return this;
        }

        public WxLoginBodyBuilder withGrantType(String grantType) {
            wxLoginBody.setGrantType(grantType);
            return this;
        }

        public WxLoginBodyBuilder withAppid(String appid) {
            wxLoginBody.setAppid(appid);
            return this;
        }

        public WxLoginBodyBuilder withSecret(String secret) {
            wxLoginBody.setSecret(secret);
            return this;
        }



        public WxLoginBody build() {
            return wxLoginBody;
        }
    }
}
