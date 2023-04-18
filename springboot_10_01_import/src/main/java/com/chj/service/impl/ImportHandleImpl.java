package com.chj.service.impl;

import cn.hutool.core.map.MapUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chj.mapper.ImportUserMapper;
import com.chj.model.Appuser;
import com.chj.service.ImportHandle;
import org.apache.ibatis.session.SqlSession;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.SqlSessionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.impl
 * @className: ImportHandleImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/4/10 19:56
 * @version: 1.0
 */
@Service
public class ImportHandleImpl extends ServiceImpl<ImportUserMapper,Appuser> implements ImportHandle {

    @Resource
    private ImportUserMapper importUserMapper;

    @Override
    public void handle(List<Map<String, Object>> mapList) {
        CopyOnWriteArrayList<Appuser> cowal = new CopyOnWriteArrayList();
        //check(MapUtil.toListMap(mapList));
        for (Map<String, Object> stringObjectMap : mapList) {
            importUserMapper.inserts(new Appuser().setId(Long.valueOf(String.valueOf(stringObjectMap.get("id"))))
                    .setName(String.valueOf(stringObjectMap.get("name"))).
                    setEmail(String.valueOf(stringObjectMap.get("email"))).
                    setPhone(String.valueOf(stringObjectMap.get("phone"))).
                    setGender(Integer.valueOf(String.valueOf(stringObjectMap.get("gender")))).
                    setPassword(String.valueOf(stringObjectMap.get("password"))).
                    setAge(Integer.valueOf(String.valueOf(stringObjectMap.get("age")))));
        }
        System.out.println(cowal.size());

        //insertUser(cowal);
    }


    private synchronized void insertUser(CopyOnWriteArrayList<Appuser> copyOnWriteArrayList){
        this.saveBatch(copyOnWriteArrayList);
    }

    private void check(Map<String, List<Object>> stringListMap){
        for (String s : stringListMap.keySet()) {
            switch (s){
                case "id" :
                    for (Object o : stringListMap.get(s)) {
                        if (o.equals("999")) {
                            System.out.println("id===="+s);
                        }
                    }
                    break;
                case "name" :
                    System.out.println("name===="+s);break;
                case "email" :
                    System.out.println("email===="+s);break;
                case "phone" :
                    System.out.println("phone===="+s);break;
                case "gender" :
                    System.out.println("gender===="+s);break;
                case "password" :
                    System.out.println("password===="+s);break;
                case "age" :
                    System.out.println("age===="+s);break;
            }
        }
    }
}
