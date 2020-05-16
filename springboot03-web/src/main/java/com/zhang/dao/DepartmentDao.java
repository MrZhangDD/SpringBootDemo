package com.zhang.dao;

import com.zhang.pojo.Department;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class DepartmentDao {

    //模拟数据
    private static Map<Integer, Department> departmentMap;

    static {
        departmentMap = new HashMap<>();
        departmentMap.put(101, new Department(101, "教学部"));
        departmentMap.put(102, new Department(102, "市场部"));
        departmentMap.put(103, new Department(103, "校验部"));
        departmentMap.put(104, new Department(104, "运营部"));
        departmentMap.put(105, new Department(105, "后勤部"));
    }

    //获取所有部门信息
    public Collection<Department> getDepartment() {
        return departmentMap.values();
    }

    //根据id获取所有部门信息
    public Department getDepartmentById(Integer id) {
        return departmentMap.get(id);
    }
}
