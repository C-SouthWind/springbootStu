package com.chj.service;

import javax.mail.MessagingException;

/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: SendMailService
 * @author: chj
 * @description:
 * @date: Created in  2023/5/15 19:53
 * @version: 1.0
 */
public interface SendMailService {
    void sendMail() throws MessagingException;
}
