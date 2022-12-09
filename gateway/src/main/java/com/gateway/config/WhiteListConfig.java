package com.gateway.config;


import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

import java.util.ArrayList;
import java.util.List;

/**
 * Copyright 2022 skyworth
 *
 * @Author: wuhao
 * @CreateTime: 2022-12-09 15:44
 * @Description: 网关白名单配置（跳过鉴权token）
 * @Version: 1.0
 **/
@Component
@ConfigurationProperties(prefix = "white.filter")
public class WhiteListConfig {

    private final PathMatcher pathMatcher = new AntPathMatcher();

    @Getter
    @Setter
    private List<String> uri = new ArrayList<>();

    public boolean isCanAccess(String path) {
        return uri.stream().anyMatch(r -> pathMatcher.match(r, path));
    }

}
