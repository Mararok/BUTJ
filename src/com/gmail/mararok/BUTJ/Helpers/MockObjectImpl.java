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

public class MockObjectImpl<T> implements MethodHandler,MockObject<T> {
	private T proxyObject;
	private Class<T> baseClass;
	private Method[] methods;
	private String objectName;
	
	private HashMap<String,MockMethod<T>> mockMethods;
	private MockMethod<T> currentMethod;
	private Object[] currentArgs;
	private boolean closed;
	
	public MockObjectImpl(T proxyObject,Class<T> baseClass) {
		this.proxyObject = proxyObject;
		this.baseClass = baseClass;
		((Proxy)this.proxyObject).setHandler(this);
		objectName = baseClass.getSimpleName();
		mockMethods = new HashMap<String,MockMethod<T>>();
		methods = baseClass.getDeclaredMethods();
	}

	@Override
	public Object invoke(Object self, Method thisMethod, Method proceed,
			Object[] args) throws Throwable {
		System.out.printf("invoked %s method with args %d %s \n",thisMethod.getName(),args.length,Arrays.toString(args));
		MockMethod<T> m = mockMethods.get(thisMethod.getName());
		if (m != null) {
			Exception e = m.getInvokeThrows(args);
			if (e != null) {
				throw e;
			}
			
			Object ret = m.getInvokeResults(args);
			if (ret != null) {
				return ret;
			}
		}
		return proceed.invoke(self,args);
	}
	
	@Override
	public MockObject<T> withName(String objectName) {
		this.objectName = objectName;
		return this;
	}
	
	@Override
	public MockObject<T> when(String methodName) {
		if (!isClose()) {
			Method method = findMethod(methodName);
			if (method == null) {
				throw new RuntimeException(
					String.format("[MockObject] Mock object of class %s hasn't method %s",baseClass.getName(),methodName)
				);
			} else {
				currentMethod = mockMethods.get(methodName);
				if (currentMethod == null) {
					currentMethod = new MockMethod<T>(methodName);
					mockMethods.put(methodName,currentMethod);
				}
			}
		}
		return this;
	}
	
	private Method findMethod(String methodName) {
		for (Method method : methods) {
			if (methodName.equals(method.getName()))
				return method;
		}
		return null;
	}
	
	@Override
	public MockObject<T> get(Object... args) {
		if (!isClose()) {
			if (currentMethod == null) {
				throw new RuntimeException("[MockObject] You must set method before that");
			}
			currentArgs = args;
		}
		return this;
	}
	
	@Override
	public MockObject<T> thenGive(Object returnValue) {
		if (!isClose()) {
			if (currentMethod == null) {
				throw new RuntimeException(
					String.format("[MockObject] You can't set return value for %s without method select",getName())
				);
			} else {
				currentMethod.addInvokeResults(returnValue,currentArgs);
				currentMethod = null;
				currentArgs = null;
			}
		}
		return this;
	}
	
	@Override
	public MockObject<T> thenThrow(Exception throwsException) {
		if (!isClose()) {
			if (currentMethod == null) {
				throw new RuntimeException(
					String.format("[MockObject] You can't set throwing for %s without method select",getName())
				);
			} else {
				currentMethod.addInvokeThrow(throwsException,currentArgs);
				currentMethod = null;
			}
		}
		return this;
	}
	
	@Override
	public MockObject<T> and() {
		return this;
	}
	
	@Override
	public T close() {
		closed = true;
		return proxyObject;
	}
	
	public boolean isClose() {
		return closed;
	}
	
	public String getName() {
		return objectName;
	}
	
}
