/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Matcher;

public abstract class Matcher {
	protected static final String MatchMessageFormat = "%s %s %s";
	protected static final String MatchNegationMessageFormat = "%s not %s %s";
	
	protected Object current;
	
	public Matcher(Object current) {
		this.current = current;
	}
	
	public abstract boolean match();
	public boolean matchNegation() {
		return !match();
	}
	
	public abstract String getMatchMessage();
	
	public abstract String getMatchNegationMessage();

}
