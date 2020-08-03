package com.huashuikun.springcloud.service;

import com.huashuikun.api.entity.Payment;
import org.apache.ibatis.annotations.Param;

public interface PaymentService {

    public int insert(Payment payment);

    public Payment takePaymentById(Long id);

}
