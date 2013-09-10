/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public class ToBeTrue extends Matcher {
	public ToBeTrue(Object current) {
		super(current);
	}
	
	@Override
	public boolean match() {	
		return (current instanceof Boolean)? (boolean)current : current != null;
	}

	@Override
	public String getMatchMessage() {
		return current+" to be true";
	}

	@Override
	public String getMatchNegationMessage() {
		return current+" not to be true";
	}

}
