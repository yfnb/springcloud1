package com.yf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
//http://eureka7003.com:7003/
//启动之后：访问 http://localhost:7003/
@SpringBootApplication
@EnableEurekaServer  //服务端的启动类，可以接受别人注册进来
public class EurekaServer3 {
    public static void main(String[] args) {
        SpringApplication.run(EurekaServer3.class,args);
    }
}
