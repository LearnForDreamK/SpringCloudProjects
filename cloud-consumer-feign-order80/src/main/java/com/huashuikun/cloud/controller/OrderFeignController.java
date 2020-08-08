package com.huashuikun.cloud.controller;


import com.huashuikun.api.entity.CommonResult;
import com.huashuikun.api.entity.Payment;
import com.huashuikun.cloud.serrvice.PaymentFeignService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {


    @Resource
    private PaymentFeignService paymentFeignService;

    @GetMapping(value = "/consumer/payment/get/{id}")
    public CommonResult<Payment> getPaymentById(@PathVariable("id") Long id){
        return paymentFeignService.getPatmentById(id);
    }


    @GetMapping(value = "/consumer/payment/timeout")
    public String timeoutMethod(){

        return paymentFeignService.timeoutMethod();
    }

}
