# SpringCloudProjects
springcloud实例练习项目

#踩坑记录

### **项目名：cloud-consumer-order-80**

1.在自己实现LoadBalanced算法过程中 忘记将初始在向IOC容器注入RestTemplate的配置中的@LoadBalanced注解注销掉



### **项目名：cloud-consumer-feign-order-80**

1.启动项目出错，发现注册eureka的地址有误（本地DNS配置地址127.0.0.1 www.eureka700X.com）

2.ribbon超时配置，在application文件中配置全局ribbion超时时间时，发现idea没有任何提示，无法识别ribbon的这些属性（可能
因为ribbon是间接导入的？？），但是按照说明配置后，启动项目后发现配置有用

