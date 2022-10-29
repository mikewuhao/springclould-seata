package com.servera.controller;

import org.springblade.core.tool.api.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.servera.controller.req.AddUserRequest;
import com.servera.controller.req.ModifyUserRequest;
import com.servera.controller.req.QueryUserRequest;
import com.servera.mapper.po.UserPo;
import com.servera.service.UserService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/user")
@Api(tags = {"用户管理"}, value = "用户管理")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @ApiOperation(value = "添加")
    public R addUser(@RequestBody AddUserRequest req){
        return R.data(userService.addUser(req));
    }

    @PostMapping("/modify")
    @ApiOperation(value = "修改")
    public R modifyUser(@RequestBody ModifyUserRequest req){
        return R.data(userService.modifyUser(req));
    }

    @PostMapping("/delete/{id}")
    @ApiOperation(value = "删除")
    public R deleteUser(@PathVariable("id") Long id){
        return R.data(userService.deleteUser(id));
    }

    @PostMapping("/list")
    @ApiOperation(value = "分页查询")
    public R<IPage<UserPo>> queryUserByPage(@RequestBody QueryUserRequest req){
        return R.data(userService.queryUserByPage(req));
    }

}
