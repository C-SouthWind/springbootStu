package com.chj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.chj.model.Appuser;

/**
 * @projectName: springbootStu
 * @package: com.chj.service
 * @className: ImportServie
 * @author: chj
 * @description:
 * @date: Created in  2023/3/23 19:46
 * @version: 1.0
 */
public interface ImportService extends IService<Appuser> {

    void excelImport();
}
