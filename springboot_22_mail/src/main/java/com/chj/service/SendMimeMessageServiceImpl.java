package com.chj.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.File;


/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: SendMailServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/15 19:54
 * @version: 1.0
 */
@Service
public class SendMimeMessageServiceImpl implements SendMailService {

    /**
     * 发送人
     */
    private String from = "1298365022@qq.com";
    /**
     * 接收人
     */
    private String to = "1298365022@qq.com";
    /**
     * 标题
     */
    private String subject = "测试邮件";
    /**
     * 正文
     */
    private String context = "<img src='https://i0.hdslb.com/bfs/article/f2926c66d8f136cef7d41581ded256b0e8ff5561.jpg@942w_531h_progressive.webp'/><a href='https://www.baidu.com'>点击跳转百度</a>";


    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail() throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setFrom(from + "(chj)");
        helper.setTo(to);
        helper.setSubject(subject);
        helper.setText(context, true);


        File file = new File("");
        helper.addAttachment(file.getName(), file);
        javaMailSender.send(message);
    }
}
