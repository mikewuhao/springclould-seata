package com.servera.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.servera.controller.req.AddUseRequest;
import com.servera.mapper.UserMapper;
import com.servera.mapper.po.UserPo;
import com.servera.service.UserService;
import com.servera.utils.InjectCommonParam;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Resource
    private InjectCommonParam injectCommonParam;

    @Override
    public Integer addUser(AddUseRequest req){

        UserPo userDo = new UserPo();
        BeanUtils.copyProperties(req, userDo);
        injectCommonParam.insertFills(userDo);
        return userMapper.insert(userDo);
    }
}
