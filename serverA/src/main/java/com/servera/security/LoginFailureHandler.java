package com.servera.security;

import java.io.IOException;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description
 * @Author wangtiaochun
 * @Date 2022/10/31 13:56
 */
@Component("loginFailureHandler")
public class LoginFailureHandler extends SimpleUrlAuthenticationFailureHandler {
    private Logger logger = LoggerFactory.getLogger(getClass());
    @Resource
    private ObjectMapper objectMapper;

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException exception) throws IOException, ServletException{
        logger.info("登录失败");
        this.saveException(request, exception);
        this.getRedirectStrategy().sendRedirect(request, response, "/login?error=true");
    }
}