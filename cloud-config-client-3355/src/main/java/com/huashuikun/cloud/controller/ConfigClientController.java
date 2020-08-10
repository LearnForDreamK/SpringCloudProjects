package com.huashuikun.cloud.controller;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 *
 * 通过引入springboot actuator 监控依赖和 在yml中暴露监控端口 ，加入controller刷新注解 实现动态加载配置文件
 *
 * 但需要发送post请求手动刷新   在cmd 中 curl -X POST "http://localhost:3355/actuator/refresh"
 */
@RefreshScope
@RestController
public class ConfigClientController {


    //测试拿取配置文件中的属性值

    @Value("${spring.info}")
    private String configInfo;

    @GetMapping("/configInfo")
    public String getConfigInfo(){
        return configInfo;
    }
}

