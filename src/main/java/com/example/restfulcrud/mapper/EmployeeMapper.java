package com.example.restfulcrud.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.restfulcrud.entities.Employee;

@Mapper
public interface EmployeeMapper {

	public Employee getEmpById(Integer id);

	public void insertEmp(Employee employee);
}
