/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import com.gmail.mararok.BUTJ.Results.ResultsImpl;

public abstract class TestElement<Results extends ResultsImpl> {
	private String name;
	private TestSuite parent;
	protected Results results;
	
	TestElement(String name) {
		this.name = name;
		this.parent = null;
	}
	
	abstract void run();
	
	public String getName() {
		return this.name;
	}
	
	public String getFullName() {
		if (getParent() != null) {
			return String.format("%s. %s",getParent().getFullName(),getName());
		}
		return getName();
	}
	
	protected TestSuite getParent() {
		return parent;
	}
	
	void setParent(TestSuite newParent) {
		this.parent = newParent;
	}
	
	Reporter getReporter() {
		return parent.getReporter();
	}
}
