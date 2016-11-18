package com.acer.mvc.model.dao;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

public class TownDao extends BaseDao {

	private final String QUERY_ALL_CITY = "select * from AD_MENU";

	public List<Map<String, Object>> queryCity() {
		DataSource dataSource = this.getDataSource();
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Map<String, Object>> cityList = jdbcTemplate.queryForList(QUERY_ALL_CITY);
		return cityList;
	}
}
