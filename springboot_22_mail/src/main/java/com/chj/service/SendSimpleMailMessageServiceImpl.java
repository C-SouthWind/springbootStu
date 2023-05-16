package com.chj.service;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: SendMailServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/15 19:54
 * @version: 1.0
 */
//@Service
public class SendSimpleMailMessageServiceImpl implements SendMailService {

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
    private String context = "测试邮件正文内容";


    @Resource
    private JavaMailSender javaMailSender;

    @Override
    public void sendMail() {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(from + "(chj)");
        message.setTo(to);
        message.setSubject(subject);
        message.setText(context);
        javaMailSender.send(message);
    }
}
