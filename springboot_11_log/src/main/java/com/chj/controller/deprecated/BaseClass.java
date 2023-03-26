package com.chj.controller.deprecated;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @projectName: springbootStu
 * @package: com.chj.controller
 * @className: BaseClass
 * @author: chj
 * @description:
 * @date: Created in  2023/3/26 20:58
 * @version: 1.0
 */
@Deprecated
public class BaseClass {
    private static Class clazz;
    public static Logger log = null;

    BaseClass() {
        clazz = this.getClass();
        log = LoggerFactory.getLogger(clazz);
    }
}
