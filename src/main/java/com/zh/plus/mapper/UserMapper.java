package com.zh.plus.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.zh.plus.entity.User;
import org.springframework.stereotype.Repository;


/**
 * Created By IntelliJ IDEA.
 * ClassName :UserMapper
 * Date :2020/4/23 9:35
 * Description:
 */
//配置类配置将mapper扫描
@Repository
public interface UserMapper extends BaseMapper<User> {
}
