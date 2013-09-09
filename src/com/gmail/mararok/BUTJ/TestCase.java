/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.BUTJ.Results.CaseResultsImpl;

public abstract class TestCase extends TestElement<CaseResultsImpl> {
	private CaseResultsImpl results;
	private List<TestEnviroment> tests;
	
	public TestCase(String name) {
		super(name);
	}
	
	protected void beforeEach() {
		
	}
	
	protected void afterEach() {
		
	}
	
	void run() {
		loadTests();
		results.onStart();
			for (TestElement test: tests) {
				beforeEach();
					test.run();
				afterEach();	
			}
		results.onEnd();
	}
	
	
	private void loadTests() {
		tests = new LinkedList<TestEnviroment>();
		
		Class<?> caseClass = (Class<?>) this.getClass();
		Method[] methods = caseClass.getMethods();
		for (Method method : methods) {
			if (method.getAnnotation(Test.class) != null) {
				tests.add(new TestEnviroment(method));
			}
		}
	}
	
	private void addTest(TestEnviroment test) {
		test.setParent(this);
	}
	
}
