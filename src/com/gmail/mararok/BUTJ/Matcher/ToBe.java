/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBe extends Matcher {
	private Object expected;
	
	public ToBe(Object current, Object expected) {
		super(current);
		this.expected = expected;
	}

	@Override
	public boolean match() {
		return current == expected;
	}

	@Override
	public String getMatchMessage() {
		return current+" to be "+expected;
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" not to be "+expected;
	}

}
