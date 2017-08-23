package com.example.demo.utils;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;

public class JdbcUtils {
	
	@Value("${spring.datasource.driver-class-name}")
	private static String JdbcDriver;
	
	@Value("${spring.datasource.url}")
	private static String url;
	
	@Value("${spring.datasource.username}")
	private static String user;
	
	@Value("${spring.datasource.password}")
	private static String password;

	/**
	 * 获取connection(第一个方法有误,暂用getConnection2)
	 * @return
	 * @throws Exception
	 */
	public static Connection getConnection() throws Exception{
		Class.forName(JdbcDriver);
		return DriverManager.getConnection(url, user, password);
	}
	
	public static Connection getConnection2() throws Exception{
		InputStream inputStream = JdbcUtils.class.getClassLoader().getResourceAsStream("db.properties");
		Properties properties = new Properties();
		properties.load(inputStream);
		
		Class.forName(properties.getProperty("driver"));
		return DriverManager.getConnection(properties.getProperty("url"), properties.getProperty("username"), properties.getProperty("password"));
	}
	
	
	/**
	 * 释放db相关的资源
	 * @param connection
	 * @param resultSet
	 * @param statement
	 */
	public static void release(Connection connection,ResultSet resultSet,Statement statement){
		if (resultSet != null) {
			try {
				resultSet.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (connection != null) {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if (statement != null) {
			try {
				statement.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
