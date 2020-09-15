package com.zh.plus;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zh.plus.entity.User;
import com.zh.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created By IntelliJ IDEA.
 * ClassName :MybatisPlusTest
 * Date :2020/4/23 10:22
 * Description:
 */
@SpringBootTest
public class MybatisPlusTest {
    @Autowired
    UserMapper userMapper;

    //id查询
    @Test
    public void testSelectById() {
        User user = userMapper.selectById(1L);
        System.out.println(user);
    }

    //批量查询
    @Test
    public void testSelectByBatchId() {
        List<User> users = userMapper.selectBatchIds(Arrays.asList(1, 2, 3));
        users.forEach(System.out::println);
    }

    @Test
    public void testSelectByBatchIds() {
        HashMap<String, Object> map = new HashMap<>();
        //自定义要查询
        map.put("name", "狂神说Java");
        map.put("age", 3);
        List<User> users = userMapper.selectByMap(map);
        users.forEach(System.out::println);
    }

    @Test
    void testPage() {
        Page<User> page = new Page<>(1, 5);
        userMapper.selectPage(page, null);
        page.getRecords().forEach(System.out::println);
        System.out.println(page.getTotal());
    }

    @Test
    public void testDeleteById() {
              /*  物理删除 ：从数据库中直接移除
        逻辑删除 ：再数据库中没有被移除，而是通过一个变量来让他失效！
        deleted = 0 =>deleted = 1*/
        userMapper.deleteById(1L);
    }

    @Test
    public void testDeleteBatchId() {
        userMapper.deleteBatchIds(Arrays.asList(1240620674645544961L, 1240620674645544962L));
    }

    @Test
    public void testDeleteMap() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("name", "狂神说Java");
        userMapper.deleteByMap(map);
    }


    @Test
    void test4() {
        // 查询年龄在 20 ~ 30 岁之间的用户
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 左和右 t%
        wrapper.notLike("name", "e").likeRight("email", "t");
        List<Map<String, Object>> maps = userMapper.selectMaps(wrapper);
        maps.forEach(System.out::println);
    }

    @Test
    void test5() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // id 在子查询中查出来
        wrapper.inSql("id", "select id from user where id<3");
        List<Object> objects = userMapper.selectObjs(wrapper);
        objects.forEach(System.out::println);
    }

    @Test
    void test6() {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        // 通过id进行排序
        wrapper.orderByAsc("id");
        List<User> users = userMapper.selectList(wrapper);
        users.forEach(System.out::println);
    }
}
