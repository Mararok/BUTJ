/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Helpers;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;

import javassist.util.proxy.MethodHandler;
import javassist.util.proxy.Proxy;

public class MockObject implements MethodHandler {
	private Proxy proxyObject;
	private Class<?> baseClass;
	private HashMap<String,MockMethod> mockMethods;
	private MockMethod currentMethod;
	private Object[] currentArgs;
	private boolean closed;
	public MockObject(Proxy proxyObject,Class<?> baseClass) {
		this.proxyObject = proxyObject;
		this.baseClass = baseClass;
		this.proxyObject.setHandler(this);
		for (Method method : baseClass.getDeclaredMethods()) {
			mockMethods.put(method.getName(),new MockMethod(this,method));
		}
	}
	
	@Override
	public Object invoke(Object self, Method thisMethod, Method proceed,
			Object[] args) throws Throwable {
		System.out.printf("invoked %s method with args "+Arrays.toString(args),thisMethod.getName());
		return null;
	}
	
	public MockObject when(String methodName) {
		if (!isClose()) {
			currentMethod = mockMethods.get(methodName);
			if (currentMethod == null) {
				throw new RuntimeException(
					String.format("[MockObject] Mock object of class %s hasn't method %s",baseClass.getName(),methodName)
				);
			}
		}
		return this;
	}
	
	public MockObject get(Object... args) {
		if (!isClose()) {
			if (currentMethod == null) {
				throw new RuntimeException("[MockObject] You must set method before that");
			}
			currentArgs = args;
		}
		return this;
	}
	
	public MockObject thenGive(Object returnValue) {
		if (!isClose()) {
			if (currentMethod == null) {
				throw new RuntimeException("[MockObject] You must set method before that");
			}
		}
		return this;
	}
	
	public MockObject thenThrow(Exception throwsException) {
		
		return this;
	}
	
	public MockObject and() {
		return this;
	}
	
	public Object close() {
		closed = true;
		return proxyObject;
	}
	
	public boolean isClose() {
		return closed;
	}

}
