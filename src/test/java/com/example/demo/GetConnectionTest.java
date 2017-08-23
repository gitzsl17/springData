package com.example.demo;

import java.sql.Connection;

import org.junit.Test;

import com.example.demo.utils.JdbcUtils;

import junit.framework.Assert;

public class GetConnectionTest {

	@Test
	public void getConnectionT1() throws Exception{
		Connection connection = JdbcUtils.getConnection();
		Assert.assertNotNull(connection);
	}
	
	@Test
	public void getConnectionT2() throws Exception{
		Connection connection2 = JdbcUtils.getConnection2();
		Assert.assertNotNull(connection2);
	}
}
