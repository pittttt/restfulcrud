package com.example.restfulcrud.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.restfulcrud.entities.User;

//继承JpaRepository来完成对数据库操作
public interface UserRepository extends JpaRepository<User, Integer> {

}
