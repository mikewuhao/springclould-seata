package com.servera.controller.req;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

@ApiModel
@Data
@ToString
public class QueryUserRequest extends PageQuery implements Serializable {
    private static final long serialVersionUID = 421846451656729270L;

    @ApiModelProperty(value = "名称")
    private String name;
}
