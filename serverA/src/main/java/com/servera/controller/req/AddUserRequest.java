package com.servera.controller.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel
@Data
@ToString
public class AddUserRequest implements Serializable {
    private static final long serialVersionUID = 4699846451656729270L;

    @ApiModelProperty(value = "电话号码")
    private String mobile;

    @ApiModelProperty(value = "名称")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;
}
