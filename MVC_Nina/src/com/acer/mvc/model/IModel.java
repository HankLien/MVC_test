package com.acer.mvc.model;

import java.util.List;
import java.util.Map;

public interface IModel {
	public List<Map<String, String>> getListMapCity();
	public List<Map<String, String>> getListMapTown(String provinceNo, String cityNo);
}
