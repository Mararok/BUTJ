/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.ReportOutput;

import java.util.List;

import com.gmail.mararok.BUTJ.Results.CaseResults;
import com.gmail.mararok.BUTJ.Results.ReportResults;
import com.gmail.mararok.BUTJ.Results.SuiteResults;
import com.gmail.mararok.BUTJ.Results.TestResults;
import com.gmail.mararok.BUTJ.Results.UnexpectedResult;

public class ConsoleReportOutput implements ReportOutput {
	private StringBuilder paddingLevelBuffer = new StringBuilder();
	private int paddingLevel;
	@Override
	public void onReportStart(ReportResults results) {
		printf("Report %s \n",results.getName());
		println("##############################################################");
		incLevel();
	}

	@Override
	public void onReportEnd(ReportResults results) {
		decLevel();
		println("##############################################################");
		printf("Report end in %f s \n",(double)results.getExecuteTime()/1000.0);
		printf("%d suites, %d cases, %d tests \n",
				results.getSuitesAmount(),results.getCasesAmount(),results.getTestsAmount());
	}

	@Override
	public void onSuiteStart(SuiteResults results) {
		printf("S:%s \n",results.getName());
		incLevel();
	}

	@Override
	public void onSuiteEnd(SuiteResults results) {
		decLevel();
		printf("S:%s end in %f s \n",results.getName(),(double)results.getExecuteTime()/1000.0);
	}

	@Override
	public void onCaseStart(CaseResults results) {
		printf("C:%s \n",results.getName());
		incLevel();
		
	}

	@Override
	public void onCaseEnd(CaseResults results) {
		decLevel();
		printf("C:%s end in %f s \n",results.getName(),(double)results.getExecuteTime()/1000.0);
	}

	@Override
	public void onTestStart(TestResults results) {
		printf("%s ",results.getName());
		incLevel();
	}

	@Override
	public void onTestEnd(TestResults results) {
		List<UnexpectedResult> ers = results.getUnexpectedResults();
		if (ers.size() > 0 ) {
			println("");
			for (UnexpectedResult er : ers) {
				printf("%s:%d expected %s \n",er.getSourceName(),er.getLineNumber(),er.getMatchMessage());
			}
			decLevel();
			printf("%s end in %f s \n",results.getName(),(double)results.getExecuteTime()/1000.0);
		} else {
			System.out.printf("end in %f s \n",(double)results.getExecuteTime()/1000.0);
			decLevel();
		}
	}
	
	private void println(String message) {
		System.out.println(paddingLevelBuffer.toString()+message);
	}
	
	private void incLevel() {
		++paddingLevel;
		paddingLevelBuffer.append("#");
	}
	
	private void decLevel() {
		--paddingLevel;
		paddingLevelBuffer.setLength(paddingLevel);
	}
	
	private void printf(String format, Object...args) {
		System.out.printf(paddingLevelBuffer.toString()+format,args);
	}
}
