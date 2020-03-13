package com.example.restfulcrud;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootWebRestfulcrudApplicationTests {

	@Autowired
	DataSource dataSuorce;

	@Test
	public void contextLoads() throws SQLException {
		// org.apache.tomcat.jdbc.pool.DataSource
		System.out.println(dataSuorce.getClass());

		Connection connection = dataSuorce.getConnection();
		System.out.println(connection);
		connection.close();
	}

}
