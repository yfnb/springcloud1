package com.yf.config;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {
    //IRule
    //AvailablityFilteringRule :跳闸，过滤掉访问故障的服务
    @Bean
    @LoadBalanced  //ribbon 负载均衡
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    //添加负载均衡，随机匹配，这块如果需要重写自己的规则，放到包的上层去，不要放在这里
    @Bean
    public IRule myRule(){
        return new RandomRule();

    }
}
