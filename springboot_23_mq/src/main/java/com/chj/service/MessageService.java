package com.chj.service;

/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: MessageService
 * @author: chj
 * @description:
 * @date: Created in  2023/5/16 19:42
 * @version: 1.0
 */
public interface MessageService {
    void sendMessage(String id);

    String doMessage();
}
