package com.chj.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.chj.model.Appuser;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
@Repository
public interface ImportUserMapper extends BaseMapper<Appuser> {

    public void inserts(Appuser appuser);

}
