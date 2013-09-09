/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.TestElement;

public class SuiteResultsImpl extends CaseResultsImpl implements SuiteResults {
	private int suitesAmount;
	private int casesAmount;
	
	public SuiteResultsImpl(TestElement<SuiteResultsImpl> element) {
		super(element);
	}

	public void incSuites() {
		++suitesAmount;
	}
	
	public void incCases() {
		++casesAmount;
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

}
