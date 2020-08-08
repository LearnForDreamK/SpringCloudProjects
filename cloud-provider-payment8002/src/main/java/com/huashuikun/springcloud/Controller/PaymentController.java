package com.huashuikun.springcloud.Controller;
import com.huashuikun.api.entity.CommonResult;
import com.huashuikun.api.entity.Payment;
import com.huashuikun.springcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {
    @Resource
    private PaymentService paymentService;

    //通过注解获取yml文件中的端口号
    @Value("${server.port}")
    private String serverPort;

    //参数+requestbody是因为从80端口传来的请求参数是json格式，不加这个注解会报错
    @PostMapping(value="/payment/insert")
    public CommonResult insert(@RequestBody Payment payment){
        int result=paymentService.insert(payment);
        log.info("插入结果 ： "+result);

        if(result>0){
            return new CommonResult(200,"插入成功"+serverPort,result);
        }else {
            return new CommonResult(400,"插入失败",null);
        }


    }

    @GetMapping(value="/payment/get/{id}")
    public CommonResult getPatmentById(@PathVariable("id") Long id){
        Payment py=paymentService.takePaymentById(id);
        log.info("插入结果 ： "+py);

        if(py!=null){
            return new CommonResult(200,"获取成功"+serverPort,py);
        }else {
            return new CommonResult(404,"获取失败",null);
        }


    }

    //返回端口号 用于测试的方法
    @GetMapping(value = "/payment/lb")
    public String getPaymentLB(){
        return serverPort;
    }


    @GetMapping(value = "/payment/timeout")
    public String timeoutMethod(){

        try {
            TimeUnit.SECONDS.sleep(3);
        }catch (Exception e){
            e.printStackTrace();
        }
        return "当前服务器端口： "+serverPort;
    }
}
