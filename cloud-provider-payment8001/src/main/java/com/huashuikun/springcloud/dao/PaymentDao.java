package com.huashuikun.springcloud.dao;

import com.huashuikun.api.entity.Payment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper
public interface PaymentDao {


    public int insert(Payment payment);

    public Payment takePaymentById(@Param("id") Long id);

}
