package com.servera.mapper.po;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import lombok.Data;

@Data
public class BasePo {

    //唯一标记
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //创建时间
    @TableField(value = "create_time")
    private Date createTime;

    //更新时间
    @TableField(value = "update_time")
    private Date updateTime;

    //创建用户id
    @TableField(value = "create_id")
    private String createId;

    //更新用户id
    @TableField(value = "update_id")
    private String updateId;

    //租户id
    @TableField(value = "tenant_id")
    private String tenantId;

    @TableField(value = "delete_flag")
    private Integer deleteFlag;
}
