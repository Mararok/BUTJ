/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Helpers;

import java.util.Arrays;
import java.util.HashMap;

public class MockMethod<T> {
	private String methodName;
	private HashMap<String, Object> invokeResults; 
	private HashMap<String,Exception> invokeThrows; 
	
	public MockMethod(String methodName) {
		this.methodName = methodName;
		invokeResults = new HashMap<String, Object>();
		invokeThrows = new HashMap<String,Exception>();
	}
	
	public void addInvokeResults(Object returnValue, Object[] args) {
		invokeResults.put(getArgsString(args),returnValue);
	}
	
	public Object getInvokeResults(Object[] args) {
		return invokeResults.get(getArgsString(args));
	}
	
	public void addInvokeThrow(Exception exception, Object[] args) {
		invokeThrows.put(getArgsString(args),exception);
	}
	
	public Exception getInvokeThrows(Object[] args) {
		return invokeThrows.get(getArgsString(args));
	}
	
	public String getName() {
		return methodName;
	}
	
	public static String getArgsString(Object[] args) {
		return (args == null)? "[]" : Arrays.toString(args);
	}
}
