package com.servera.service.impl;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import com.servera.mapper.po.UserPo;
import com.servera.service.UserService;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/31 11:12
 */
@Component
public class UserDetailsServiceImpl implements UserDetailsService {
    @Resource
    private UserService userService;
    @Resource
    private PasswordEncoder passwordEncoder;

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException{
        /**
         * 1/通过userName 获取到userInfo信息
         * 2/通过User（UserDetails）返回details。
         */
        //通过userName获取用户信息
        UserPo userInfo = userService.getUserInfoByUsername(userName);
        if (userInfo == null) {
            throw new UsernameNotFoundException("not found");
        }
        //定义权限列表.
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 用户可以访问的资源名称（或者说用户所拥有的权限） 注意：必须"ROLE_"开头，TODO
        authorities.add(new SimpleGrantedAuthority("ROLE_" + "ADMIN"));//userInfo.getRole()));
        User userDetails = new User(userName, passwordEncoder.encode(userInfo.getPassword()), authorities);
        return userDetails;
    }
}
