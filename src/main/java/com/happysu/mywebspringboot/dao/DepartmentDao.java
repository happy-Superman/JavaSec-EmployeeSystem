package com.happysu.mywebspringboot.dao;

import com.happysu.mywebspringboot.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//部门dao
@Repository  //表明该类是用来执行与数据库相关的操作(即dao对象)，并支持自动处理数据库操作产生的异常
public class DepartmentDao {

    //模拟数据库中的数据
    private static Map<Integer, Department> departments = null;
    static {
        departments = new HashMap<Integer, Department>();

        departments.put(101, new Department(101, "教学部1"));
        departments.put(102, new Department(102, "教学部2"));
        departments.put(103, new Department(103, "教学部3"));
        departments.put(104, new Department(104, "教学部4"));
        departments.put(105, new Department(105, "教学部5"));
    }

    //对数据库操作
    public Collection<Department> getDepartments(){
        return departments.values();
    }

    //通过id得到部门
    public Department getDepartmentById(Integer id){
        return departments.get(id);
    }
}
