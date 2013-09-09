/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

public abstract class Matcher {
	private static final String MatchMessageFormat = "%s %s %s";
	private static final String MatchNegationMessageFormat = "%s not %s %s";
	
	public abstract boolean match(Object current, Object expected);
	
	public boolean matchNegation(Object current, Object expected) {
		return !match(current,expected);
	}
	
	public String getMatchMessage(Object current, Object expected) {
		return String.format(MatchMessageFormat,current.toString(),getJoint(),expected);
	}
	
	public String getMatchNegationMessage(Object current, Object expected) {
		return String.format(MatchNegationMessageFormat,current.toString(),getJoint(),expected);
	}
	
	public abstract String getJoint();
}
