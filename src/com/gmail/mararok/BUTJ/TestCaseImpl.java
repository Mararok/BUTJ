/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.lang.reflect.Method;

import com.gmail.mararok.BUTJ.Results.CaseResultsImpl;
import com.gmail.mararok.BUTJ.Results.Results;

public class TestCaseImpl extends TestElementContainer {
	private CaseResultsImpl results;
	private TestCase testCase;
	
	public TestCaseImpl(TestCase testCase) {
		super(testCase.getName());
		results = new CaseResultsImpl(this);
		this.testCase = testCase;
	}
	
	public void run() {
		loadTests();
		results.onStart();
			for (TestElementImpl test: getList()) {
				testCase.beforeEach();
					test.run();
				testCase.afterEach();	
			}
		results.onEnd();
	}
	
	
	private void loadTests() {
		
		Class<?> caseClass = testCase.getClass();
		Method[] methods = caseClass.getMethods();
		for (Method method : methods) {
			if (isTest(method)) {
				add(new TestEnviromentImpl(testCase,method));
				results.addTests(1);
			}
		}
	}
	
	private boolean isTest(Method method) {
		if (method.getAnnotation(TEST.class) != null && method.getAnnotation(IGNORE.class) == null) {
			Class<?>[] parameters = method.getParameterTypes();
			if (parameters.length > 0 && parameters[0] == TestEnviroment.class) {
				return true;
			}
		}
		
		return false;	
	}

	@Override
	public Results getResults() {
		return results;
	}
	
}
