package com.yf.controller;

import com.yf.pojo.Dept;
import com.yf.service.DeptClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
public class DeptConsumerController {

    @Autowired
    private DeptClientService deptClientService;

    @RequestMapping("/consumer/dept/add")
    public boolean addDept(Dept dept){
        return deptClientService.addDept(dept);
    }

    @RequestMapping("/consumer/dept/get")
    public Dept get(@PathVariable("id") Long id ){
       return deptClientService.get(id);
    }

    @RequestMapping("/consumer/dept/list")
    public List<Dept> queryAll(){
        return deptClientService.queryAll();
    }






}
