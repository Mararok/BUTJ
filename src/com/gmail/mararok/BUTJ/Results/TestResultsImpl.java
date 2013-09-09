/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import java.util.LinkedList;
import java.util.List;

import com.gmail.mararok.BUTJ.TestEnviroment;

public class TestResultsImpl extends ResultsImpl implements TestResults {
	private String description;
	private List<UnexpectedResult> unexceptedResults;
	
	public TestResultsImpl(TestEnviroment test) {
		super(test);
		this.unexceptedResults = new LinkedList<UnexpectedResult>();
	}
	
	@Override
	public void onStart() {
		getReporter().onTestStart(this);
		super.onStart();
	}
	
	@Override
	public void onEnd() {
		super.onEnd();
		getReporter().onTestEnd(this);
	}
	
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}
	
	@Override
	public String getDescription() {
		return description;
	}
	
	public void addUnexceptedResults(String matchMessage, StackTraceElement position) {
		unexceptedResults.add(new UnexpectedResult(matchMessage,position));
	}
	
	@Override
	public List<UnexpectedResult> getUnexpectedResults() {
		return this.unexceptedResults;
	}
}
