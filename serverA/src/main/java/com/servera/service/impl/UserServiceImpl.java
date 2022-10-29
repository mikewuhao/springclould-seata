package com.servera.service.impl;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.servera.controller.req.AddUserRequest;
import com.servera.controller.req.ModifyUserRequest;
import com.servera.controller.req.QueryUserRequest;
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
    public Integer addUser(AddUserRequest req){

        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(req, userPo);
        injectCommonParam.insertFills(userPo);
        return userMapper.insert(userPo);
    }

    @Override
    public Integer modifyUser(ModifyUserRequest req){

        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(req, userPo);
        injectCommonParam.updateFills(userPo);
        return userMapper.updateById(userPo);
    }

    @Override
    public Integer deleteUser(Long id){

        UserPo userPo = new UserPo();
        userPo.setId(id);
        //1代表删除，这里做逻辑删除
        userPo.setDeleteFlag(1);
        return userMapper.updateById(userPo);
    }

    @Override
    public IPage<UserPo> queryUserByPage(QueryUserRequest req){

        long current = req.getPageNum() == null ? 1 : req.getPageNum();
        long size = req.getPageSize() == null ? 10 : req.getPageSize();
        Page<UserPo> page = new Page<>(current, size);

        QueryWrapper<UserPo> queryWrapper = new QueryWrapper<>();
        UserPo userPo = new UserPo();
        BeanUtils.copyProperties(req, userPo);
        queryWrapper.setEntity(userPo);

        return userMapper.selectPage(page, queryWrapper);
    }
}
