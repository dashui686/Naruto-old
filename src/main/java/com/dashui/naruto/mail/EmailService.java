package com.dashui.naruto.mail;

import cn.hutool.core.util.ObjectUtil;
import com.alibaba.fastjson2.util.DateUtils;
import com.dashui.naruto.mail.domain.SendEmailEntity;
import lombok.RequiredArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.lang.Nullable;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.util.Date;
import java.util.Optional;

/**
 * @Author dashui
 * @user Administrator
 * @Date 2023/4/22 20:05
 * @PackageName: com.dashui.naruto.service
 * @ClassName: EmailService
 * @Description: TODO
 * @Version 1.0
 */
@Service
@RequiredArgsConstructor
public class EmailService {

    private final JavaMailSender mailSender;

    private final TemplateEngine templateEngine;

    @Value("${spring.mail.username}")
    String defaultFrom;

    /**
     * 发送邮件
     * @param sendEmailEntity 邮件发送类
     * @return 结果
     */
    public boolean sendSimpleEmail(SendEmailEntity sendEmailEntity){
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(Optional.ofNullable(sendEmailEntity.getFrom()).orElse(defaultFrom)); //设置发送邮件账号
        simpleMailMessage.setTo(sendEmailEntity.getTo()); //设置接收邮件的人，可以多个
        simpleMailMessage.setSubject(sendEmailEntity.getSubject()); //设置发送邮件的主题
        simpleMailMessage.setText(sendEmailEntity.getText()); //设置发送邮件的内容
        mailSender.send(simpleMailMessage);
        return true;
    }
    public boolean sendHtmlEmail(SendEmailEntity sendEmailEntity) throws MessagingException {
        // Context context = new Context();
        // //设置模板所需的参数
        // context.setVariable("title","验证码");
        // context.setVariable("email","1327674904@qq.com");
        // context.setVariable("code","1231231");
        // context.setVariable("date", DateUtils.format(new Date(),"yyyy-MM-dd hh:mm:ss"));
        //通过模板类将动态参数传入HTML模板,并返回模板内容 参数一:模板名字，参数二：动态参数Web文本
        String content = templateEngine.process(sendEmailEntity.getTemplate(), sendEmailEntity.getContext());
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper minesweeper = new MimeMessageHelper(message, true);
        minesweeper.setFrom(Optional.ofNullable(sendEmailEntity.getFrom()).orElse(defaultFrom)); //设置发送邮件账号
        minesweeper.setTo(sendEmailEntity.getTo()); //设置接收邮件的人，可以多个
        minesweeper.setSubject(sendEmailEntity.getSubject()); //设置发送邮件的主题
        minesweeper.setText(content,true); //设置发送邮件的内容 第二个设置为true则可以发送带HTML的邮件
        mailSender.send(message);
        return true;
    }



}

