package com.example.demo.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowCallbackHandler;

import com.example.demo.model.Student;

public class SpringTemplateDao {

	private JdbcTemplate jdbcTemplate;
	
	public List<Student> query(){
		final List<Student> students = new ArrayList<>();
		String sql = "select * from student";
		jdbcTemplate.query(sql, new RowCallbackHandler(){
			@Override
			public void processRow(ResultSet resultSet) throws SQLException {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				
				Student student = new Student();
				student.setName(name);
				student.setId(id);
				student.setAge(age);
				
				students.add(student);
			}
		});
		return students;
	}
}
