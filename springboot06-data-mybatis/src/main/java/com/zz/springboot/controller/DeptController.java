package com.zz.springboot.controller;

import com.zz.springboot.bean.Department;
import com.zz.springboot.bean.Employee;
import com.zz.springboot.mapper.DepartmentMapper;
import com.zz.springboot.mapper.EmployeeMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DeptController {
    @Autowired
    DepartmentMapper departmentMapper;

    @Autowired
    EmployeeMapper employeeMapper;

    @GetMapping("/dept/{id}")
    public Department getDept(@PathVariable("id") Integer id) {
        Department department = departmentMapper.selectById(id);
        return department;
    }

    @GetMapping("/dept")
    public Department insertDept(Department department) {
        departmentMapper.insertDept(department);
        return department;
    }

    @GetMapping("/emp/{id}")
    public Employee getEmp(@PathVariable("id") Integer id) {
        Employee emp = employeeMapper.getEmpById(id);
        return emp;
    }
}
