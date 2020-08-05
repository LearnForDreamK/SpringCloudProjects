# SpringCloudProjects
springcloud实例练习项目

#踩坑记录

### **项目名：cloud-consumer-order-80**

1.在自己实现LoadBalanced算法过程中 忘记将初始在向IOC容器注入RestTemplate的配置中的@LoadBalanced注解注销掉
