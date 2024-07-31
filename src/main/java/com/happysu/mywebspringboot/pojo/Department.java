package com.happysu.mywebspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//伪造数据 仿真数据库
//部门表
@Data   //数据
@AllArgsConstructor  //有参构造
@NoArgsConstructor   //无参构造
public class Department {
    private Integer id;
    private String department;

}
