# SpringCloudProjects
springcloud实例练习项目

#踩坑记录

### **项目名：cloud-consumer-order-80**

1.在自己实现LoadBalanced算法过程中 忘记将初始在向IOC容器注入RestTemplate的配置中的@LoadBalanced注解注销掉



### **项目名：cloud-consumer-feign-order-80**

1.启动项目出错，发现注册eureka的地址有误（本地DNS配置地址127.0.0.1 www.eureka700X.com）

2.ribbon超时配置，在application文件中配置全局ribbion超时时间时，发现idea没有任何提示，无法识别ribbon的这些属性（可能
因为ribbon是间接导入的？？），但是按照说明配置后，启动项目后发现配置有用

### **项目名：cloud-provider-hystrix-payment8001**

1.在配置hystrix熔断器时，用的@HystrixComment注解，里面有commandProperties这一数组，里面存放的是key value类的属性值，很好奇
这些属性值从哪里可以看到，通过搜索（shift+shift）发现了HystrixPropertiesCommandDefault extends HystrixCommandProperties,
下载HystrixCommandProperties的源码 可以看到这些属性值相关注释了解属性是干嘛的

2.熔断器在发生异常时没有进行服务降级操作，发现主启动类没有添加@EnableHystrix （思维导图没有。。。。）

3.在测试时ribbon的时间限制记得关注一下，如果测试的时间过长，ribbion也会引起服务降级，让服务无法成功运行，导致服务永远处于降级状态

### **项目名**：cloud-consumer-hystrix-dashboard9001

1.导入依赖时 ,发现无法导入这个依赖

```xml
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-starter-netflix-hystrix-dashboard</artifactId>
</dependency>
```

这个依赖需要配合两个其他依赖 ，这个时候 ，就发现上面的依赖已经成功导入了

```xml
<dependency>
    <groupId>com.netflix.hystrix</groupId>
    <artifactId>hystrix-javanica</artifactId>
    <version>RELEASE</version>
</dependency>
<dependency>
    <groupId>org.springframework.cloud</groupId>
    <artifactId>spring-cloud-netflix-hystrix-dashboard</artifactId>
</dependency>
```

2.新版本Hystrix需要在服务端主启动类指定监控路径

3.在访问http://localhost:9001/hystrix/ 监控8001的过程中，页面一直处于loading的空白状态，在网上查询发现，需要在访问和HystrixComment注解相关
的服务的时候，这个页面才会加载出来！，此时访问http://localhost:8001/payment/circuit/1  画面就出来了

### **项目名**：cloud-gateway-gateway9527

1.网关需要在所有微服务启动后再启动，不然后开启的微服务网关的负载均衡无法起作用（eureka的问题）

2.网关启动后关闭一个微服务，eureka的安全模式会导致轮询发生异常


### **项目名**：cloud-config-center3344

1.启动项目报错，通过错误信息发现是配置文件中的url: ssh地址出现问题，我的电脑已经配置了公匙和私匙，但是还是报错，将ssh改为https链接后错误消失

### **项目名**：cloud-config-client-3355

1.cmd中发送请求  ``` curl -X POST "http://localhost:3355/actuator/refresh"中  ``` -x 必须大写 -X


### **项目名**：cloud-stream-rabbitmq-provider8801

1.默认情况下，guest用户被禁止通过远程连接到RabbitMQ，它只能用localhost连接。你自己创建的其它的用户不会受限于这一条。

方法1：这个配置是通过配置文件中的loopback_users来设置的。 我配置的是阿里云的docker上面的rabbit mq 通过修改/etc/rabbitmq/rabbitmq.conf中的loopback_users= none 来让
guest用户远程连接
方法2：
docker run -d --restart=always --name myrabbitmqadmin -e RABBITMQ_DEFAULT_USER=admin -e RABBITMQ_DEFAULT_PASS=admin -p 15672:15672 -p 5672:5672 181d2227d92f

但这都没解决问题。。。。。  暂定。。。。。