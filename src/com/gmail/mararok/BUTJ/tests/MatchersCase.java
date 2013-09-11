/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.tests;

import com.gmail.mararok.BUTJ.TEST;
import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.BUTJ.TestEnviroment;
import com.gmail.mararok.BUTJ.Matcher.Matcher;
import com.gmail.mararok.BUTJ.Matcher.ToBe;
import com.gmail.mararok.BUTJ.Matcher.ToBeEqual;
import com.gmail.mararok.BUTJ.Matcher.ToBeFalse;
import com.gmail.mararok.BUTJ.Matcher.ToBeInstanceOf;
import com.gmail.mararok.BUTJ.Matcher.ToBeNull;
import com.gmail.mararok.BUTJ.Matcher.ToBeTrue;

public class MatchersCase extends TestCase {
	private Matcher matcher;
	public MatchersCase() {
		super("Matchers");
	}
	
	@Override
	public void beforeEach() {
		matcher = null;
	}
	
	@TEST
	public void toBeMatcher(TestEnviroment it) {
		String s = "s";
		matcher = new ToBe(s,s);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("s to be s");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("s not to be s");
	}
	
	@TEST
	public void toBeMatcherNegation(TestEnviroment it) {
		String s = "s";
		String s2 = "s2";
		
		matcher = new ToBe(s2,s);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("s2 to be s");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("s2 not to be s");
	}
	
	@TEST
	public void toBeInstanceOfMatcher(TestEnviroment it) {
		String s = "s";
		matcher = new ToBeInstanceOf(s,String.class);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("s of java.lang.String class to be instance of java.lang.String");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("s of java.lang.String class not to be instance of java.lang.String");
	}
	
	@TEST
	public void toBeInstanceOfMatcherNegation(TestEnviroment it) {
		String s = "s";
		
		matcher = new ToBeInstanceOf(s,Boolean.class);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("s of java.lang.String class to be instance of java.lang.Boolean");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("s of java.lang.String class not to be instance of java.lang.Boolean");
	}
	
	@TEST
	public void toBeNullMatcher(TestEnviroment it) {
		String s = null;
		matcher = new ToBeNull(s);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("null to be null");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("null not to be null");
	}
	
	@TEST
	public void toBeNullMatcherNegation(TestEnviroment it) {
		String s = "s";
		matcher = new ToBeNull(s);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("s to be null");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("s not to be null");
	}
	
	@TEST
	public void toBeFalseMatcher(TestEnviroment it) {
		matcher = new ToBeFalse(false);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("false to be false");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("false not to be false");
		
		matcher = new ToBeFalse(null);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("null to be false");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("null not to be false");
	}
	
	@TEST
	public void toBeFalseMatcherNegation(TestEnviroment it) {
		matcher = new ToBeFalse(true);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("true to be false");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("true not to be false");
	}
	
	@TEST
	public void toBeTrueMatcher(TestEnviroment it) {
		matcher = new ToBeTrue(true);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("true to be true");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("true not to be true");
		
		matcher = new ToBeTrue(null);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("null to be true");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("null not to be true");
	}
	
	@TEST
	public void toBeTrueMatcherNegation(TestEnviroment it) {
		matcher = new ToBeTrue(false);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("false to be true");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("false not to be true");
	}
	
	
	@TEST
	public void toBeEqualMatcher(TestEnviroment it) {
		matcher = new ToBeEqual(1,1);
		it.expect(matcher.match()).toBeTrue();
		it.expect(matcher.matchNegation()).toBeFalse();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("1 to be equals 1");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("1 not to be equals 1");
	}
	
	@TEST
	public void toBeEqualMatcherNegation(TestEnviroment it) {
		matcher = new ToBeEqual(1,2);
		it.expect(matcher.match()).toBeFalse();
		it.expect(matcher.matchNegation()).toBeTrue();
		
		it.expect(matcher.getMatchMessage()).toBeEqual("1 to be equals 2");
		it.expect(matcher.getMatchNegationMessage()).toBeEqual("1 not to be equals 2");
	}
	
}
