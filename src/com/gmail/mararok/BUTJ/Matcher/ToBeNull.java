/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBeNull extends Matcher {
	
	public ToBeNull(Object current) {
		super(current);
	}

	@Override
	public boolean match() {
		return current == null;
	}

	@Override
	public String getMatchMessage() {
		return current+" to be null";
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" not to be null";
	}

}
