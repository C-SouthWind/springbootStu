package com.chj.sevice.impl;

import com.chj.sevice.IpCountService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.HttpRequestHandler;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @projectName: springbootStu
 * @package: com.chj.sevice.impl
 * @className: IpCountServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/6/15 21:05
 * @version: 1.0
 */
public class IpCountServiceImpl implements IpCountService {

    private ConcurrentHashMap<String, Integer> ipCountMap = new ConcurrentHashMap<>();

    @Autowired
    //当前的request对象的注入工作由使用当前starter的工程提供自动装配
    private HttpServletRequest httpServletRequest;

    /**
     * 统计ip访问次数
     *
     * @param :
     * @return void
     * @description 统计ip访问次数
     * @author chj
     * @date 2023/6/15 21:05
     */
    @Override
    public void count() {
        System.out.println("----------------------------------------------------------------");
        //每次调用当前操作，就记录当前访问的IP,然后累加访问次数
        //1.获取当前操作的IP地址
        String ip = httpServletRequest.getRemoteAddr();
        //2.根据IP地址从Map取值，并递增
        Integer count = ipCountMap.get(ip);
        if (count == null) {
            ipCountMap.put(ip, 1);
        } else {
            ipCountMap.put(ip, count + 1);
        }

    }
}







































