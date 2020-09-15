## mybatis-plus的学习

**快速入门**

地址：https://mp.baomidou.com/guide/quick-start.html#

**初始化工程**

使用第三方组件：

1、导入对应的依赖

2、研究依赖如何配置

3、代码如何编写

4、提高扩展技术能力！

**步骤**

1、创建数据库 mybatis_plus 

2、创建user表 

3、编写项目，初始化项目！使用SpringBoot初始化！

4、导入依赖

```
DROP TABLE IF EXISTS user; 
CREATE TABLE user 
( 
id BIGINT(20) NOT NULL COMMENT '主键ID', 
name VARCHAR(30) NULL DEFAULT NULL COMMENT '姓名', 
age INT(11) NULL DEFAULT NULL COMMENT '年龄', 
email VARCHAR(50) NULL DEFAULT NULL COMMENT '邮箱', 
PRIMARY KEY (id) 
);
INSERT INTO user (id, name, age, email) VALUES 
(1, 'Jone', 18, 'test1@baomidou.com'), 
(2, 'Jack', 20, 'test2@baomidou.com'), 
(3, 'Tom', 28, 'test3@baomidou.com'), 
(4, 'Sandy', 21, 'test4@baomidou.com'), 
(5, 'Billie', 24, 'test5@baomidou.com'); 
```



-- 实际开发中version（乐观锁）、deleted（逻辑删除）、gmt_create、gmt_modified都是需要加的 

```xml
<dependency>
            <groupId>mysql</groupId>
            <artifactId>mysql-connector-java</artifactId>
        </dependency>
        <!-- lombok -->
        <dependency>
            <groupId>org.projectlombok</groupId>
            <artifactId>lombok</artifactId>
        </dependency>
        <!-- mybatis-plus -->
        <dependency>
            <groupId>com.baomidou</groupId>
            <artifactId>mybatis-plus-boot-starter</artifactId>
            <version>3.0.5</version>
        </dependency>
```

5、连接数据库！这一步和 mybatis 相同

6、传统方式pojo-dao(mybatis 编写dao 配置mapper.xml文件)

6、使用了mybatis-plus 之后

```java
@Repository // 代表持久层 
public interface UserMapper extends BaseMapper<User> { 
// 所有的CRUD操作都已经编写完成了 
// 你不需要像以前的配置一大堆文件了！ 
}
```

