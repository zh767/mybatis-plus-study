package com.zh.plus;

import com.zh.plus.entity.User;
import com.zh.plus.mapper.UserMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class MybatisPlusApplicationTests {

    @Autowired
    UserMapper userMapper;

    @Test
    void contextLoads() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    /*默认 ID_WORKER 全局唯一id
     * 是使用雪花算法*/
    @Test
    public void testInsert() {
        User user = new User();
        user.setName("狂神说Java");
        user.setAge(3);
        user.setEmail("24736743@qq.com");
        int result = userMapper.insert(user);// 帮我们自动生成id
        System.out.println(result); // 受影响的行数
        System.out.println(user); // 发现，id会自动回填
    }

    @Test
    public void testUpdate() {
        User user = new User(); // 通过条件自动拼接动态sql
        user.setId(6L);
        user.setName("关注公众号：狂神说");
        user.setAge(19); // 注意：updateById 但是参数是一个 对象！
        int i = userMapper.updateById(user);
        System.out.println(i);
    }

    // 测试乐观锁成功！
    @Test
    public void testOptimisticLocker() {
        // 1、查询用户信息
        User user = userMapper.selectById(6L);
        // 2、修改用户信息
        user.setName("kuangshen");
        user.setEmail("2333333@qq.com");
        // 3、执行更新操作
        System.out.println(userMapper.updateById(user));
    }

    // 测试乐观锁失败！多线程下
    @Test
    public void testOptimisticLocker2() {
        // 线程 1
        User user = userMapper.selectById(6L);
        user.setName("kuangshen111");
        user.setEmail("24734444@qq.com");
        // 模拟另外一个线程执行了插队操作
        User user2 = userMapper.selectById(6L);
        user2.setName("kuangshen222");
        user2.setEmail("2488883@qq.com");
        userMapper.updateById(user2);

        //自旋锁来多次尝试提交！
       while(userMapper.updateById(user)!=1){
            user = userMapper.selectById(6L);
           user.setName("kuangshen111啊啊啊 自旋");
           user.setEmail("2qq4@qq.com");
       }
        //如果没有乐观锁就会覆盖插队线程的值！
    }
}
