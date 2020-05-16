package com.zhang.dao;

import com.zhang.pojo.Department;
import com.zhang.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据
    private static Map<Integer, Employee> employeeMap = null;
    @Autowired
    private DepartmentDao departmentDao;
    static {
        employeeMap = new HashMap<>();
        employeeMap.put(1001,new Employee(1001,"AA","@!",1,new Department(101,"教学部")));
        employeeMap.put(1002,new Employee(1002,"ZZ","@#",0,new Department(102,"市场部")));
        employeeMap.put(1003,new Employee(1003,"XX","@#",1,new Department(103,"校验部")));
        employeeMap.put(1004,new Employee(1004,"CC","@%",0,new Department(104,"运营部")));
        employeeMap.put(1005,new Employee(1005,"SS","@#",0,new Department(105,"后勤部")));
    }

    //增加一个员工，主键自增
    private static Integer initId = 1006;
    public void save(Employee employee){
        if(employee.getId() == null){
            employee.setId(initId ++);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employeeMap.put(employee.getId(),employee);
    }
    //获取所有人员信息
    public Collection<Employee> getEmployee(){
        return employeeMap.values();
    }

    //根据id获取所有人员 信息
    public Employee getEmployeeById(Integer id){
        return employeeMap.get(id);
    }
    //删除员工、
    public void remove(Integer id){
        employeeMap.remove(id);
    }

    public void update(Employee employee){
        Department department = new Department();
        department.setId(employee.getDepartment().getId());
        department.setDepartmentName(employee.getDepartment().getDepartmentName());
        employee.setDepartment(department);
        employeeMap.put(employee.getId(),employee);
    }

}
