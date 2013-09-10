/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.gmail.mararok.BUTJ.Matcher.Matcher;
import com.gmail.mararok.BUTJ.Matcher.ToBe;
import com.gmail.mararok.BUTJ.Matcher.ToBeFalse;
import com.gmail.mararok.BUTJ.Matcher.ToBeNull;
import com.gmail.mararok.BUTJ.Matcher.ToBeTrue;
import com.gmail.mararok.BUTJ.Results.Results;
import com.gmail.mararok.BUTJ.Results.TestResultsImpl;

public class TestEnviromentImpl extends TestElementImpl implements TestEnviroment {
	private TestCase context;
	private Method testMethod;
	
	private Object current;
	private boolean negation;
	
	private TestResultsImpl results;
	
	public TestEnviromentImpl(TestCase context, Method testMethod) {
		super(testMethod.getName());
		this.context = context;
		this.results = new TestResultsImpl(this);
		this.testMethod = testMethod;
	}
	
	@Override
	public void run() {
		try {
			results.onStart();
				this.testMethod.invoke(context,this);
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
	
	public TestEnviromentImpl expect(Object current) {
		this.current = current;
		return this;
	}
	
	public TestEnviromentImpl toBe(Object expected) {
		match(new ToBe(current,expected));
		return this;
	}
	
	public TestEnviroment toBeNull() {
		match(new ToBeNull(current));
		return this;
	}
	
	public TestEnviroment toBeTrue() {
		match(new ToBeTrue(current));
		return this;
	}
	public TestEnviroment toBeFalse() {
		match(new ToBeFalse(current));
		return this;
	}
	
	public TestEnviroment toBeEqual(Comparable<?> expected) {
		return this;
	}
	
	public TestEnviromentImpl not() {
		this.negation = !this.negation;
		return this;
	}
	
	public TestEnviromentImpl or() {
		throw new RuntimeException("NOT SUPPORTED YET");
		//return this;
	}
	
	public TestEnviromentImpl and() {
		throw new RuntimeException("NOT SUPPORTED YET");
		//return this;
	
	}
	
	private void match(Matcher matcher) {
		String message = null;
		if (negation) {
			if (!matcher.matchNegation()) {
				message = matcher.getMatchMessage();
			}
		} else {
			if (!matcher.match()) {
				message = matcher.getMatchNegationMessage();
			}
		}
		negation = false;
		if (message != null) {
			Throwable exception  = new Throwable();
			StackTraceElement pos = exception.getStackTrace()[0];
			for (StackTraceElement ste : exception.getStackTrace()) {
				if (ste.getClassName() == context.getClass().getName()) {
					pos = ste;
					break;
				}
			}
			results.addUnexceptedResults(message,pos);
		}
	}

	@Override
	public Results getResults() {
		return results;
	}

}
