package com.example.restfulcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulcrud.entities.Department;
import com.example.restfulcrud.entities.Employee;
import com.example.restfulcrud.mapper.DepartmentMapper;
import com.example.restfulcrud.mapper.EmployeeMapper;

@RestController
public class DeptController {
	@Autowired
	DepartmentMapper departmentMapper;
	@Autowired
	EmployeeMapper employeeMapper;

	// 查询部门
	@GetMapping("/dept/{id}")
	public Department getDept(@PathVariable("id") Integer id) {
		return departmentMapper.getDeptById(id);
	}

	// 插入部门
	@GetMapping("/dept")
	public Department insertDept(Department department) {
		departmentMapper.insertDept(department);
		return department;
	}

	// 删除部门
	@GetMapping("/delete/{id}")
	public String deleteDept(@PathVariable("id") Integer id) {
		departmentMapper.deleteDeptById(id);
		return "已删除";
	}

	// 查询员工
	@GetMapping("/query/{id}")
	public Employee getEmpById(@PathVariable("id") Integer id) {
		return employeeMapper.getEmpById(id);
	}

}
