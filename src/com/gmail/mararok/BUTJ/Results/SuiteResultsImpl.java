/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.TestElementImpl;

public class SuiteResultsImpl extends ResultsImpl implements SuiteResults {
	private int suitesAmount;
	private int casesAmount;
	private int testsAmount;
	
	public SuiteResultsImpl(TestElementImpl element) {
		super(element);
	}

	public void addSuites(int amount) {
		suitesAmount += amount;
	}
	
	public void addCases(int amount) {
		casesAmount += amount;
	}
	
	public void addTests(int amount) {
		testsAmount += amount;
	}
	
	@Override
	public void onStart() {
		getReporter().onSuiteStart(this);
		super.onStart();
	}
	
	@Override
	public void onEnd() {
		super.onEnd();
		getReporter().onSuiteEnd(this);
	}
	
	@Override
	public int getSuitesAmount() {
		return suitesAmount;
	}

	@Override
	public int getCasesAmount() {
		return casesAmount;
	}
	
	@Override
	public int getTestsAmount() {
		return testsAmount;
	}

}
