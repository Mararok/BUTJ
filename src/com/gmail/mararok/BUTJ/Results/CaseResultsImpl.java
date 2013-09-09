/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.TestElement;

public class CaseResultsImpl extends ResultsImpl implements CaseResults {
	private int testsAmount;
	public CaseResultsImpl(TestElement element) {
		super(element);
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
