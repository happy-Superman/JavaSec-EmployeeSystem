package com.happysu.mywebspringboot.controller;


import com.happysu.mywebspringboot.dao.DepartmentDao;
import com.happysu.mywebspringboot.dao.EmployeeDao;
import com.happysu.mywebspringboot.pojo.Department;
import com.happysu.mywebspringboot.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;


/**
 * 正常来说 Controller层调Service层  Service层去调数据库
 * 但是这里为了简化讲解 直接Controller调数据库了
 */
@Controller
public class EmployeeController {

    //自动装配 可以直接调方法
    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> employees = employeeDao.getAll();

        model.addAttribute("emps", employees);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toAddPage(Model model){
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //添加操作
        System.out.println("[Debug]save==>"+employee);
        employeeDao.save(employee);   //调用底层业务方法 保存员工信息
        return "redirect:/emps";
    }

    //去员工的修改页面
    @GetMapping("/emp/{id}")
    //model是用来给前端返回数据的
    public String toUpdateEmp(@PathVariable("id")Integer id, Model model){
        //查出原来的数据  需要和前端进行交互
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp", employee);
        //查出所有部门的信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments", departments);

        return "emp/update";
    }

    //提交修改界面
    @PostMapping ("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/delemp/{id}")
    public String deleteEmp(@PathVariable("id") int id){
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
