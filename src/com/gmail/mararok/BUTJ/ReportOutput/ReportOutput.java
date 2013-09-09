/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.ReportOutput;

import com.gmail.mararok.BUTJ.Results.CaseResults;
import com.gmail.mararok.BUTJ.Results.ReportResults;
import com.gmail.mararok.BUTJ.Results.SuiteResults;
import com.gmail.mararok.BUTJ.Results.TestResults;

public interface ReportOutput {
	public void onReportStart(ReportResults results);
	public void onReportEnd(ReportResults results);
	
	public void onSuiteStart(SuiteResults results);
	public void onSuiteEnd(SuiteResults results);
	
	public void onCaseStart(CaseResults results);
	public void onCaseEnd(CaseResults results);
	
	public void onTestStart(TestResults results);
	public void onTestEnd(TestResults results);
}
