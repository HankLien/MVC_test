package com.acer.mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class ConnectionFactory {
	
	public ConnectionFactory() {
	}
	
	public Connection getConnection() {
		Connection connection = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			String url = "jdbc:oracle:thin:@10.36.4.243:1521:AGBSDEV";
			String user = "dts";
			String pssd = "agbsDEV";
			connection = DriverManager.getConnection(url,user,pssd);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return connection;
	}
	
	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
	    dataSource.setDriverClassName("oracle.jdbc.driver.OracleDriver");
	    dataSource.setUsername("dts");
	    dataSource.setPassword("agbsDEV");
	    dataSource.setUrl("jdbc:oracle:thin:@10.36.4.243:1521:AGBSDEV");
	    return dataSource;
	}
	
//	@Test
	public void springJdbcTest() {
		DataSource dataSource = new ConnectionFactory().getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		
		//test01
		List<Map<String, Object>> queryForList = jdbcTemplate.queryForList("select * from ACCOUNT");
		
		for(Map<String, Object> map : queryForList) {
			String menuName = (String) map.get("LOGIN_ID");
			System.out.println(menuName);
		}
		
		//test02
//		List<Menu> queryForList = jdbcTemplate.queryForList("select * from AD_MENU", XXX.class);
	}
	
	@Test
	public void jdbcTest() {
		Connection connection = new ConnectionFactory().getConnection();
		try {
			PreparedStatement prepareStatement = connection.prepareStatement("select * from ACCOUNT");
			ResultSet result = prepareStatement.executeQuery();
			while(result.next()) {
				System.out.println(result.getString("LOGIN_ID"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
