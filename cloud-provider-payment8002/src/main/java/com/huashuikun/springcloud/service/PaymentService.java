package com.huashuikun.springcloud.service;

import com.huashuikun.api.entity.Payment;

public interface PaymentService {

    public int insert(Payment payment);

    public Payment takePaymentById(Long id);

}
