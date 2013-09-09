/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.gmail.mararok.BUTJ.Results.TestResultsImpl;
import com.gmail.mararok.BUTJ.StandardMachers.ToBeMatcher;

public class TestEnviroment extends TestElement {
	private Method testMethod;
	
	private Object current;
	private boolean negation;
	
	private TestResultsImpl results;
	
	public TestEnviroment(Method testMethod) {
		super(testMethod.getName());
		this.results = new TestResultsImpl(this);
		this.testMethod = testMethod;
	}
	
	@Override
	void run() {
		try {
			results.onStart();
				this.testMethod.invoke(getParent(),this);
			results.onEnd();
			
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}
		
	public void describe(String description) {
		this.results.setDescription(description);
	}
	
	public TestEnviroment expect(Object current) {
		this.current = current;
		return this;
	}
	
	public TestEnviroment toBe(Object expected) {
		match(new ToBeMatcher(),expected);
		return this;
	}
	
	public TestEnviroment not() {
		this.negation = !this.negation;
		return this;
	}
	
	public TestEnviroment or() {
		throw new RuntimeException("NOT SUPPORTED YET");
		//return this;
	}
	
	public TestEnviroment and() {
		return this;
	
	}
	
	private void match(Matcher matcher, Object expected) {
		String message = null;
		if (this.negation) {
			if (!matcher.matchNegation(this.current,expected)) {
				message = matcher.getMatchNegationMessage(this.current,expected);
			}
		} else {
			if (!matcher.match(this.current,expected)) {
				message = matcher.getMatchNegationMessage(this.current,expected);
			}
		}
		
		if (message != null) {
			Throwable exception  = new Throwable();
			results.addUnexceptedResults(message,exception.getStackTrace()[2]);
		}
	}

}
