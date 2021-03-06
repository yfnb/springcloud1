package com.yf.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.yf.pojo.Dept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yf.service.DeptService;

import javax.websocket.server.PathParam;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //获取一些配置信息，得到具体的微服务

    @GetMapping("/dept/list")
    @HystrixCommand(fallbackMethod = "queryAllhystrix")
    public List<Dept> queryAll() {

        int random = (int)(Math.random()*3);
        if(random==2){
            throw  new RuntimeException("查询出现异常");
        }

        return deptService.queryAll();
    }



    public List<Dept> queryAllhystrix() {
       Dept dept=new Dept();
       dept.setDeptno(0).setDname("没有对应的信息").setDb_source("no database");
       List<Dept> list=new ArrayList();
       list.add(dept);
        return list;
    }







}
