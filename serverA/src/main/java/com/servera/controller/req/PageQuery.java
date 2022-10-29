package com.servera.controller.req;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/29 14:55
 */
@Data
public class PageQuery {

    @ApiModelProperty(value = "当前页页码")
    private Integer pageNum;

    @ApiModelProperty(value = "每页显示数量")
    private Integer pageSize;

}
