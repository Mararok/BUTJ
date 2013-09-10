/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBeFalse extends Matcher {

	public ToBeFalse(Object current) {
		super(current);
	}
	
	@Override
	public boolean match() {	
		return (current instanceof Boolean)? !(boolean)current : current == null;
	}

	@Override
	public String getMatchMessage() {
		return current+" to be false";
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" not to be false";
	}
	
}
