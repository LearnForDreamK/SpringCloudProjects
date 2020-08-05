package com.huashuikun.cloud.loadbalanced;

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalanced {
    //获取所有可用的服务器实例的方法
    ServiceInstance instances(List<ServiceInstance> serviceInstanceList);

}
