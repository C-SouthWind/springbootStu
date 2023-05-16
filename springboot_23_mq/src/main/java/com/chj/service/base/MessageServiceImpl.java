package com.chj.service.base;

import com.chj.service.MessageService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.impl
 * @className: MessageServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/5/16 19:42
 * @version: 1.0
 */
@Service
public class MessageServiceImpl implements MessageService {

    private List<String> messages = new ArrayList<>();


    @Override
    public void sendMessage(String id) {
        System.out.println("消息id已存入" + id);
        messages.add(id);
    }

    @Override
    public String doMessage() {
        String id = messages.remove(0);
        System.out.println("消息已完成" + id);
        return id;
    }
}
