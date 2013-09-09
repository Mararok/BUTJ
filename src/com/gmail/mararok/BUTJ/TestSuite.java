/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ;

import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.BUTJ.Results.SuiteResultsImpl;

public class TestSuite extends TestElement<SuiteResultsImpl> {
	private List<TestElement<ResultsImpl>> testElements;
	public TestSuite(String name) {
		super(name);
		testElements = new LinkedList<TestElement>();
	}
	
	@Override
	void run() {
		results.onStart();
		for (TestElement testElement : testElements) {
			if (testElement instanceof TestSuite) {
				results.incSuites();
			}
			testElement.run();
		}
		results.onEnd();
	}
	
	void add(TestElement testElement) {
		testElement.setParent(this);
		testElements.add(testElement);
	}
	
	List<TestElement> getList() {
		return testElements;
	}
}
