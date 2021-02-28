package com.yf.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;
@Data
@NoArgsConstructor
@Accessors(chain = true) //支持链式写法
public class Dept  implements Serializable {
    private long deptno;
    private String dname;
    //这个数据存在哪个数据库，微服务，一个服务对于一个数据库，同一个信息存在不同的数据库
    private String db_source;

    public Dept(String dname) {
        this.dname = dname;
    }
}
