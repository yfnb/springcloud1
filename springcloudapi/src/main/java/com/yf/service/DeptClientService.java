package com.yf.service;

import com.yf.pojo.Dept;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Component
@FeignClient(value = "spring-cloud-privider-dept",fallbackFactory = DeptClientServiceFallbackFactory.class)
public interface DeptClientService {

    @GetMapping("/dept/add")
    public boolean addDept(Dept dept);

    @GetMapping("/dept/get")
    public Dept get(@PathVariable("id") Long id );

    @GetMapping("/dept/list")
    public List<Dept> queryAll();

}
