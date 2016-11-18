package com.acer.model.test;

import java.util.List;
import java.util.Map;

import org.junit.Test;

import com.acer.mvc.model.dao.CityDao;
import com.acer.mvc.model.entity.City;

public class TestCityDao {

	@Test
	public void test() {
		try {
			CityDao cityDao = new CityDao();
			List<Map<String, Object>> queryCity = cityDao.queryCity();
			for(Map<String, Object> map : queryCity) {
				System.out.println(map.entrySet());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Test
	public void test2() {
		try {
			CityDao cityDao = new CityDao();
			List<City> queryCity = cityDao.queryEntityCity();
			for(City city : queryCity) {
//				System.out.println(map.entrySet());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
