package com.happysu.mywebspringboot.dao;

import com.happysu.mywebspringboot.pojo.Department;
import com.happysu.mywebspringboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

//员工dao
@Repository
public class EmployeeDao {

    //模拟数据库中的数据
    private static Map<Integer, Employee> employees = null;

    //员工信息中存在 部门信息 需要把部门的dao导入
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>();   //创建一个哈希表
        employees.put(1001, new Employee(1001, "AA1", "2221@qq.com", 0, new Department(101, "教学部1")));
        employees.put(1002, new Employee(1002, "AA2", "2222@qq.com", 1, new Department(102, "教学部2")));
        employees.put(1003, new Employee(1003, "AA3", "2223@qq.com", 0, new Department(103, "教学部3")));
        employees.put(1004, new Employee(1004, "AA4", "2224@qq.com", 1, new Department(104, "教学部4")));
        employees.put(1005, new Employee(1005, "AA5", "2225@qq.com", 0, new Department(105, "教学部5")));
    }

    //对数据库操作 增删改查

    //主键自增
    private static Integer initId = 1006;
    //增加一个员工
    public void save(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));

        employees.put(employee.getId(), employee);
    }

    //查询全部员工信息
    public Collection<Employee> getAll(){
        return employees.values();
    }

    //通过id查询员工
    public Employee getEmployeeById(Integer id){
        return employees.get(id);
    }

    //通过id删除员工
    public void delete(Integer id){
        employees.remove(id);
    }
}
