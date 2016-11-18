package com.acer.mvc.model;

import java.util.List;
import java.util.Map;

import com.acer.mvc.common.MapDataParse;
import com.acer.mvc.model.dao.CityDao;

public class Model2 implements IModel {

	@Override
	public List<Map<String, String>> getListMapCity() {
		CityDao cityDao = new CityDao();
		List<Map<String, Object>> queryCity = cityDao.queryCity();
		return MapDataParse.mapFormat(queryCity);
	}

	@Override
	public List<Map<String, String>> getListMapTown() {
		return null;
	}

}
