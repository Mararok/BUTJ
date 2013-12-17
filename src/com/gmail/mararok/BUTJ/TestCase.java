/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

public class TestCase {
	private String name;
	public TestEnviroment it;
	
	public TestCase(String name) {
		this.name = name;
	}
	
	public void beforeEach() {}
	public void afterEach() {}
	
	public String getName() {
		return name;
	}
}
