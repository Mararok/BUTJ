/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Test;

import com.gmail.mararok.BUTJ.TestCase;
import com.gmail.mararok.BUTJ.Results.CaseResults;
import com.gmail.mararok.BUTJ.Results.Results;
import com.gmail.mararok.BUTJ.Results.SuiteResults;
import com.gmail.mararok.BUTJ.Results.SuiteResultsImpl;

public class TestSuite extends TestElementContainer {
	private SuiteResultsImpl results;
	public TestSuite(String name) {
		super(name);
		results = new SuiteResultsImpl(this);
	}
	
	@Override
	public void run() {
		results.onStart();
		for (TestElementImpl testElement : getList()) {
			testElement.run();
			Results r = testElement.getResults();
			
			if (testElement instanceof TestSuite) {
				results.addSuites(1+((SuiteResults)r).getSuitesAmount());
				results.addCases( ((SuiteResults)r).getCasesAmount());
			} else {
				results.addCases(1);
				results.addTests(((CaseResults)r).getTestsAmount());
			}
			
		}
		results.onEnd();
	}
	
	public void addCase(TestCase testCase) {
		add(new TestCaseImpl(testCase));
	}

	public void addSuite(TestSuite suite) {
		add(suite);
	}
	
	@Override
	public Results getResults() {
		return results;
	}
}
