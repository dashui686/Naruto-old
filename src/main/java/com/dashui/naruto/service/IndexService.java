package com.dashui.naruto.service;

import com.dashui.naruto.mail.domain.SendEmailEntity;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/23 13:31
 * @PackageName: com.dashui.naruto.service
 * @ClassName: IndexService
 * @Description: TODO
 * @Version 1.0
 */
public interface IndexService {


    boolean sendEmail(SendEmailEntity sendEmailEntity);
}
