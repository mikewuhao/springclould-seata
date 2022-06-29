package com.servera.controller;

import com.servera.controller.req.AddUseRequest;
import com.servera.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springblade.core.tool.api.R;

@RestController
@RequestMapping("/user")
@Api(tags = {"用户管理"}, value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public R saveConstructCondition(@RequestBody AddUseRequest req) {
        return R.data(userService.addUser(req));
    }


}
