package com.acer.mvc.model.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import com.acer.mvc.model.entity.City;

public class CityDao extends BaseDao {
	
	private final String QUERY_ALL_CITY = "select * from DTS.H_CITY";

	public List<Map<String, Object>> queryCity() {
		DataSource dataSource = this.getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> cityList = jdbcTemplate.queryForList(QUERY_ALL_CITY);
		return cityList;
	}
	
	public List<City> queryEntityCity() {
		DataSource dataSource = this.getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<City> cityList = jdbcTemplate.queryForList(QUERY_ALL_CITY, City.class);
		return cityList;
	}
}
