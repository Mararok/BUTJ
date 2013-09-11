/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import org.reflections.Reflections;

import com.gmail.mararok.BUTJ.ReportOutput.ReportOutput;
import com.gmail.mararok.BUTJ.Results.CaseResults;
import com.gmail.mararok.BUTJ.Results.ReportResultsImpl;
import com.gmail.mararok.BUTJ.Results.Results;
import com.gmail.mararok.BUTJ.Results.SuiteResults;
import com.gmail.mararok.BUTJ.Test.Reporter;
import com.gmail.mararok.BUTJ.Test.TestElementImpl;
import com.gmail.mararok.BUTJ.Test.TestSuite;

public class TestsRunner extends TestSuite {
	private Reporter reporter;
	private Package mainPackage;
	
	private ReportResultsImpl results;
	
	private Map<String, TestSuite> suites;

	public TestsRunner(String rootName, Package mainPackage) {
		super(rootName);
		this.mainPackage = mainPackage;
		reporter = new Reporter();
		results = new ReportResultsImpl(this);
		suites = new HashMap<String, TestSuite>(); 
		suites.put(mainPackage.getName(),this);
	}
	
	public void run() {
		results.onStart();
			try {
				loadAllSuitesAndCases();
			} catch (InstantiationException|IllegalAccessException e) {
				e.printStackTrace();
			} 
			
			for (TestElementImpl testElement : getList()) {
				testElement.run();
				Results r = testElement.getResults();
			
				if (testElement instanceof TestSuite) {
					results.addSuites(1+((SuiteResults)r).getSuitesAmount());
					results.addCases( ((SuiteResults)r).getCasesAmount());
					results.addTests(((SuiteResults)r).getTestsAmount());
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
	
	private void loadAllSuitesAndCases() throws InstantiationException, IllegalAccessException {
		Set<Class<? extends TestCase>> caseClases = getAllTestCaseClasses();
		
		for (Class<? extends TestCase> caseClass : caseClases) {
			if (isIgnore(caseClass)) {
				continue;
			}
			
			String packageName = caseClass.getPackage().getName();
			TestCase testCase = caseClass.newInstance();
			
			if (packageName == mainPackage.getName()) {
				addCase(testCase);
			} else {
				TestSuite suite = suites.get(packageName); 
				if (suite == null) {
					String[] packageNames = packageName.split("\\.");
					StringBuilder sb = new StringBuilder(packageNames[0]);
					for (int i = 1, len = packageNames.length-1; i < len;++i) {
						sb.append(".");
						sb.append(packageNames[i]);
					}
					String parentSuiteName = sb.toString();
					String suiteName = packageNames[packageNames.length-1];
					suite = new TestSuite(suiteName);
					suites.get(parentSuiteName).addSuite(suite);
					suites.put(packageName,suite);
				}
				suite.addCase(testCase);
			}
		}
	}
	
	private Set<Class<? extends TestCase>> getAllTestCaseClasses() {
		return new Reflections(mainPackage.getName()).getSubTypesOf(TestCase.class);
	}
	
	private boolean isIgnore(Class<? extends TestCase> caseClass) {
		return caseClass.getAnnotation(IGNORE.class) != null;
	}

	@Override
	public Reporter getReporter() {
		return reporter;
	}
}
