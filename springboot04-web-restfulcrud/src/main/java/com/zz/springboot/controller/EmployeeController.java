package com.zz.springboot.controller;

import com.zz.springboot.dao.DepartmentDao;
import com.zz.springboot.dao.EmployeeDao;
import com.zz.springboot.entities.Department;
import com.zz.springboot.entities.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeDao employeeDao;

    @Autowired
    DepartmentDao departmentDao;

    //查询所有员工
    @GetMapping("/emps")
    public String getAll(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps", employees);
        return "emp/list";
    }

    //来到添加员工的页面
    @GetMapping("/emp")
    public String toAddPage(Model model) {
        //查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);
        return "emp/add";
    }

    //添加员工
    @PostMapping("/emp")
    public String add(Employee employee) {
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    //来到修改员工的页面
    @GetMapping("/emp/{id}")
    public String toEditPage(@PathVariable("id") Integer id, Model model) {
        //查出员工，在页面回显
        Employee employee = employeeDao.get(id);
        model.addAttribute("emp", employee);

        //查出所有的部门，在页面显示
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("depts", departments);

        return "emp/add";
    }

    //修改员工 带id input标签hidden
    @PutMapping("/emp")
    public String edit(Employee employee) {
        employeeDao.save(employee);

        //重定向
        return "redirect:/emps";
    }

    //删除员工 带id input标签hidden
    @DeleteMapping("/emp/{id}")
    public String remove(@PathVariable("id") Integer id) {
        employeeDao.delete(id);
        return "redirect:/emps";
    }
}
