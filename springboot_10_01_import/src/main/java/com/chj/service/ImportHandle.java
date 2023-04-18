package com.chj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chj.model.Appuser;

import java.util.List;
import java.util.Map;

/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: ImportHandle
 * @author: chj
 * @description:
 * @date: Created in  2023/4/10 19:55
 * @version: 1.0
 */
public interface ImportHandle extends IService<Appuser> {

    void handle(List<Map<String, Object>> mapList);
}
