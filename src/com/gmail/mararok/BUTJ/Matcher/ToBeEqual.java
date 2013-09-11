/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBeEqual extends Matcher {
	private Object expected;
	public ToBeEqual(Object current, Object expected) {
		super(current);
		this.expected = expected;
	}
	
	@Override
	public boolean match() {
		if (current == null) {
			return (expected == null)? true : expected.equals(current); 
		} 
		
		return current.equals(expected);
	}

	@Override
	public String getMatchMessage() {
		return current+" to be equals "+expected;
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" not to be equals "+expected;
	}

}
