package com.chj.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chj.model.User;
import org.apache.ibatis.annotations.Mapper;

/**
 * @projectName: springboot
 * @package: com.chj.mapper
 * @className: UserMapper
 * @author: chj
 * @description:
 * @date: Created in  2023/3/9 20:17
 * @version: 1.0
 */
@Mapper
public interface UserMPMapper extends BaseMapper<User> {
}
