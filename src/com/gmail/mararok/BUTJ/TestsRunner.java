/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import com.gmail.mararok.BUTJ.ReportOutput.ReportOutput;
import com.gmail.mararok.BUTJ.Results.CaseResults;
import com.gmail.mararok.BUTJ.Results.ReportResultsImpl;
import com.gmail.mararok.BUTJ.Results.Results;
import com.gmail.mararok.BUTJ.Results.SuiteResults;

public class TestsRunner extends TestSuiteImpl {
	private Reporter reporter;
	private ReportResultsImpl results;
	public TestsRunner(String rootName) {
		super(rootName);
		reporter = new Reporter();
		results = new ReportResultsImpl(this);
	}
	
	public void run() {
		results.onStart();
			for (TestElementImpl testElement : getList()) {
				testElement.run();
				Results r = testElement.getResults();
			
				if (testElement instanceof TestSuiteImpl) {
					results.addSuites(1+((SuiteResults)r).getSuitesAmount());
					results.addCases( ((SuiteResults)r).getCasesAmount());
				} else {
					results.addCases(1);
					results.addTests(((CaseResults)r).getTestsAmount());
				}
			
			}
			SuiteResults r = (SuiteResults)super.getResults();
			results.addSuites(r.getSuitesAmount());
			results.addCases(r.getCasesAmount());
			results.addTests(r.getTestsAmount());
		results.onEnd();
	}
	
	public void addReportOutput(ReportOutput reportOutput) {
		getReporter().addOutput(reportOutput);
	}
	
	@Override
	public Reporter getReporter() {
		return reporter;
	}
}
