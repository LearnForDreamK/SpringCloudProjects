package com.huashuikun.api.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


//data注解默认生成set get方法  ，下面两个注解生成全参构造器和空构造器
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Payment implements Serializable {

    public long id;
    public String serial;

}
