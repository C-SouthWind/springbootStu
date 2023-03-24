package com.chj.service.impl;

import cn.hutool.core.collection.ListUtil;
import cn.hutool.core.map.MapUtil;
import cn.hutool.core.thread.ExecutorBuilder;
import cn.hutool.core.thread.ThreadUtil;
import cn.hutool.extra.spring.SpringUtil;
import cn.hutool.poi.excel.ExcelReader;
import cn.hutool.poi.excel.ExcelUtil;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.chj.mapper.ImportUserMapper;
import com.chj.model.Appuser;
import com.chj.service.ImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @projectName: springbootStu
 * @package: com.chj.service.impl
 * @className: ImportServiceImpl
 * @author: chj
 * @description:
 * @date: Created in  2023/3/23 19:49
 * @version: 1.0
 */
@Service
public class ImportServiceImpl extends ServiceImpl<ImportUserMapper,Appuser> implements ImportService {

    @Autowired
    @Resource
    private ImportUserMapper userMapper;

    ExecutorService executor = ExecutorBuilder.create()
            .setCorePoolSize(5)
            .setMaxPoolSize(10)
            .setWorkQueue(new LinkedBlockingQueue<>(100))
            .build();


    @Override
    @Transactional(transactionManager = "transactionManager")
    public void excelImport() {
        ExcelReader reader = ExcelUtil.getReader("C:\\Users\\chj\\Desktop\\aaa.xlsx");
        List<Map<String, Object>> maps = reader.readAll();
        List<List<Map<String, Object>>> split = ListUtil.split(maps, maps.size()/5);
        for (List<Map<String, Object>> mapList : split) {
            new Thread(()->{
                CopyOnWriteArrayList<Appuser> cowal = new CopyOnWriteArrayList();
                //check(MapUtil.toListMap(mapList));
                for (Map<String, Object> stringObjectMap : mapList) {
                    cowal.add(new Appuser().setId(Long.valueOf(String.valueOf(stringObjectMap.get("id"))))
                            .setName(String.valueOf(stringObjectMap.get("name"))).
                            setEmail(String.valueOf(stringObjectMap.get("email"))).
                            setPhone(String.valueOf(stringObjectMap.get("phone"))).
                            setGender(Integer.valueOf(String.valueOf(stringObjectMap.get("gender")))).
                            setPassword(String.valueOf(stringObjectMap.get("password"))).
                            setAge(Integer.valueOf(String.valueOf(stringObjectMap.get("age")))));
                }
                System.out.println(cowal.size());
                insertUser(cowal);
            }).start();
        }


    }

//    @Override
//    public void excelImport() {
//        ExcelReader reader = ExcelUtil.getReader("C:\\Users\\chj\\Desktop\\aaa.xlsx");
//        List<Map<String, Object>> maps = reader.readAll();
//        List<List<Map<String, Object>>> split = ListUtil.split(maps, maps.size()/5);
//        CopyOnWriteArrayList<Appuser> copyOnWriteArrayList = new CopyOnWriteArrayList();
//        for (List<Map<String, Object>> mapList : split) {
//            new Thread(()->{
//                CopyOnWriteArrayList<Appuser> cowal = new CopyOnWriteArrayList();
//                //check(MapUtil.toListMap(mapList));
//                for (Map<String, Object> stringObjectMap : mapList) {
//                    cowal.add(new Appuser().setId(Long.valueOf(String.valueOf(stringObjectMap.get("id"))))
//                            .setName(String.valueOf(stringObjectMap.get("name"))).
//                            setEmail(String.valueOf(stringObjectMap.get("email"))).
//                            setPhone(String.valueOf(stringObjectMap.get("phone"))).
//                            setGender(Integer.valueOf(String.valueOf(stringObjectMap.get("gender")))).
//                            setPassword(String.valueOf(stringObjectMap.get("password"))).
//                            setAge(Integer.valueOf(String.valueOf(stringObjectMap.get("age")))));
//                }
//                copyOnWriteArrayList.addAll(cowal);
//            }).start();
//        }
//        System.out.println(copyOnWriteArrayList.size());
//        insertUser(copyOnWriteArrayList);
//    }

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

    public static void main(String[] args) {
        int i = 999;
//        int i1 = i / 4;
//
//        System.out.println("0-"+i1);
//        System.out.println(i1+"-"+i1*2);
//        System.out.println(i1*2+"-"+i1*3);
//        System.out.println(i1*3+"-"+i);
        System.out.println(ListUtil.split(Arrays.asList(1, 2, 3, 4,5,6,7,8,9), 5));
    }
}
