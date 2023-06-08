package com.chj.config;

import com.chj.bean.MyPostProcessor;
import com.chj.bean.MyRegistrar;
import com.chj.service.BookService;
import com.chj.service.impl.BookServiceImpl1;
import org.springframework.context.annotation.Import;

/**
 * MyRegistrar的优先级高于BookServiceImpl1.class  多个MyRegistrar 后面会覆盖前面的
 * MyPostProcessor 的优先级高于 MyRegistrar
 *
 * @projectName: springbootStu
 * @package: com.chj.config
 * @className: SpringConfig3
 * @author: chj
 * @description:
 * @date: Created in  2023/6/6 20:36
 * @version: 1.0
 */
@Import({BookServiceImpl1.class, MyRegistrar.class, MyPostProcessor.class})
public class SpringConfig8 {

}
