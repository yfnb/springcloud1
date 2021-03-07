package com.yf.service;

import com.yf.pojo.Dept;
import feign.hystrix.FallbackFactory;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class DeptClientServiceFallbackFactory implements FallbackFactory {

    public Object create(Throwable throwable) {
        return new DeptClientService() {
            public boolean addDept(Dept dept) {
                return false;
            }

            public Dept get(Long id) {
                return new Dept().setDeptno(id).setDname("没找到数据").setDb_source("没有数据库");
            }

            public List<Dept> queryAll() {
                return null;
            }
        };
    }
}
