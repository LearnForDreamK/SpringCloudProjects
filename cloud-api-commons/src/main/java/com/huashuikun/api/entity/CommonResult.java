package com.huashuikun.api.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


//通用返回给前端的包装类  里面放置三个值  包含3个构造器
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    //状态码
    private Integer id;


    //返回的消息 比如success
    private String message;

    //任意对象T（泛型）
    private T result;

    public CommonResult(int id,String message){
        this(id,message,null);

    }
}
