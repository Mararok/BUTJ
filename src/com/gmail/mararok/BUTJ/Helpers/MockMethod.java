/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Helpers;

import java.lang.reflect.Method;
import java.util.HashMap;

public class MockMethod {
	private MockObject mockObject;
	private Method method;
	private HashMap<String, Object> invokeResults; 
	
	public MockMethod(MockObject mockObject, Method method) {
		this.mockObject = mockObject;
		this.method = method;
	}
	
	public void addInvokeResults(Object returnValue, Object... args) {
		
	}
	
	private boolean checkArgs(Object... args) {
		Class<?>[] parameters  = method.getParameterTypes();
		if (args.length != parameters.length) {
			throw new RuntimeException(String.format("[MockObject] %s.%s not enough arguments ",));
			return false;
		}
		
		for (int i = 0, len = args.length; i < len; ++i) {
			if (!parameters[i].isInstance(args)) {
				return false;
			}
		}
	}
}
