package com.servera.controller.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

@ApiModel
@Data
@ToString
public class AddUseRequest implements Serializable {
    private static final long serialVersionUID = 4699846451656729270L;

    @ApiModelProperty(value = "用户名称")
    private String  username;

    @ApiModelProperty(value = "创建时间")
    private Date addtime;

    @ApiModelProperty(value = "标题")
    private String  test_text;

    @ApiModelProperty(value = "内容")
    private String test_blob;
}
