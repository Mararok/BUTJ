/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.TestElement;

public class ReportResultsImpl extends SuiteResultsImpl implements ReportResults {

	public ReportResultsImpl(TestElement element) {
		super(element);
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

}
