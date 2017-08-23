package com.example.demo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.demo.model.Student;
import com.example.demo.utils.JdbcUtils;

public class StudentsDao {

	public List<Student> query(){
		
		List<Student> students = new ArrayList<>();
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		ResultSet resultSet = null;
		String sql = "select * from student";
		
		try {
			connection = JdbcUtils.getConnection2();
			preparedStatement = connection.prepareStatement(sql);
			resultSet = preparedStatement.executeQuery();
			
			Student student = null;
			while (resultSet.next()) {
				int id = resultSet.getInt("id");
				String name = resultSet.getString("name");
				int age = resultSet.getInt("age");
				
				student = new Student();
				student.setName(name);
				student.setId(id);
				student.setAge(age);
				
				students.add(student);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			JdbcUtils.release(connection, resultSet, preparedStatement);
		}
		
		return students;
	}
}
