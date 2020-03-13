package com.example.restfulcrud.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 使用JPA注解映射关系
 * 
 * @Entity告诉JPA这是一个实体类(和数据表映射的类) @Table来指定和哪个数据表对应，如果省略默认为小写类名user
 * @author pitt
 */
@Entity
@Table(name = "tbl_user")
public class User {

	@Id // 这是一个主键
	@GeneratedValue(strategy = GenerationType.IDENTITY) // 自增主键
	private Integer id;

	@Column(name = "last_name", length = 50) // 这是数据表中的一列
	private String lastName;
	@Column // 默认列名为属性名
	private String email;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
