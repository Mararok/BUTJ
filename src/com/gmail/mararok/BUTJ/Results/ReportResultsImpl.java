/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.TestElementImpl;

public class ReportResultsImpl extends ResultsImpl implements ReportResults {
	private int suitesAmount;
	private int casesAmount;
	private int testsAmount;
	
	public ReportResultsImpl(TestElementImpl element) {
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
		getReporter().onReportStart(this);
		super.onStart();
	}
	
	@Override
	public void onEnd() {
		super.onEnd();
		getReporter().onReportEnd(this);
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
