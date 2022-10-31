package com.servera.security;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/31 11:27
 */

public class CustomLogoutSuccessHandler implements LogoutSuccessHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @Override
    public void onLogoutSuccess(HttpServletRequest httpServletRequest, HttpServletResponse response, Authentication authentication) throws IOException, ServletException{
        System.out.println("注销成功!");
        //这里写你登录成功后的逻辑
        response.setStatus(HttpStatus.OK.value());
        response.setContentType("application/json;charset=UTF-8");
        response.getWriter().write("注销成功!");
    }
}