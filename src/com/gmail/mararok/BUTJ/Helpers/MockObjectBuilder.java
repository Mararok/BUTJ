/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Helpers;

import java.lang.reflect.Method;
import java.util.HashMap;

import javassist.util.proxy.MethodFilter;
import javassist.util.proxy.Proxy;
import javassist.util.proxy.ProxyFactory;

public class MockObjectBuilder {
	private HashMap<String,Class<Proxy>> proxyClasses;
	private ProxyFactory proxyFactory;
	
	public MockObjectBuilder() {
		proxyClasses = new HashMap<String,Class<Proxy>>();
		
		proxyFactory = new ProxyFactory();
		proxyFactory.setFilter(new MethodFilter() {
		     public boolean isHandled(Method m) {
		         // ignore finalize()
		         return !m.getName().equals("finalize");
		     }
		 });
	}
	@SuppressWarnings("unchecked")
	public MockObject from(Class<?> base) {
		Class<Proxy> proxyClass = proxyClasses.get(base.getName());
		if (proxyClass == null) {
			proxyFactory.setSuperclass(base);
			proxyClass = (Class<Proxy>)proxyFactory.createClass();
			proxyClasses.put(base.getName(),proxyClass);
		}
		try {
			return new MockObject(proxyClass.newInstance());
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
}
