package com.dashui.naruto.service.impl;

import com.dashui.naruto.exception.EmailException;
import com.dashui.naruto.exception.domain.Context;
import com.dashui.naruto.mail.EmailService;
import com.dashui.naruto.mail.domain.SendEmailEntity;
import com.dashui.naruto.service.IndexService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/23 13:33
 * @PackageName: com.dashui.naruto.service.impl
 * @ClassName: IndexServiceImpl
 * @Description: TODO
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class IndexServiceImpl implements IndexService {

    private final EmailService emailService;


    @Override
    public boolean sendEmail(SendEmailEntity sendEmailEntity)  {
        return emailService.sendSimpleEmail(sendEmailEntity);
    }

}
