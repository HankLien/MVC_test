package com.acer.mvc.common;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MapDataParse {
	
	public static List<Map<String, String>> mapFormat(List<Map<String, Object>> mapList) {
		List<Map<String, String>> mapStringListView = new ArrayList<>();
		if(mapList != null && mapList.size() > 0) {
			for(Map<String, Object> map : mapList) {
				Set<String> keySet = map.keySet();
				Map<String, String> mapString = new HashMap<>();
				for(String key : keySet) { 
					Object object = map.get(key);
					mapString.put(key, (String)object);
				}
				mapStringListView.add(mapString);
			}
		}
		return mapStringListView;
	}
}
