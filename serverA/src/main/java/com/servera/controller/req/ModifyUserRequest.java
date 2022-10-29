package com.servera.controller.req;

import lombok.Data;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/29 10:53
 */

@Data
public class ModifyUserRequest extends AddUserRequest {
    private static final long serialVersionUID = 4699846451652129270L;
    private Long id;
}
