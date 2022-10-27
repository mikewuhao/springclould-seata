package com.servera.mapper.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import lombok.Data;

@TableName(value = "user")
@Data
public class UserPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "username")
    private String username;

    @TableField(value = "addtime")
    private Date addtime;

    @TableField(value = "test_text")
    private String test_text;

    @TableField(value = "test_blob")
    private String test_blob;
}
