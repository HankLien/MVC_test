package com.acer.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ControllerImpl implements IController {
	private Model model = new Model();

	@Override
	public List<Map<String, String>> getFilterTowns(String provinceNo, String cityNo) {

		return getModel().getFilterTowns(provinceNo, cityNo);
	}

	@Override
	public List<Map<String, String>> getListMapCity() {

		return getModel().getListMapCity();
	}

	@Override
	public Map<String, String> doSubmit(UserVo vo) {

		return this.doValidate(vo);
	}

	private Map<String, String> doValidate(UserVo vo) {
		Map<String, String> map = new HashMap<String, String>();

		if (!EmailValidator.validate(vo.getEmail())) {
			map.put("email", "email��J�榡���~");
			System.out.println(">> vo.getEmail() = " + vo.getEmail());
		}

		if (!PhoneNumberValid.isPhoneNumberValid(vo.getPhone())) {
			map.put("phone", "������X��J�榡���~");
		}
		return map;
	}

	public Model getModel() {
		return model;
	}
}
