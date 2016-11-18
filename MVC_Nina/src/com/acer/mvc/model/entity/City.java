package com.acer.mvc.model.entity;

public class City {
	private String provinceNo;
	private String cityNo;
	private String cityName;
	public String getProvinceNo() {
		return provinceNo;
	}
	public void setProvinceNo(String provinceNo) {
		this.provinceNo = provinceNo;
	}
	public String getCityNo() {
		return cityNo;
	}
	public void setCityNo(String cityNo) {
		this.cityNo = cityNo;
	}
	public String getCityName() {
		return cityName;
	}
	public void setCityName(String cityName) {
		this.cityName = cityName;
	}
	@Override
	public String toString() {
		return provinceNo + ";" + cityNo + ";" + cityName;
	}
}
