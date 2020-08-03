package com.huashuikun.springcloud.service.impl;

import com.huashuikun.api.entity.Payment;
import com.huashuikun.springcloud.dao.PaymentDao;
import com.huashuikun.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PaymentServiceImpl implements PaymentService {

    @Resource
    private PaymentDao paymentDao;

    @Override
    public int insert(Payment payment) {
        return paymentDao.insert(payment);
    }

    @Override
    public Payment takePaymentById(Long id) {
        return paymentDao.takePaymentById(id);
    }
}
