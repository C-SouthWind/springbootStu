package com.chj.mapper;


import com.chj.model.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

/**
 * @projectName: springboot
 * @package: com.chj.controller.mapper
 * @className: BookMapper
 * @author: chj
 * @description:
 * @date: Created in  2023/3/8 20:02
 * @version: 1.0
 */
@Mapper
public interface UserMapper {

    @Select("select * from user where id = #{id}")
    User getById(Integer id);
}
