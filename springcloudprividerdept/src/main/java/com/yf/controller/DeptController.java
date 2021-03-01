package com.yf.controller;

import com.yf.pojo.Dept;
import com.yf.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;
    //获取一些配置信息，得到具体的微服务
    @Autowired
    private DiscoveryClient client;

    @PostMapping("/dept/add")
    public boolean addDept(Dept dept) {
        return deptService.addDept(dept);
    }

    @GetMapping("/dept/get")
    public Dept queryById(@PathParam("id") Long id) {
        return deptService.queryById(id);
    }

    @GetMapping("/dept/list")
    public List<Dept> queryAll() {

        return deptService.queryAll();
    }

    //注册进来的微服务，获取一些信息
    @GetMapping("/dept/discovery")
    public Object discovery() {
        //获取微服务列表的清单
        List<String> services = client.getServices();
        System.out.println("discovery=>services:" + services);

        //得到具体的微服务信息，通过具体的微服务id,applicationName
        List<ServiceInstance> instances = client.getInstances("spring-cloud-privider-dept");

        for (ServiceInstance instance : instances) {
            System.out.println(
                    instance.getHost() + "\t"
                            + instance.getPort() + "\t" +
                            instance.getUri() + "\t"
                            + instance.getServiceId());
        }
        return this.client;
    }
}
