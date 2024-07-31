package com.happysu.mywebspringboot.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

//员工表
@Data
//@AllArgsConstructor  因为我们想修改一下有参构造
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;  //0: 女   1: 男

    private Department department;

    //规范日期格式
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth;

    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //生成默认的日期
        this.birth = new Date();
    }
}
