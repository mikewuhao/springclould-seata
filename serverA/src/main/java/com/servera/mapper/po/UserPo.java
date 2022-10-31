package com.servera.mapper.po;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName(value = "user")
@Data
public class UserPo extends BasePo {

    @TableField(value = "mobile")
    private String mobile;

    @TableField(value = "name")
    private String name;

    @TableField(value = "password")
    private String password;

    @TableField(value = "age")
    private Integer age;
}
