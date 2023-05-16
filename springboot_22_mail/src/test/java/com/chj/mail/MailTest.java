package com.chj.mail;

import com.chj.service.SendMailService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import javax.mail.MessagingException;

/**
 * @projectName: springbootStu
 * @package: com.chj.mail
 * @className: MailTest
 * @author: chj
 * @description:
 * @date: Created in  2023/5/15 19:55
 * @version: 1.0
 */
@SpringBootTest
public class MailTest {

    @Resource
    private SendMailService sendMailService;

    @Test
    public void sendMail() throws MessagingException {
        sendMailService.sendMail();
    }
}
