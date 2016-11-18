package com.acer.mvc.model;

import com.acer.mvc.constant.Config;

public class ModelFactory {
	
	private static ModelFactory modelFactory;
	
	private ModelFactory() {
		
	}
	
	public static ModelFactory getInstance() {
		
		if(modelFactory == null) {
			modelFactory = new ModelFactory();
		}
		
		return modelFactory;
	}
	
	public IModel getModel() {
		IModel model = null;
		Class<?> act = null;
		try {
			act = Class.forName(Config.MODEL_CLASS);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			model = (IModel) act.newInstance();
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return model;
	}
}
