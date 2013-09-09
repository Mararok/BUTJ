/**
 * BUTJ
 * The MIT License
 * Copyright (C) 2013 Mararok <mararok@gmail.com>
 */
package com.gmail.mararok.BUTJ.Results;

import com.gmail.mararok.BUTJ.Reporter;
import com.gmail.mararok.BUTJ.TestElement;

public class ResultsImpl {
	private TestElement element;
	
	private long startTime;
	private long executeTime;
	
	public ResultsImpl(TestElement element) {
		this.element = element;
	}

	public String getName() {
		return getElement().getName();
	}

	public String getFullName() {
		return getElement().getFullName();
	}
	
	public long getExecuteTime() {
		return executeTime;
	}
	
	protected void onStart() {
		startTime = System.nanoTime();
	}
	
	protected  void onEnd() {
		executeTime = System.nanoTime()-startTime;
	}
	
	protected TestElement getElement() {
		return element;
	}
	
	protected Reporter getReporter() {
		return getElement().getReporter();
	}
}
