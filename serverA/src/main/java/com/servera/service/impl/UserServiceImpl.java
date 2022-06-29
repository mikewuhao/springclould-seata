package com.servera.service.impl;

import com.servera.controller.req.AddUseRequest;
import com.servera.mapper.UserMapper;
import com.servera.mapper.po.UserPo;
import com.servera.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;
    public Integer addUser(AddUseRequest req) {

        UserPo userDo = new UserPo();
        BeanUtils.copyProperties(req,userDo);
        return userMapper.insert(userDo);
    }
}
