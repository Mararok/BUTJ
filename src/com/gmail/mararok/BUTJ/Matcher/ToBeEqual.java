/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBeEqual extends Matcher {
	private Comparable<Object> expected;
	public ToBeEqual(Object current, Comparable<Object> expected) {
		super(current);
		this.expected = expected;
	}
	
	@Override
	public boolean match() {
		Class<?> matchClass = expected.getClass();
		if (matchClass == current.getClass()) {
			return expected.compareTo(current) == 0;
		}
		
		return false;
	}

	@Override
	public String getMatchMessage() {
		return current+" to be equal "+expected;
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" not to be equal "+expected;
	}

}
