package com.acer.mvc.model;

import java.util.List;
import java.util.Map;

import com.acer.mvc.model.dao.CityDao;
import com.acer.mvc.model.dao.TownDao;

public class Model2 implements IModel {

	@Override
	public List<Map<String, String>> getListMapCity() {
		CityDao cityDao = new CityDao();
		List<Map<String, String>> cityMapList = cityDao.queryCity();
		return cityMapList;
	}

	@Override
	public List<Map<String, String>> getListMapTown(String provinceNo, String cityNo) {
		TownDao townDao = new TownDao();
		List<Map<String, String>> queryTown = townDao.queryTown(provinceNo, cityNo);
		return queryTown;
	}

}
