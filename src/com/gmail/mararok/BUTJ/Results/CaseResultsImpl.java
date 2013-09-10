/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.TestElementImpl;

public class CaseResultsImpl extends ResultsImpl implements CaseResults {
	private int testsAmount;
	public CaseResultsImpl(TestElementImpl element) {
		super(element);
	}

	public void addTests(int amount) {
		testsAmount += amount;
	}
	
	@Override
	public void onStart() {
		getReporter().onCaseStart(this);
		super.onStart();
	}
	
	@Override
	public void onEnd() {
		super.onEnd();
		getReporter().onCaseEnd(this);
	}
	
	@Override
	public int getTestsAmount() {
		return testsAmount;
	}

}
