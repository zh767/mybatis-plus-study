package com.zh.plus.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.Date;

/**
 * Created By IntelliJ IDEA.
 * ClassName :User
 * Date :2020/4/23 9:35
 * Description:
 */
@Data
@AllArgsConstructor
@ToString
@NoArgsConstructor
public class User {
    /*AUTO(0), // 数据库id自增
    NONE(1), // 未设置主键
    INPUT(2), // 手动输入
    ID_WORKER(3), // 默认的全局唯一id
    UUID(4), // 全局唯一id uuid
    ID_WORKER_STR(5); //ID_WORKER 字符串表示法*/
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String email;
    @TableField(fill = FieldFill.INSERT)
    private Date createTime;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date updateTime;
    @Version //乐观锁Version注解
    private Integer version;
    @TableLogic //逻辑删除
    private Integer deleted;
}