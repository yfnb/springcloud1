package com.yf.service;

import com.yf.pojo.Dept;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface DeptService {
    public boolean addDept(Dept dept);
    public Dept queryById(Long id);
    public List<Dept> queryAll();
}
