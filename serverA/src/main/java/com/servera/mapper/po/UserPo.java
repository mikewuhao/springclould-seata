package com.servera.mapper.po;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

@TableName(value = "user")
@Data
public class UserPo {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    @TableField(value = "用户名称")
    private String  username;

    @TableField(value = "创建时间")
    private Date addtime;

    @TableField(value = "标题")
    private String  test_text;

    @TableField(value = "内容")
    private String test_blob;
}
