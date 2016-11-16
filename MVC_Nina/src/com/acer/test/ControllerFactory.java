package com.acer.test;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * 
 * @author Hank L
 *
 */
public class ControllerFactory {
	private IController iController;

	public IController getInstance() {
		String className = this.readSetPropertyClass();
		Class<?> act = null;
		try {
			act = Class.forName(className);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			if (iController == null) {
				iController = (IController) act.newInstance();
			} else {
				return iController;
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return iController;
	}

	public String readSetPropertyClass() {
		Properties properties = new Properties();
		String configFile = "controller_setting.properties";
		try {
			properties.load(ControllerFactory.class.getResourceAsStream(configFile));
		} catch (FileNotFoundException ex) {
			ex.printStackTrace();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return (String) properties.get("controller");
	}
}
