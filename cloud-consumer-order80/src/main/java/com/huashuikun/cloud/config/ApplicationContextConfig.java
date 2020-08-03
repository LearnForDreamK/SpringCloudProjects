package com.huashuikun.cloud.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {
    //加入到IOC容器以供依赖注入使用
    //增加LoadBalanced让resttemplate有负载均衡的能力 不然resttemplate无法识别url ，访问集群（默认轮询规则）
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }

}
