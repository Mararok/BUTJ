/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Helpers;

import java.lang.reflect.Method;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.ProxyFactory;

public class MockObjectBuilder {
	private ProxyFactory proxyFactory;
	
	public MockObjectBuilder() {
		proxyFactory = new ProxyFactory();
		proxyFactory.setFilter(new MethodFilter() {
		     public boolean isHandled(Method m) {
		         // ignore finalize()
		         return !m.getName().equals("finalize");
		     }
		 });
	}
	@SuppressWarnings("unchecked")
	public <T> MockObject<T> from(Class<T> base) {
		proxyFactory.setSuperclass(base);
		Class<T> proxyClass = proxyFactory.createClass();
		//System.out.println(proxyClass.getName());
		try {
			return new MockObjectImpl<T>(proxyClass.newInstance(),base);
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
