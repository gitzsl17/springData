package com.example.demo;

import javax.sql.DataSource;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.util.Assert;

public class DataSourceTest {
	
	private ApplicationContext ctx = null;

	//执行代码前执行加载beans.xml
	@Before
	public void setup(){
		ctx = new ClassPathXmlApplicationContext("beans.xml");
	}
	@After
	public void tearDown(){
		ctx = null;
	}
	@Test
	public void testDataSource(){
		DataSource dataSource = (DataSource) ctx.getBean("dataSource");
		Assert.notNull(dataSource);	//断言dataSource不为空
	}
	
	@Test
	public void testJdbcTemplate(){
		JdbcTemplate jdbcTemplate = (JdbcTemplate) ctx.getBean("jdbcTemplate");
		Assert.notNull(jdbcTemplate);	//断言jdbcTemplate不为空
	}
}
