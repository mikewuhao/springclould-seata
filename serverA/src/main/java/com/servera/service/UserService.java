package com.servera.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.servera.controller.req.AddUserRequest;
import com.servera.controller.req.ModifyUserRequest;
import com.servera.controller.req.QueryUserRequest;
import com.servera.mapper.po.UserPo;


public interface UserService {

    Integer addUser(AddUserRequest req);

    Integer modifyUser(ModifyUserRequest req);

    Integer deleteUser(Long id);

    IPage<UserPo> queryUserByPage(QueryUserRequest req);

    UserPo getUserInfoByUsername(String userName);

}
