package com.zhang.controller;

import com.zhang.dao.DepartmentDao;
import com.zhang.dao.EmployeeDao;
import com.zhang.pojo.Department;
import com.zhang.pojo.Employee;
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
    @RequestMapping("/emps")
    public String list(Model model){
        Collection<Employee> list = employeeDao.getEmployee();
        model.addAttribute("emps",list);
        return "emp/list";
    }

    @GetMapping("/emp")
    public String toEmpPage(Model model){
        //employeeDao.save(employee);
        //查询部门信息
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);
        return "emp/add";
    }

    @PostMapping("/emp")
    public String addEmp(Employee employee){
        //employeeDao.save(employee);
        employeeDao.save(employee);
        return "redirect:/emps";
    }

    @GetMapping("/emp/{id}")
    public String toEditEmpPage(@PathVariable("id") Integer id, Model model){
        Employee employee = employeeDao.getEmployeeById(id);
        model.addAttribute("emp",employee);
        //查询部门信息
        Collection<Department> department = departmentDao.getDepartment();
        model.addAttribute("departments",department);
        return "emp/update";
    }

    @GetMapping("/delemp/{id}")
    public String toEditEmp(@PathVariable ("id") Integer id){
        employeeDao.remove(id);
        return "redirect:/emps";
    }

    @PostMapping("/updateEmp")
    public String updateEmp(Employee employee){
        employeeDao.save(employee);
        return "redirect:/emps";
    }
}
