package com.example.restfulcrud.controller;

import java.util.Arrays;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloController {

	@ResponseBody // 将返回值返回给网页
	@RequestMapping("/hello")
	public String hello() {
		return "hello";
	}

	// 通过thymeleaf将页面http://localhost:8080/success跳转到templates下的当前方法的返回值.html文件
	// 查数据，在页面显示
	@RequestMapping("/success")
	public String success(Map<String, Object> map) {
		map.put("hello", "<h1>你好</h1>");
		map.put("users", Arrays.asList("zhangsan ", "lisi ", "wangwu"));
		return "success";
	}
}
