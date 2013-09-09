/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import com.gmail.mararok.BUTJ.ReportOutput.ReportOutput;
import com.gmail.mararok.BUTJ.Results.ReportResultsImpl;

public class TestsRunner extends TestSuite {
	private Reporter reporter;
	private ReportResultsImpl results;
	public TestsRunner(String rootName) {
		super(rootName);
		reporter = new Reporter();
		results = new ReportResultsImpl(this);
	}
	
	public void run() {
		results.onStart();
			super.run();
		results.onEnd();
	}
	
	public void addReportOutput(ReportOutput reportOutput) {
		getReporter().addOutput(reportOutput);
	}
	
	@Override
	Reporter getReporter() {
		return reporter;
	}
}
