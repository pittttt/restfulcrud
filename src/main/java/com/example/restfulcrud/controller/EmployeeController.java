package com.example.restfulcrud.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.example.restfulcrud.dao.DepartmentDao;
import com.example.restfulcrud.dao.EmployeeDao;
import com.example.restfulcrud.entities.Department;
import com.example.restfulcrud.entities.Employee;

@Controller
public class EmployeeController {
	@Autowired
	EmployeeDao employeeDao;

	@Autowired
	DepartmentDao departmentDao;

	// model是用于前端页面数据展示的，而entity则是与数据库进行交互做存储用途
	// 查询所有员工返回列表页面
	@GetMapping("/emps")
	public String list(Model model) {
		Collection<Employee> employees = employeeDao.getAll();

		// 放在请求域中,页面才能拿到值
		model.addAttribute("emps", employees);
		return "emp/list";
	}

	@GetMapping("/emp")
	// 来到员工添加页面
	public String toAddPage(Model model) {
		Collection<Department> departments = departmentDao.getDepartments();

		// 放在请求域中,页面才能拿到值
		model.addAttribute("depts", departments);
		return "emp/add";
	}

	/**
	 * 员工添加
	 * 
	 * SpringMVC会将请求参数对象和入参对象属性绑定，请求参数对象需要和bean中对象属性名一样
	 * 
	 * 返回值会由模板解析，直接在templates下寻找，如果需要跳转则需要返回重定向或者转发
	 * 
	 * forward转发 redirect重定向
	 */
	@PostMapping("/emp")
	public String addEmp(Employee employee) {
		// 保存员工
		// System.out.println(employee);
		employeeDao.save(employee);
		// 重定向至员工列表页面
		return "redirect:/emps";
	}

	// 来到修改页面，查出当前员工，在页面回显
	@GetMapping("/emp/{id}")
	public String toEditPage(@PathVariable("id") Integer id, Model model) {
		// 根据id获取员工
		Employee employee = employeeDao.get(id);
		model.addAttribute("emp", employee);
		// 获取部门列表
		Collection<Department> departments = departmentDao.getDepartments();
		// 放在请求域中,页面才能拿到值
		model.addAttribute("depts", departments);
		// 回到编辑页面(add是一个修改添加二合一)
		return "emp/add";
	}

	// 修改员工信息，需要提交员工id
	@PutMapping("/emp")
	public String updateEmployee(Employee employee) {
		// System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}

	// 删除员工
	@DeleteMapping("/emp/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id) {
		employeeDao.delete(id);
		return "redirect:/emps";
	}
}
