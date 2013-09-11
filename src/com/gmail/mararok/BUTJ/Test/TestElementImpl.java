/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Test;

import com.gmail.mararok.BUTJ.Results.Results;

public abstract class TestElementImpl {
	private String name;
	private TestElementContainer parent;
	
	TestElementImpl(String name) {
		this.name = name;
		this.parent = null;
	}
	
	public abstract void run();
	
	public String getName() {
		return this.name;
	}
	
	public String getFullName() {
		if (getParent() != null) {
			return String.format("%s. %s",getParent().getFullName(),getName());
		}
		return getName();
	}
	
	public TestElementContainer getParent() {
		return parent;
	}
	
	public void setParent(TestElementContainer newParent) {
		if (getParent() != null) {
			getParent().remove(this);
		}
		
		this.parent = newParent;
	}
	
	public Reporter getReporter() {
		return parent.getReporter();
	}
	
	public abstract Results getResults();
}
