package com.acer.mvc.model;

import com.acer.mvc.constant.Config;

public class ModelFactory {
	
	private static ModelFactory modelFactory;
	
	private static IModel model;
	
	private ModelFactory() {
		
	}
	
	public static ModelFactory getInstance() {
		System.out.println("ModelFactory getInstance()");
		if(modelFactory == null) {
			System.out.println("build new ModelFactory");
			modelFactory = new ModelFactory();
		}
		return modelFactory;
	}
	
	public IModel getModel() {
		System.out.println("ModelFactory.getModel()");
		Class<?> act = null;
		try {
			act = Class.forName(Config.MODEL_CLASS);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try {
			if(model == null) {
				model = (IModel) act.newInstance();
				System.out.println("build new Model");
				System.out.println("getModel = " + model.getClass().getName());
			}
		} catch (InstantiationException | IllegalAccessException e) {
			e.printStackTrace();
		}
		return model;
	}
}
