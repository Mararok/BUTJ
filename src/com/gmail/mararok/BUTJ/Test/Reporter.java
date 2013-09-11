/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Test;

import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.BUTJ.ReportOutput.ReportOutput;
import com.gmail.mararok.BUTJ.Results.CaseResults;
import com.gmail.mararok.BUTJ.Results.ReportResults;
import com.gmail.mararok.BUTJ.Results.SuiteResults;
import com.gmail.mararok.BUTJ.Results.TestResults;

public class Reporter implements ReportOutput {
	private List<ReportOutput> reportOutputs;
	
	public Reporter() {
		this.reportOutputs = new LinkedList<ReportOutput>();
	}
	
	public void addOutput(ReportOutput reportOutput) {
		this.reportOutputs.add(reportOutput);
	}

	@Override
	public void onReportStart(ReportResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onReportStart(results);
		}
	}

	@Override
	public void onReportEnd(ReportResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onReportEnd(results);
		}
	}

	@Override
	public void onSuiteStart(SuiteResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onSuiteStart(results);
		}
	}

	@Override
	public void onSuiteEnd(SuiteResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onSuiteEnd(results);
		}
	}

	@Override
	public void onCaseStart(CaseResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onCaseStart(results);
		}
	}

	@Override
	public void onCaseEnd(CaseResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onCaseEnd(results);
		}
	}

	@Override
	public void onTestStart(TestResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onTestStart(results);
		}
	}

	@Override
	public void onTestEnd(TestResults results) {
		for (ReportOutput reportOutput : reportOutputs) {
			reportOutput.onTestEnd(results);
		}
	}

}
