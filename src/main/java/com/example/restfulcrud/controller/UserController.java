package com.example.restfulcrud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.example.restfulcrud.entities.User;
import com.example.restfulcrud.repository.UserRepository;

@RestController
public class UserController {
	@Autowired
	UserRepository userRepository;

	// 查询
	@GetMapping("/user/{id}")
	public User getUser(@PathVariable("id") Integer id) {
		User user = userRepository.findOne(id);
		return user;

	}

	// 增加
	@GetMapping("/user")
	public User insertUser(User user) {
		User save = userRepository.save(user);
		return save;
	}
}
