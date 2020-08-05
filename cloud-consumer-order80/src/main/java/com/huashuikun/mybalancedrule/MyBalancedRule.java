package com.huashuikun.mybalancedrule;


import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyBalancedRule {

    @Bean
    public IRule myrule(){

        return new RandomRule();
    }

}
