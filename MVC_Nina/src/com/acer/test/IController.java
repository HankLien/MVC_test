package com.acer.test;

import java.util.List;
import java.util.Map;

public interface IController {
  
  public List<Map<String, String>> getFilterTowns(String provinceNo , String cityNo);
  public List<Map<String, String>> getListMapCity();
  public Map<String, String> doSubmit(UserVo vo);

}
