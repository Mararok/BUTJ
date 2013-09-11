/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBeInstanceOf extends Matcher {
	private Class<?> expected;
	
	public ToBeInstanceOf(Object current,Class<?> expected) {
		super(current);
		this.expected = expected;
	}

	@Override
	public boolean match() {
		return expected.isInstance(current);
	}

	@Override
	public String getMatchMessage() {
		return current+" of "+current.getClass().getName()+" class to be instance of "+expected.getName();
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" of "+current.getClass().getName()+" class not to be instance of "+expected.getName();
	}

}
